package nodes;

public class ProgramBodyNode extends ASTNode {
    public DeclNode decl;
    public FuncDecl funcDecl;

    public ProgramBodyNode() {}

    @Override
    public boolean isNull() {
        if (decl == null && funcDecl == null) {
            return true;
        }
        return false;
    }
}
