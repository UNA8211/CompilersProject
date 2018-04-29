package nodes;

public class BaseStatements extends ASTNode{
    public AssignStatementNode assignment;

    public BaseStatements() {

    }

    @Override
    public boolean isNull() {
        if (assignment == null) {
            return true;
        }
        return false;
    }
}
