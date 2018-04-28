package nodes;

public class VarTypeNode extends ASTNode {
    public String type;

    public VarTypeNode(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
