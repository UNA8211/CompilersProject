package nodes;

public class ExpressionNode extends ASTNode {
    public ExpressionPrefix prefix;
    public FactorNode factor;

    public ExpressionNode() {}

    @Override
    public boolean isNull() {
        if (prefix == null && factor == null) {
            return true;
        }
        return false;
    }
}
