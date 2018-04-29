package nodes;

public class VarTypeNode extends ASTNode {
    public String type;

    public VarTypeNode(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public boolean isNull() {
        if (type == null) {
            return true;
        }
        return false;
    }
}
