// Generated from Little.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LittleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, STRING=2, BEGIN=3, END=4, FUNCTION=5, READ=6, FLOAT=7, INT=8, 
		VOID=9, WRITE=10, RETURN=11, IF=12, ENDIF=13, ELSE=14, WHILE=15, ENDWHILE=16, 
		WHITESPACE=17, NEWLINE=18, RETURNCHAR=19, TAB=20, IDENTIFIER=21, INTLITERAL=22, 
		FLOATLITERAL=23, STRINGLITERAL=24, COMMENT=25, OTHEROP=26, ASSIGNMENT=27, 
		SEMICOLON=28, COMMA=29, OPENPAREN=30, CLOSEPAREN=31, PLUS=32, MINUS=33, 
		MULTIPLY=34, DIVIDE=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PROGRAM", "STRING", "BEGIN", "END", "FUNCTION", "READ", "FLOAT", "INT", 
		"VOID", "WRITE", "RETURN", "IF", "ENDIF", "ELSE", "WHILE", "ENDWHILE", 
		"WHITESPACE", "NEWLINE", "RETURNCHAR", "TAB", "IDENTIFIER", "INTLITERAL", 
		"FLOATLITERAL", "STRINGLITERAL", "COMMENT", "OTHEROP", "ASSIGNMENT", "SEMICOLON", 
		"COMMA", "OPENPAREN", "CLOSEPAREN", "PLUS", "MINUS", "MULTIPLY", "DIVIDE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'PROGRAM'", "'STRING'", "'BEGIN'", "'END'", "'FUNCTION'", "'READ'", 
		"'FLOAT'", "'INT'", "'VOID'", "'WRITE'", "'RETURN'", "'IF'", "'ENDIF'", 
		"'ELSE'", "'WHILE'", "'ENDWHILE'", "' '", "'\n'", "'\r'", "'\t'", null, 
		null, null, null, null, null, "':='", "';'", "','", "'('", "')'", "'+'", 
		"'-'", "'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PROGRAM", "STRING", "BEGIN", "END", "FUNCTION", "READ", "FLOAT", 
		"INT", "VOID", "WRITE", "RETURN", "IF", "ENDIF", "ELSE", "WHILE", "ENDWHILE", 
		"WHITESPACE", "NEWLINE", "RETURNCHAR", "TAB", "IDENTIFIER", "INTLITERAL", 
		"FLOATLITERAL", "STRINGLITERAL", "COMMENT", "OTHEROP", "ASSIGNMENT", "SEMICOLON", 
		"COMMA", "OPENPAREN", "CLOSEPAREN", "PLUS", "MINUS", "MULTIPLY", "DIVIDE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LittleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Little.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u0104\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\7\26\u00bc\n\26\f\26\16\26\u00bf"+
		"\13\26\3\27\6\27\u00c2\n\27\r\27\16\27\u00c3\3\30\7\30\u00c7\n\30\f\30"+
		"\16\30\u00ca\13\30\3\30\3\30\6\30\u00ce\n\30\r\30\16\30\u00cf\3\31\3\31"+
		"\7\31\u00d4\n\31\f\31\16\31\u00d7\13\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\7\32\u00df\n\32\f\32\16\32\u00e2\13\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00f0\n\33\3\34\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\4\u00d5\u00e0\2%"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%\3\2\6\3\2C|\4\2\62;C|\3\2\62;\4\2>>@@\2\u010d\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2"+
		"\2\5Q\3\2\2\2\7X\3\2\2\2\t^\3\2\2\2\13b\3\2\2\2\rk\3\2\2\2\17p\3\2\2\2"+
		"\21v\3\2\2\2\23z\3\2\2\2\25\177\3\2\2\2\27\u0085\3\2\2\2\31\u008c\3\2"+
		"\2\2\33\u008f\3\2\2\2\35\u0095\3\2\2\2\37\u009a\3\2\2\2!\u00a0\3\2\2\2"+
		"#\u00a9\3\2\2\2%\u00ad\3\2\2\2\'\u00b1\3\2\2\2)\u00b5\3\2\2\2+\u00b9\3"+
		"\2\2\2-\u00c1\3\2\2\2/\u00c8\3\2\2\2\61\u00d1\3\2\2\2\63\u00da\3\2\2\2"+
		"\65\u00ef\3\2\2\2\67\u00f1\3\2\2\29\u00f4\3\2\2\2;\u00f6\3\2\2\2=\u00f8"+
		"\3\2\2\2?\u00fa\3\2\2\2A\u00fc\3\2\2\2C\u00fe\3\2\2\2E\u0100\3\2\2\2G"+
		"\u0102\3\2\2\2IJ\7R\2\2JK\7T\2\2KL\7Q\2\2LM\7I\2\2MN\7T\2\2NO\7C\2\2O"+
		"P\7O\2\2P\4\3\2\2\2QR\7U\2\2RS\7V\2\2ST\7T\2\2TU\7K\2\2UV\7P\2\2VW\7I"+
		"\2\2W\6\3\2\2\2XY\7D\2\2YZ\7G\2\2Z[\7I\2\2[\\\7K\2\2\\]\7P\2\2]\b\3\2"+
		"\2\2^_\7G\2\2_`\7P\2\2`a\7F\2\2a\n\3\2\2\2bc\7H\2\2cd\7W\2\2de\7P\2\2"+
		"ef\7E\2\2fg\7V\2\2gh\7K\2\2hi\7Q\2\2ij\7P\2\2j\f\3\2\2\2kl\7T\2\2lm\7"+
		"G\2\2mn\7C\2\2no\7F\2\2o\16\3\2\2\2pq\7H\2\2qr\7N\2\2rs\7Q\2\2st\7C\2"+
		"\2tu\7V\2\2u\20\3\2\2\2vw\7K\2\2wx\7P\2\2xy\7V\2\2y\22\3\2\2\2z{\7X\2"+
		"\2{|\7Q\2\2|}\7K\2\2}~\7F\2\2~\24\3\2\2\2\177\u0080\7Y\2\2\u0080\u0081"+
		"\7T\2\2\u0081\u0082\7K\2\2\u0082\u0083\7V\2\2\u0083\u0084\7G\2\2\u0084"+
		"\26\3\2\2\2\u0085\u0086\7T\2\2\u0086\u0087\7G\2\2\u0087\u0088\7V\2\2\u0088"+
		"\u0089\7W\2\2\u0089\u008a\7T\2\2\u008a\u008b\7P\2\2\u008b\30\3\2\2\2\u008c"+
		"\u008d\7K\2\2\u008d\u008e\7H\2\2\u008e\32\3\2\2\2\u008f\u0090\7G\2\2\u0090"+
		"\u0091\7P\2\2\u0091\u0092\7F\2\2\u0092\u0093\7K\2\2\u0093\u0094\7H\2\2"+
		"\u0094\34\3\2\2\2\u0095\u0096\7G\2\2\u0096\u0097\7N\2\2\u0097\u0098\7"+
		"U\2\2\u0098\u0099\7G\2\2\u0099\36\3\2\2\2\u009a\u009b\7Y\2\2\u009b\u009c"+
		"\7J\2\2\u009c\u009d\7K\2\2\u009d\u009e\7N\2\2\u009e\u009f\7G\2\2\u009f"+
		" \3\2\2\2\u00a0\u00a1\7G\2\2\u00a1\u00a2\7P\2\2\u00a2\u00a3\7F\2\2\u00a3"+
		"\u00a4\7Y\2\2\u00a4\u00a5\7J\2\2\u00a5\u00a6\7K\2\2\u00a6\u00a7\7N\2\2"+
		"\u00a7\u00a8\7G\2\2\u00a8\"\3\2\2\2\u00a9\u00aa\7\"\2\2\u00aa\u00ab\3"+
		"\2\2\2\u00ab\u00ac\b\22\2\2\u00ac$\3\2\2\2\u00ad\u00ae\7\f\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b0\b\23\2\2\u00b0&\3\2\2\2\u00b1\u00b2\7\17\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\b\24\2\2\u00b4(\3\2\2\2\u00b5\u00b6\7\13\2"+
		"\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\b\25\2\2\u00b8*\3\2\2\2\u00b9\u00bd"+
		"\t\2\2\2\u00ba\u00bc\t\3\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be,\3\2\2\2\u00bf\u00bd\3\2\2\2"+
		"\u00c0\u00c2\t\4\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4.\3\2\2\2\u00c5\u00c7\t\4\2\2\u00c6"+
		"\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cd\7\60\2\2\u00cc"+
		"\u00ce\t\4\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\60\3\2\2\2\u00d1\u00d5\7$\2\2\u00d2\u00d4"+
		"\13\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d6\3\2\2\2"+
		"\u00d5\u00d3\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9"+
		"\7$\2\2\u00d9\62\3\2\2\2\u00da\u00db\7/\2\2\u00db\u00dc\7/\2\2\u00dc\u00e0"+
		"\3\2\2\2\u00dd\u00df\13\2\2\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2"+
		"\u00e0\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e3\u00e4\7\f\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\b\32\2\2"+
		"\u00e6\64\3\2\2\2\u00e7\u00f0\7?\2\2\u00e8\u00e9\7#\2\2\u00e9\u00f0\7"+
		"?\2\2\u00ea\u00f0\t\5\2\2\u00eb\u00ec\7>\2\2\u00ec\u00f0\7?\2\2\u00ed"+
		"\u00ee\7@\2\2\u00ee\u00f0\7?\2\2\u00ef\u00e7\3\2\2\2\u00ef\u00e8\3\2\2"+
		"\2\u00ef\u00ea\3\2\2\2\u00ef\u00eb\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\66"+
		"\3\2\2\2\u00f1\u00f2\7<\2\2\u00f2\u00f3\7?\2\2\u00f38\3\2\2\2\u00f4\u00f5"+
		"\7=\2\2\u00f5:\3\2\2\2\u00f6\u00f7\7.\2\2\u00f7<\3\2\2\2\u00f8\u00f9\7"+
		"*\2\2\u00f9>\3\2\2\2\u00fa\u00fb\7+\2\2\u00fb@\3\2\2\2\u00fc\u00fd\7-"+
		"\2\2\u00fdB\3\2\2\2\u00fe\u00ff\7/\2\2\u00ffD\3\2\2\2\u0100\u0101\7,\2"+
		"\2\u0101F\3\2\2\2\u0102\u0103\7\61\2\2\u0103H\3\2\2\2\n\2\u00bd\u00c3"+
		"\u00c8\u00cf\u00d5\u00e0\u00ef\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}