package nodes;

public class IDListNode extends ASTNode {
    public IDNode identifier;
    public IDTailNode tail;

    public IDListNode() {}

    @Override
    public String toString() {
        return (identifier == null ? "" : identifier.toString()) + " " + (tail == null ? "" : tail.toString());
    }

    @Override
    public boolean isNull() {
        if (identifier == null && tail == null) {
            return true;
        }
        return false;
    }
}
