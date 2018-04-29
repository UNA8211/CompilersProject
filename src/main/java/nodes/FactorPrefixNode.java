package nodes;

public class FactorPrefixNode extends ASTNode {
    public FactorPrefixNode prefix;
    public PostfixNode postfix;
    public MulopNode mulOp;

    public FactorPrefixNode() {

    }

    @Override
    public boolean isNull() {
        if (prefix == null && postfix == null && mulOp == null) {
            return true;
        }
        return false;
    }
}
