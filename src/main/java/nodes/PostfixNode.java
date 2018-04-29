package nodes;

public class PostfixNode extends ASTNode {
    public PrimaryNode primary;

    public PostfixNode() {

    }

    @Override
    public boolean isNull() {
        if (primary == null) {
            return true;
        }
        return false;
    }
}
