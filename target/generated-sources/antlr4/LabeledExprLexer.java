// Generated from LabeledExpr.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LabeledExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		MUL=10, DIV=11, ADD=12, SUB=13, NOT=14, ID=15, INT=16, STRING=17, BOOL=18, 
		NEWLINE=19, WS=20, LES=21, GRT=22, LESE=23, GRTE=24, EE=25, NE=26, AND=27, 
		OR=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"MUL", "DIV", "ADD", "SUB", "NOT", "ID", "INT", "STRING", "BOOL", "NEWLINE", 
		"WS", "LES", "GRT", "LESE", "GRTE", "EE", "NE", "AND", "OR"
	};


	public LabeledExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LabeledExpr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u0097\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\7\20a\n"+
		"\20\f\20\16\20d\13\20\3\21\6\21g\n\21\r\21\16\21h\3\22\3\22\7\22m\n\22"+
		"\f\22\16\22p\13\22\3\22\3\22\3\23\3\23\3\24\5\24w\n\24\3\24\3\24\3\25"+
		"\6\25|\n\25\r\25\16\25}\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3"+
		"\35\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36\3\2\b\4\2C\\c|\5\2\62;C\\c|\3\2\62;\3\2\60\60\f\2\"\"))HHVVcc"+
		"ggnntuww~~\4\2\13\f\17\17\u009b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2\2\2"+
		"\13C\3\2\2\2\rF\3\2\2\2\17K\3\2\2\2\21P\3\2\2\2\23R\3\2\2\2\25T\3\2\2"+
		"\2\27V\3\2\2\2\31X\3\2\2\2\33Z\3\2\2\2\35\\\3\2\2\2\37^\3\2\2\2!f\3\2"+
		"\2\2#j\3\2\2\2%s\3\2\2\2\'v\3\2\2\2){\3\2\2\2+\u0081\3\2\2\2-\u0083\3"+
		"\2\2\2/\u0085\3\2\2\2\61\u0088\3\2\2\2\63\u008b\3\2\2\2\65\u008e\3\2\2"+
		"\2\67\u0091\3\2\2\29\u0094\3\2\2\2;<\7}\2\2<\4\3\2\2\2=>\7=\2\2>\6\3\2"+
		"\2\2?@\7\177\2\2@\b\3\2\2\2AB\7?\2\2B\n\3\2\2\2CD\7k\2\2DE\7h\2\2E\f\3"+
		"\2\2\2FG\7n\2\2GH\7q\2\2HI\7q\2\2IJ\7r\2\2J\16\3\2\2\2KL\7g\2\2LM\7n\2"+
		"\2MN\7u\2\2NO\7g\2\2O\20\3\2\2\2PQ\7*\2\2Q\22\3\2\2\2RS\7+\2\2S\24\3\2"+
		"\2\2TU\7,\2\2U\26\3\2\2\2VW\7\61\2\2W\30\3\2\2\2XY\7-\2\2Y\32\3\2\2\2"+
		"Z[\7/\2\2[\34\3\2\2\2\\]\7#\2\2]\36\3\2\2\2^b\t\2\2\2_a\t\3\2\2`_\3\2"+
		"\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c \3\2\2\2db\3\2\2\2eg\t\4\2\2fe\3\2"+
		"\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\"\3\2\2\2jn\7$\2\2km\t\5\2\2lk\3\2"+
		"\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7$\2\2r$\3\2"+
		"\2\2st\t\6\2\2t&\3\2\2\2uw\7\17\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7"+
		"\f\2\2y(\3\2\2\2z|\t\7\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177"+
		"\3\2\2\2\177\u0080\b\25\2\2\u0080*\3\2\2\2\u0081\u0082\7>\2\2\u0082,\3"+
		"\2\2\2\u0083\u0084\7@\2\2\u0084.\3\2\2\2\u0085\u0086\7>\2\2\u0086\u0087"+
		"\7?\2\2\u0087\60\3\2\2\2\u0088\u0089\7@\2\2\u0089\u008a\7?\2\2\u008a\62"+
		"\3\2\2\2\u008b\u008c\7?\2\2\u008c\u008d\7?\2\2\u008d\64\3\2\2\2\u008e"+
		"\u008f\7#\2\2\u008f\u0090\7?\2\2\u0090\66\3\2\2\2\u0091\u0092\7(\2\2\u0092"+
		"\u0093\7(\2\2\u00938\3\2\2\2\u0094\u0095\7~\2\2\u0095\u0096\7~\2\2\u0096"+
		":\3\2\2\2\b\2bhnv}\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}