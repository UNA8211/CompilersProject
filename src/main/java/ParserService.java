import nodes.ASTNode;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.LinkedHashMap;
import java.util.Map;

public class ParserService {
    LittleParser littleParser = null;

    public ParserService(CommonTokenStream commonTokenStream) {
        littleParser = new LittleParser(commonTokenStream);
        littleParser.removeErrorListeners();
    }

    public void parse() {
        LittleBaseListener listener = new LittleBaseListener();
        ASTListener ast = new ASTListener();
        littleParser.addParseListener(ast);
        ParseTree context = littleParser.program();
        printAST(ast.prev);
        CodeGenerator cg = new CodeGenerator(ast.prev);
        cg.begin();
        ParseTreeWalker.DEFAULT.walk(listener, context);
        if (littleParser.getNumberOfSyntaxErrors() != 0) {
            System.err.println("ERROR: INPUT FILE CONTAINED SYNTAX ERRORS");
            System.exit(1);
        }
//        printTable(listener);
    }

    public void printAST(ASTNode starting) {
        System.out.println(starting.toString());
    }

    public void printTable(LittleBaseListener listener) {
        if (listener.getScopeErrors().size() > 0) {
            System.out.print("DECLARATION ERROR " + listener.getScopeErrors().get(0));
            // Does capture all scope errors but he only wants one printed out so idk
//            for (String error : listener.getScopeErrors()) {
//                System.out.print(error + ' ');
//            }
            return;
        }

        for (Map.Entry<String, LinkedHashMap<String, Pair<String, String>>> entry : listener.getScope().entrySet()) {
            System.out.println("Symbol table " + entry.getKey());
            for (Map.Entry<String, Pair<String, String>> set : entry.getValue().entrySet()) {
                System.out.print("name " + set.getKey() + " type " + set.getValue().a);
                System.out.println(set.getValue().b == null ? "" : " value " + set.getValue().b);
            }
            System.out.println();
        }
    }
}
