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
public class Little extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, WHITESPACE=2, NEWLINE=3, RETURN=4, TAB=5, IDENTIFIER=6, INTLITERAL=7, 
		FLOATLITERAL=8, STRINGLITERAL=9, COMMENT=10, OPERATOR=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "WHITESPACE", "NEWLINE", "RETURN", "TAB", "IDENTIFIER", "INTLITERAL", 
		"FLOATLITERAL", "STRINGLITERAL", "COMMENT", "OPERATOR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "' '", "'\n'", "'\r'", "'\t'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "WHITESPACE", "NEWLINE", "RETURN", "TAB", "IDENTIFIER", 
		"INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", "COMMENT", "OPERATOR"
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


	public Little(CharStream input) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r\u00ca\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5"+
		"\2\177\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\7\7\u0093\n\7\f\7\16\7\u0096\13\7\3\b\6\b\u0099\n\b\r\b\16"+
		"\b\u009a\3\t\7\t\u009e\n\t\f\t\16\t\u00a1\13\t\3\t\3\t\6\t\u00a5\n\t\r"+
		"\t\16\t\u00a6\3\n\3\n\7\n\u00ab\n\n\f\n\16\n\u00ae\13\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\7\13\u00b6\n\13\f\13\16\13\u00b9\13\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c9\n\f\4\u00ac\u00b7"+
		"\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\7\3\2C|\4"+
		"\2\62;C|\3\2\62;\6\2,-//\61\61??\6\2*+..=>@@\2\u00e8\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3~\3\2\2\2\5\u0080"+
		"\3\2\2\2\7\u0084\3\2\2\2\t\u0088\3\2\2\2\13\u008c\3\2\2\2\r\u0090\3\2"+
		"\2\2\17\u0098\3\2\2\2\21\u009f\3\2\2\2\23\u00a8\3\2\2\2\25\u00b1\3\2\2"+
		"\2\27\u00c8\3\2\2\2\31\32\7R\2\2\32\33\7T\2\2\33\34\7Q\2\2\34\35\7I\2"+
		"\2\35\36\7T\2\2\36\37\7C\2\2\37\177\7O\2\2 !\7U\2\2!\"\7V\2\2\"#\7T\2"+
		"\2#$\7K\2\2$%\7P\2\2%\177\7I\2\2&\'\7R\2\2\'(\7T\2\2()\7Q\2\2)*\7I\2\2"+
		"*+\7T\2\2+,\7C\2\2,\177\7O\2\2-.\7D\2\2./\7G\2\2/\60\7I\2\2\60\61\7K\2"+
		"\2\61\177\7P\2\2\62\63\7G\2\2\63\64\7P\2\2\64\177\7F\2\2\65\66\7H\2\2"+
		"\66\67\7W\2\2\678\7P\2\289\7E\2\29:\7V\2\2:;\7K\2\2;<\7Q\2\2<\177\7P\2"+
		"\2=>\7T\2\2>?\7G\2\2?@\7C\2\2@\177\7F\2\2AB\7Y\2\2BC\7T\2\2CD\7K\2\2D"+
		"E\7V\2\2E\177\7G\2\2FG\7K\2\2G\177\7H\2\2HI\7G\2\2IJ\7N\2\2JK\7U\2\2K"+
		"\177\7G\2\2LM\7H\2\2M\177\7K\2\2NO\7H\2\2OP\7Q\2\2P\177\7T\2\2QR\7T\2"+
		"\2RS\7Q\2\2S\177\7H\2\2TU\7T\2\2UV\7G\2\2VW\7V\2\2WX\7W\2\2XY\7T\2\2Y"+
		"\177\7P\2\2Z[\7K\2\2[\\\7P\2\2\\\177\7V\2\2]^\7X\2\2^_\7Q\2\2_`\7K\2\2"+
		"`\177\7F\2\2ab\7U\2\2bc\7V\2\2cd\7T\2\2de\7K\2\2ef\7P\2\2f\177\7I\2\2"+
		"gh\7H\2\2hi\7N\2\2ij\7Q\2\2jk\7C\2\2k\177\7V\2\2lm\7Y\2\2mn\7J\2\2no\7"+
		"K\2\2op\7N\2\2p\177\7G\2\2qr\7G\2\2rs\7P\2\2st\7F\2\2tu\7K\2\2u\177\7"+
		"H\2\2vw\7G\2\2wx\7P\2\2xy\7F\2\2yz\7Y\2\2z{\7J\2\2{|\7K\2\2|}\7N\2\2}"+
		"\177\7G\2\2~\31\3\2\2\2~ \3\2\2\2~&\3\2\2\2~-\3\2\2\2~\62\3\2\2\2~\65"+
		"\3\2\2\2~=\3\2\2\2~A\3\2\2\2~F\3\2\2\2~H\3\2\2\2~L\3\2\2\2~N\3\2\2\2~"+
		"Q\3\2\2\2~T\3\2\2\2~Z\3\2\2\2~]\3\2\2\2~a\3\2\2\2~g\3\2\2\2~l\3\2\2\2"+
		"~q\3\2\2\2~v\3\2\2\2\177\4\3\2\2\2\u0080\u0081\7\"\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\u0083\b\3\2\2\u0083\6\3\2\2\2\u0084\u0085\7\f\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0087\b\4\2\2\u0087\b\3\2\2\2\u0088\u0089\7\17\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\b\5\2\2\u008b\n\3\2\2\2\u008c\u008d\7\13\2"+
		"\2\u008d\u008e\3\2\2\2\u008e\u008f\b\6\2\2\u008f\f\3\2\2\2\u0090\u0094"+
		"\t\2\2\2\u0091\u0093\t\3\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\16\3\2\2\2\u0096\u0094\3\2\2"+
		"\2\u0097\u0099\t\4\2\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\20\3\2\2\2\u009c\u009e\t\4\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\7\60\2\2\u00a3"+
		"\u00a5\t\4\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a6\u00a7\3\2\2\2\u00a7\22\3\2\2\2\u00a8\u00ac\7$\2\2\u00a9\u00ab"+
		"\13\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00ad\3\2\2\2"+
		"\u00ac\u00aa\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0"+
		"\7$\2\2\u00b0\24\3\2\2\2\u00b1\u00b2\7/\2\2\u00b2\u00b3\7/\2\2\u00b3\u00b7"+
		"\3\2\2\2\u00b4\u00b6\13\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2"+
		"\u00b7\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7"+
		"\3\2\2\2\u00ba\u00bb\7\f\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\b\13\2\2"+
		"\u00bd\26\3\2\2\2\u00be\u00bf\7<\2\2\u00bf\u00c9\7?\2\2\u00c0\u00c9\t"+
		"\5\2\2\u00c1\u00c2\7#\2\2\u00c2\u00c9\7?\2\2\u00c3\u00c9\t\6\2\2\u00c4"+
		"\u00c5\7>\2\2\u00c5\u00c9\7?\2\2\u00c6\u00c7\7@\2\2\u00c7\u00c9\7?\2\2"+
		"\u00c8\u00be\3\2\2\2\u00c8\u00c0\3\2\2\2\u00c8\u00c1\3\2\2\2\u00c8\u00c3"+
		"\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\30\3\2\2\2\13\2"+
		"~\u0094\u009a\u009f\u00a6\u00ac\u00b7\u00c8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}