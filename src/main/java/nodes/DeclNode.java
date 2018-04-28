package nodes;

public class DeclNode extends ASTNode {
    public VarDeclNode varDecl = null;
    public DeclNode decl = null;

    public DeclNode() {}

    @Override
    public String toString() {
        return (varDecl == null ? "" : varDecl.toString()) + " " + (decl == null ? "" : decl.toString());
    }
}