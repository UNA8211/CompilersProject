import nodes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodeGenerator {

    private ASTNode root;
    HashMap<String, String> vars;

    public CodeGenerator(ASTNode root) {
        this.root = root;
        vars = new HashMap<String, String>();
    }

    public void begin() {
        if (root instanceof ProgramBodyNode) {
            walkThroughProgramBody((ProgramBodyNode) root);
        }
    }

    public void walkThroughProgramBody(ProgramBodyNode node) {
        if (node.decl != null) {
            walkThroughDecl(node.decl);
        }

        if (node.funcDecl != null) {
            walkThroughFuncDeclarations(node.funcDecl);
        }
    }

    public void walkThroughFuncDeclarations(FuncDecl funcDecl) {
        if (funcDecl.funcDecl != null) {
            walkThroughFuncDecl(funcDecl.funcDecl);
        }
    }

    public void walkThroughFuncDecl(FuncDeclNode funcDeclNode) {
        System.out.println("label " + funcDeclNode.id.toString());

        walkThroughFuncBody(funcDeclNode.funcBody);
    }

    public void walkThroughFuncBody(FuncBodyNode funcBody) {
        if (funcBody.decl != null) {
            walkThroughDecl(funcBody.decl);
        }

        if (funcBody.stmtList != null) {
            walkThroughStatementList(funcBody.stmtList);
        }
    }

    public void walkThroughStatementList(StatementListNode stmtList) {
        if (stmtList.stmt != null) {
            walkThroughStatement(stmtList.stmt);
        }

        if (stmtList.statementList != null) {
            walkThroughStatementList(stmtList.statementList);
        }
    }

    public void walkThroughStatement(StatementNode stmt) {
        if (stmt.baseStmt != null) {
            walkThroughBaseStatement(stmt.baseStmt);
        }
    }

    public void walkThroughBaseStatement(BaseStatements base) {
        walkThroughAssignmentStatement(base.assignment);
    }

    public void walkThroughAssignmentStatement(AssignStatementNode assign) {
        walkThroughAssignmentExpression(assign.assignmentExpr);
    }

    public void walkThroughAssignmentExpression(AssignmentExprNode assign) {
        String identifier = assign.identifier.toString();
        walkThroughExpr(assign.expr);
    }

    public void walkThroughExpr(ExpressionNode expression) {
        if (expression.prefix != null) {
            walkThroughExprPrefix(expression.prefix);
        }
    }

    public void walkThroughExprPrefix(ExpressionPrefix prefix) {
        if (prefix.prefix != null) {
            walkThroughExprPrefix(prefix.prefix);
        }
    }

    public void walkThroughFactor(FactorNode factor) {

    }

    public void walkThroughFactorPrefix(FactorPrefixNode prefix) {

    }

    public void walkThroughPostFix(PostfixNode postfix) {

    }

    public void walkThroughDecl(DeclNode declNode) {
        walkThroughVarDecl(declNode.varDecl);
        if (declNode.decl != null) {
            walkThroughDecl(declNode.decl);
        }
    }

    public void walkThroughVarDecl(VarDeclNode varDeclNode) {
        String type = varDeclNode.type.toString();
        List<String> ids = walkThroughIDList(varDeclNode.idList);
        for (String id : ids) {
            System.out.println("var " + id);
            vars.put(id, type);
        }
    }

    public List<String> walkThroughIDList(IDListNode idListNode) {
        List<String> ids = new ArrayList<String>();
        ids.add(idListNode.identifier.toString());
        if (idListNode.tail != null) {
            ids.addAll(walkThroughTail(idListNode.tail));
        }
        return ids;
    }

    public List<String> walkThroughTail (IDTailNode tail) {
        List<String> ids = new ArrayList<String>();
        ids.add(tail.identifier.toString());
        if (tail.tail != null && tail.tail.identifier != null) {
            ids.addAll(walkThroughTail(tail.tail));
        }
        return ids;
    }
}
