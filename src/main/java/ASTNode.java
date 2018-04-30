import java.util.ArrayList;

public class ASTNode {

    public ASTNode(){}

    public static class AddOperator extends ASTNode {
        public Integer sign;

        public AddOperator(int sign) {
            this.sign = sign;
        }

        
        public boolean isNull() {
            if (sign == null) {
                return true;
            }
            return false;
        }
    }

    public static class AssignmentExprNode extends ASTNode {
        public IDNode identifier;
        public ExpressionNode expr;

        public AssignmentExprNode() {

        }

        
        public boolean isNull() {
            if (identifier == null && expr == null) {
                return true;
            }
            return false;
        }
    }
    

    public static class AssignStatementNode extends ASTNode {

        public AssignmentExprNode assignmentExpr;

        public AssignStatementNode() {

        }

        
        public boolean isNull() {
            if (assignmentExpr == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class BaseStatements extends ASTNode{
        public AssignStatementNode assignment;
        public ReadNode read;
        public WriteNode write;

        public BaseStatements() {

        }

        
        public boolean isNull() {
            if (assignment == null && read == null && write == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class DeclNode extends ASTNode {
        public VarDeclNode varDecl = null;
        public StringDeclNode stringDecl = null;
        public DeclNode decl = null;

        public DeclNode() {}

        
        public boolean isNull() {
            if (varDecl == null && decl == null && stringDecl != null) {
                return true;
            }
            return false;
        }

    }


    public static class StringDeclNode extends ASTNode {
        public IDNode identifier;
        public String value;

        public StringDeclNode() {

        }

        public boolean isNull() {
            if (identifier == null && value == null) {
                return true;
            }
            return false;
        }
    }
    

    public static class ExpressionList extends ASTNode {
        public ExpressionNode expr;
        public ExpressionListTail tail;

        public ExpressionList() {

        }

        
        public boolean isNull() {
            if (expr == null && tail == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class ExpressionListTail extends ASTNode {
        public ExpressionNode expr;
        public ExpressionListTail tail;

        
        public boolean isNull() {
            if (expr == null && tail == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class ExpressionNode extends ASTNode {
        public ExpressionPrefix prefix;
        public FactorNode factor;

        public ExpressionNode() {}

        
        public boolean isNull() {
            if (prefix == null && factor == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class ExpressionPrefix extends ASTNode {
        public ExpressionPrefix prefix;
        public FactorNode factor;
        public AddOperator addOp;

        public ExpressionPrefix() {

        }

        
        public boolean isNull() {
            if (prefix == null && factor == null && addOp == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class FactorNode extends ASTNode {
        public FactorPrefixNode prefix;
        public PostfixNode postfix;

        public FactorNode() {

        }

        
        public boolean isNull() {
            if (prefix == null && postfix == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class FactorPrefixNode extends ASTNode {
        public FactorPrefixNode prefix;
        public PostfixNode postfix;
        public MulopNode mulOp;

        public FactorPrefixNode() {

        }

        
        public boolean isNull() {
            if (prefix == null && postfix == null && mulOp == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class FuncBodyNode extends ASTNode {
        public DeclNode decl;
        public StatementListNode stmtList;

        public FuncBodyNode() {

        }

        
        public boolean isNull() {
            if (decl == null && stmtList == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class FuncDecl extends ASTNode {
        public FuncDeclNode funcDecl;
        public FuncDecl funcDeclaration;

        public FuncDecl() {

        }

        
        public boolean isNull() {
            if (funcDecl == null && funcDeclaration == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class FuncDeclNode extends ASTNode {
        public IDNode id;
        public FuncBodyNode funcBody;

        public FuncDeclNode() {

        }

        
        public boolean isNull() {
            if (id == null && funcBody == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class IDListNode extends ASTNode {
        public IDNode identifier;
        public IDTailNode tail;

        public IDListNode() {}

        
        public String toString() {
            return (identifier == null ? "" : identifier.toString()) + " " + (tail == null ? "" : tail.toString());
        }

        
        public boolean isNull() {
            if (identifier == null && tail == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class IDNode extends ASTNode {
        public String val;

        public IDNode(String val) {
            this.val = val;
        }

        
        public String toString() {
            return val;
        }

        
        public boolean isNull() {
            if (val == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class IDTailNode extends ASTNode {
        public char comma = ',';
        public IDNode identifier = null;
        public IDTailNode tail = null;

        public IDTailNode() {

        }

        
        public String toString() {
            return (identifier == null ? "" : identifier.toString()) + " " + (tail == null ? "" : tail.toString());
        }

        
        public boolean isNull() {
            if (identifier == null && tail == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class MulopNode extends ASTNode {
        public Integer op;

        public MulopNode(int op) {
            this.op = op;
        }

        
        public boolean isNull() {
            if (op == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class PostfixNode extends ASTNode {
        public PrimaryNode primary;

        public PostfixNode() {

        }

        
        public boolean isNull() {
            if (primary == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class PrimaryNode extends ASTNode {
        public IDNode id;
        public Integer intLiteral;
        public Float floatLiteral;
        public ExpressionNode expressionNode;

        public PrimaryNode() {

        }

        
        public boolean isNull() {
            if (id == null && intLiteral == null && floatLiteral == null && expressionNode == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class ProgramBodyNode extends ASTNode {
        public DeclNode decl;
        public FuncDecl funcDecl;

        public ProgramBodyNode() {}

        
        public boolean isNull() {
            if (decl == null && funcDecl == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class StatementListNode extends ASTNode {
        public StatementNode stmt;
        public StatementListNode statementList;

        public StatementListNode() {

        }

        
        public boolean isNull() {
            if (stmt == null && statementList == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class StatementNode extends ASTNode {
        public BaseStatements baseStmt;

        public StatementNode() {

        }

        
        public boolean isNull() {
            if (baseStmt == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class VarDeclNode extends ASTNode {
        public VarTypeNode type = null;
        public IDListNode idList = null;

        public VarDeclNode() {}

        
        public String toString() {
            return (type == null ? "" : type.toString()) + " " + (idList == null ? "" : idList.toString());
        }

        
        public boolean isNull() {
            if (type == null && idList == null) {
                return true;
            }
            return false;
        }
    }

    

    public static class VarTypeNode extends ASTNode {
        public String type;

        public VarTypeNode(String type) {
            this.type = type;
        }

        
        public String toString() {
            return type;
        }

        
        public boolean isNull() {
            if (type == null) {
                return true;
            }
            return false;
        }
    }

    public static class ReadNode extends ASTNode {
        public IDListNode idList;

        public boolean isNull() {
            if (idList == null) {
                return true;
            }
            return false;
        }
    }

    public static class WriteNode extends ASTNode {
        public IDListNode idList;

        public boolean isNull() {
            if (idList == null) {
                return true;
            }
            return false;
        }
    }


}


