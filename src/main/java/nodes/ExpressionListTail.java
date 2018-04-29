package nodes;

public class ExpressionListTail extends ASTNode {
    public ExpressionNode expr;
    public ExpressionListTail tail;

    @Override
    public boolean isNull() {
        if (expr == null && tail == null) {
            return true;
        }
        return false;
    }
}
