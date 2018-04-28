package nodes;

public class VarDeclNode extends ASTNode {
    public VarTypeNode type = null;
    public IDListNode idList = null;

    public VarDeclNode() {}

    @Override
    public String toString() {
        return (type == null ? "" : type.toString()) + " " + (idList == null ? "" : idList.toString());
    }
}