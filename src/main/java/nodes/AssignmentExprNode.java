package nodes;

public class AssignmentExprNode extends ASTNode {
    public IDNode identifier;
    public ExpressionNode expr;

    public AssignmentExprNode() {

    }

    @Override
    public boolean isNull() {
        if (identifier == null && expr == null) {
            return true;
        }
        return false;
    }
}
