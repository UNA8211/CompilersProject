import org.antlr.v4.runtime.CommonTokenStream;

public class ParserService {
    LittleParser littleParser = null;

    public ParserService(CommonTokenStream commonTokenStream) {
        littleParser = new LittleParser(commonTokenStream);
        //littleParser.removeErrorListeners();
    }

    public void parse() {
        littleParser.program();
        if (littleParser.getNumberOfSyntaxErrors() == 0) {
            System.out.println("Accepted");
        } else {
            System.out.println("Not accepted");
        }
    }
}
