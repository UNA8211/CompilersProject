package nodes;

public class IDNode extends ASTNode {
    public String val;

    public IDNode(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }

    @Override
    public boolean isNull() {
        if (val == null) {
            return true;
        }
        return false;
    }
}
