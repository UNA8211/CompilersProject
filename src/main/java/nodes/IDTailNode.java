package nodes;

public class IDTailNode extends ASTNode {
    public char comma = ',';
    public IDNode identifier = null;
    public IDTailNode tail = null;

    public IDTailNode() {

    }

    @Override
    public String toString() {
        return (identifier == null ? "" : identifier.toString()) + " " + (tail == null ? "" : tail.toString());
    }
}
