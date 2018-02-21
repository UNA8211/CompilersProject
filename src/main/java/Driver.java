import org.antlr.v4.runtime.*;

public class Driver {
    public static void main (String[] args) throws Exception{
        String fileName = "C:\\Users\\Ryan Brand\\Documents\\S2018\\CSCI468\\CompilerProject\\src\\main\\java\\parse_file.txt";
        CharStream input = CharStreams.fromFileName(fileName);
        LexerService lexerService = new LexerService(input);
        ParserService parserService = new ParserService(lexerService.getCommonTokenStream());
        parserService.parse();
    }
}
