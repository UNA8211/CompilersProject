package nodes;

public class FuncDecl extends ASTNode {
    public FuncDeclNode funcDecl;
    public FuncDecl funcDeclaration;

    public FuncDecl() {

    }

    @Override
    public boolean isNull() {
        if (funcDecl == null && funcDeclaration == null) {
            return true;
        }
        return false;
    }
}
