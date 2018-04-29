package nodes;

public class ExpressionPrefix extends ASTNode {
    public ExpressionPrefix prefix;
    public FactorNode factor;
    public AddOperator addOp;

    public ExpressionPrefix() {

    }

    @Override
    public boolean isNull() {
        if (prefix == null && factor == null && addOp == null) {
            return true;
        }
        return false;
    }
}
