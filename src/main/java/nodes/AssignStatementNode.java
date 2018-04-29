package nodes;

public class AssignStatementNode extends ASTNode {

    public AssignmentExprNode assignmentExpr;

    public AssignStatementNode() {

    }

    @Override
    public boolean isNull() {
        if (assignmentExpr == null) {
            return true;
        }
        return false;
    }
}
