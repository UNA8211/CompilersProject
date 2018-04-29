package nodes;

public class FactorNode extends ASTNode {
    public FactorPrefixNode prefix;
    public PostfixNode postfix;

    public FactorNode() {

    }

    @Override
    public boolean isNull() {
        if (prefix == null && postfix == null) {
            return true;
        }
        return false;
    }
}
