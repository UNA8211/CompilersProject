package nodes;

public class FuncBodyNode extends ASTNode {
    public DeclNode decl;
    public StatementListNode stmtList;

    public FuncBodyNode() {

    }

    @Override
    public boolean isNull() {
        if (decl == null && stmtList == null) {
            return true;
        }
        return false;
    }
}
