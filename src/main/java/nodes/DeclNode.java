package nodes;

public class DeclNode extends ASTNode {
    public VarDeclNode varDecl = null;
    public DeclNode decl = null;

    public DeclNode() {}

    @Override
    public boolean isNull() {
        if (varDecl == null && decl == null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return (varDecl == null ? "" : varDecl.toString()) + " " + (decl == null ? "" : decl.toString());
    }
}
