package nodes;

public class FuncDeclNode extends ASTNode {
    public IDNode id;
    public FuncBodyNode funcBody;

    public FuncDeclNode() {

    }

    @Override
    public boolean isNull() {
        if (id == null && funcBody == null) {
            return true;
        }
        return false;
    }
}
