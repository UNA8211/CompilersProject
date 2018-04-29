package nodes;

public class ExpressionList extends ASTNode {
    public ExpressionNode expr;
    public ExpressionListTail tail;

    public ExpressionList() {

    }

    @Override
    public boolean isNull() {
        if (expr == null && tail == null) {
            return true;
        }
        return false;
    }
}
