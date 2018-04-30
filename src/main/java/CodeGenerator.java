import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodeGenerator {

    private ASTNode root;
    HashMap<String, String> vars;

    int currentTemp;

    public CodeGenerator(ASTNode root) {
        this.root = root;
        vars = new HashMap<String, String>();
    }

    public void begin() {
        if (root instanceof ASTNode.ProgramBodyNode) {
            walkThroughProgramBody((ASTNode.ProgramBodyNode) root);
        }
        System.out.println("sys halt");
    }

    public void walkThroughProgramBody(ASTNode.ProgramBodyNode node) {
        if (node.decl != null) {
            walkThroughDecl(node.decl);
        }

        if (node.funcDecl != null) {
            walkThroughFuncDeclarations(node.funcDecl);
        }
    }

    public void walkThroughFuncDeclarations(ASTNode.FuncDecl funcDecl) {
        if (funcDecl.funcDecl != null) {
            walkThroughFuncDecl(funcDecl.funcDecl);
        }
    }

    public void walkThroughFuncDecl(ASTNode.FuncDeclNode funcDeclNode) {
        System.out.println("label " + funcDeclNode.id.toString());

        walkThroughFuncBody(funcDeclNode.funcBody);
    }

    public void walkThroughFuncBody(ASTNode.FuncBodyNode funcBody) {
        if (funcBody.decl != null) {
            walkThroughDecl(funcBody.decl);
        }

        if (funcBody.stmtList != null) {
            walkThroughStatementList(funcBody.stmtList);
        }
    }

    public void walkThroughStatementList(ASTNode.StatementListNode stmtList) {
        if (stmtList.stmt != null) {
            walkThroughStatement(stmtList.stmt);
        }

        if (stmtList.statementList != null) {
            walkThroughStatementList(stmtList.statementList);
        }
    }

    public void walkThroughStatement(ASTNode.StatementNode stmt) {
        if (stmt.baseStmt != null) {
            walkThroughBaseStatement(stmt.baseStmt);
        }
    }

    public void walkThroughBaseStatement(ASTNode.BaseStatements base) {
        if (base.assignment != null) {
            walkThroughAssignmentStatement(base.assignment);
        }

        if (base.read != null) {
            walkThroughRead(base.read);
        }

        if (base.write != null) {
            walkThroughWrite(base.write);
        }
    }

    private void walkThroughWrite(ASTNode.WriteNode write) {
        List<String> readLines = walkThroughIDList(write.idList);
        for (String line : readLines) {
            char varType = vars.get(line).toLowerCase().charAt(0);
            System.out.print("sys write" + varType + ' ');
            System.out.println(line);
        }
    }

    private void walkThroughRead(ASTNode.ReadNode read) {
        List<String> readLines = walkThroughIDList(read.idList);
        for (String line : readLines) {
            System.out.print("sys read" + (vars.get(line).equals("INT") ? "i " : "f "));
            System.out.println(line);
        }
    }

    public void walkThroughAssignmentStatement(ASTNode.AssignStatementNode assign) {
        walkThroughAssignmentExpression(assign.assignmentExpr);
    }

    public void walkThroughAssignmentExpression(ASTNode.AssignmentExprNode assign) {
        GenericTreeNode top = new GenericTreeNode();
        top.type = "Assignment";
        top.val = ":=";
        String identifier = assign.identifier.toString();
        GenericTreeNode assignee = new GenericTreeNode();
        assignee.type = "Identifier";
        assignee.val = identifier;
        assignee.parent = top;
        top.children.add(assignee);
        walkThroughExpr(assign.expr, top);
        createAssignmentCode(top);
    }

    private void createAssignmentCode(GenericTreeNode node) {
        GenericTreeNode currentNode = node;
        while (!currentNode.children.isEmpty()) {
            currentNode = currentNode.children.get(1);
        }
        while (currentNode.parent != null) {
            if (currentNode.type.equals("Identifier")) {
                System.out.println("move " + currentNode.val + " r" + currentTemp++);
            }

            if (currentNode.type.equals("Intliteral")) {
                System.out.println("move " + currentNode.val + " r" + currentTemp++);
            }

            if (currentNode.type.equals("AddOp")) {
                System.out.println((currentNode.val.equals("+") ? "addi" : "subi") + ' ' + currentNode.children.get(0).val + " r" + (currentTemp - 1));
            }
            currentNode = currentNode.parent;
        }
        System.out.println("move r" + (currentTemp - 1) + " " + currentNode.children.get(0).val);

    }

    public void walkThroughExpr(ASTNode.ExpressionNode expression, GenericTreeNode parent) {
        if (expression.prefix != null) {
            walkThroughExprPrefix(expression.prefix, parent);
        }

        if (expression.factor != null) {
            walkThroughFactor(expression.factor, parent.children.size() <= 1 ? parent : parent.children.get(1));
        }
    }

    public void walkThroughExprPrefix(ASTNode.ExpressionPrefix prefix, GenericTreeNode parent) {
        if (prefix.prefix != null) {
            walkThroughExprPrefix(prefix.prefix, parent);
        }

        if (prefix.factor != null) {
            walkThroughFactor(prefix.factor, parent.children.size() <= 1 ? parent : parent.children.get(1));
        }

        if (prefix.addOp != null) {
            walkThroughAddOp(prefix.addOp, parent);
        }
    }

    public void walkThroughAddOp(ASTNode.AddOperator addOp, GenericTreeNode parent) {
        if (addOp != null) {
            GenericTreeNode node = new GenericTreeNode();
            node.type = "AddOp";
            if (addOp.sign == 0) {
                node.val = "+";
            } else {
                node.val = "-";
            }
            node.children.add(parent.children.get(1));
            parent.children.remove(1);
            parent.children.add(node);
            node.parent = parent;
        }
    }

    public void walkThroughFactor(ASTNode.FactorNode factor, GenericTreeNode parent) {
        if (factor.prefix != null) {
            walkThroughFactorPrefix(factor.prefix, parent);
        }

        if (factor.postfix != null) {
            walkThroughPostFix(factor.postfix, parent);
        }
    }

    public void walkThroughFactorPrefix(ASTNode.FactorPrefixNode prefix, GenericTreeNode parent) {

    }

    public void walkThroughPostFix(ASTNode.PostfixNode postfix, GenericTreeNode parent) {
        if (postfix.primary != null) {
            walkThroughPrimary(postfix.primary, parent);
        }
    }

    public void walkThroughPrimary(ASTNode.PrimaryNode primary, GenericTreeNode parent) {
        GenericTreeNode node = new GenericTreeNode();
        if (primary.id != null) {
            node.val = primary.id.val;
            node.type = "Identifier";
            parent.children.add(node);
            node.parent = parent;
        } else if (primary.intLiteral != null) {
            node.val = primary.intLiteral.toString();
            node.type = "Intliteral";
            parent.children.add(node);
            node.parent = parent;
        }
    }

    public void walkThroughDecl(ASTNode.DeclNode declNode) {
        if (declNode.varDecl != null) {
            walkThroughVarDecl(declNode.varDecl);
        } else if (declNode.stringDecl != null) {
            walkThroughStringDecl(declNode.stringDecl);
        }

        if (declNode.decl != null) {
            walkThroughDecl(declNode.decl);
        }
    }

    public void walkThroughVarDecl(ASTNode.VarDeclNode varDeclNode) {
        String type = varDeclNode.type.toString();
        List<String> ids = walkThroughIDList(varDeclNode.idList);
        for (String id : ids) {
            System.out.println("var " + id);
            vars.put(id, type);
        }
    }

    public void walkThroughStringDecl(ASTNode.StringDeclNode stringDeclNode) {
        vars.put(stringDeclNode.identifier.toString(), "STRING");
        System.out.println("str " + stringDeclNode.identifier + " " + stringDeclNode.value);
    }

    public List<String> walkThroughIDList(ASTNode.IDListNode idListNode) {
        List<String> ids = new ArrayList<String>();
        ids.add(idListNode.identifier.toString());
        if (idListNode.tail != null) {
            ids.addAll(walkThroughTail(idListNode.tail));
        }
        return ids;
    }

    public List<String> walkThroughTail (ASTNode.IDTailNode tail) {
        List<String> ids = new ArrayList<String>();
        ids.add(tail.identifier.toString());
        if (tail.tail != null && tail.tail.identifier != null) {
            ids.addAll(walkThroughTail(tail.tail));
        }
        return ids;
    }
}
