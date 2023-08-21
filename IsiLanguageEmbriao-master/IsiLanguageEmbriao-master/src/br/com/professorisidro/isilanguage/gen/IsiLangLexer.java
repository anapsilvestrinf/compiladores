// Generated from C:/Users/User/Downloads/ExpressionLanguage-main/IsiLanguageEmbriao-master/IsiLanguageEmbriao-master\IsiLang.g4 by ANTLR 4.12.0
package src.br.com.professorisidro.isilanguage.gen;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import src.br.com.professorisidro.isilanguage.ast.AbstractCommand;
import src.br.com.professorisidro.isilanguage.ast.IsiProgram;
import src.br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
import src.br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
import src.br.com.professorisidro.isilanguage.datastructures.IsiVariable;
import src.br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;

import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, AP=11, FP=12, SC=13, OP=14, ATTR=15, VIR=16, ACH=17, FCH=18, 
		OPREL=19, ID=20, NUMBER=21, STRING=22, ASPAS=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", 
			"ID", "NUMBER", "STRING", "ASPAS", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog.'", "'numero'", "'texto'", "'leia'", "'escreva'", 
			"'se'", "'senao'", "'while'", "'do'", "'('", "')'", "'.'", null, "'='", 
			"','", "'{'", "'}'", null, null, null, null, "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "AP", 
			"FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", 
			"STRING", "ASPAS", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private String _exprWhile;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		private ArrayList<AbstractCommand> listaLoop;
	    private int leftDT;
	    private int rightDT;
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol "+id+" not declared");
			}
			if (!((IsiVariable)(symbolTable.get(id))).getAtribuicao()){
				//throw new IsiSemanticException("Symbol "+id+" not assigned");
				System.out.println("Symbol "+id+" not assigned");
			} else {
			    System.out.println("Symbol "+id+" already declared");
			}
		}

		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

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
		"\u0004\u0000\u0018\u00ad\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0089\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u008d\b\u0013\n\u0013\f\u0013\u0090"+
		"\t\u0013\u0001\u0014\u0004\u0014\u0093\b\u0014\u000b\u0014\f\u0014\u0094"+
		"\u0001\u0014\u0001\u0014\u0004\u0014\u0099\b\u0014\u000b\u0014\f\u0014"+
		"\u009a\u0003\u0014\u009d\b\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u00a1"+
		"\b\u0015\n\u0015\f\u0015\u00a4\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0000\u0000"+
		"\u0018\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u0018\u0001\u0000\u0007\u0003\u0000*+--//\u0002\u0000<<>>\u0001\u0000"+
		"az\u0003\u000009AZaz\u0001\u000009\u0004\u0000  09AZaz\u0003\u0000\t\n"+
		"\r\r  \u00b5\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00011\u0001\u0000\u0000\u0000\u0003"+
		":\u0001\u0000\u0000\u0000\u0005C\u0001\u0000\u0000\u0000\u0007J\u0001"+
		"\u0000\u0000\u0000\tP\u0001\u0000\u0000\u0000\u000bU\u0001\u0000\u0000"+
		"\u0000\r]\u0001\u0000\u0000\u0000\u000f`\u0001\u0000\u0000\u0000\u0011"+
		"f\u0001\u0000\u0000\u0000\u0013l\u0001\u0000\u0000\u0000\u0015o\u0001"+
		"\u0000\u0000\u0000\u0017q\u0001\u0000\u0000\u0000\u0019s\u0001\u0000\u0000"+
		"\u0000\u001bu\u0001\u0000\u0000\u0000\u001dw\u0001\u0000\u0000\u0000\u001f"+
		"y\u0001\u0000\u0000\u0000!{\u0001\u0000\u0000\u0000#}\u0001\u0000\u0000"+
		"\u0000%\u0088\u0001\u0000\u0000\u0000\'\u008a\u0001\u0000\u0000\u0000"+
		")\u0092\u0001\u0000\u0000\u0000+\u009e\u0001\u0000\u0000\u0000-\u00a7"+
		"\u0001\u0000\u0000\u0000/\u00a9\u0001\u0000\u0000\u000012\u0005p\u0000"+
		"\u000023\u0005r\u0000\u000034\u0005o\u0000\u000045\u0005g\u0000\u0000"+
		"56\u0005r\u0000\u000067\u0005a\u0000\u000078\u0005m\u0000\u000089\u0005"+
		"a\u0000\u00009\u0002\u0001\u0000\u0000\u0000:;\u0005f\u0000\u0000;<\u0005"+
		"i\u0000\u0000<=\u0005m\u0000\u0000=>\u0005p\u0000\u0000>?\u0005r\u0000"+
		"\u0000?@\u0005o\u0000\u0000@A\u0005g\u0000\u0000AB\u0005.\u0000\u0000"+
		"B\u0004\u0001\u0000\u0000\u0000CD\u0005n\u0000\u0000DE\u0005u\u0000\u0000"+
		"EF\u0005m\u0000\u0000FG\u0005e\u0000\u0000GH\u0005r\u0000\u0000HI\u0005"+
		"o\u0000\u0000I\u0006\u0001\u0000\u0000\u0000JK\u0005t\u0000\u0000KL\u0005"+
		"e\u0000\u0000LM\u0005x\u0000\u0000MN\u0005t\u0000\u0000NO\u0005o\u0000"+
		"\u0000O\b\u0001\u0000\u0000\u0000PQ\u0005l\u0000\u0000QR\u0005e\u0000"+
		"\u0000RS\u0005i\u0000\u0000ST\u0005a\u0000\u0000T\n\u0001\u0000\u0000"+
		"\u0000UV\u0005e\u0000\u0000VW\u0005s\u0000\u0000WX\u0005c\u0000\u0000"+
		"XY\u0005r\u0000\u0000YZ\u0005e\u0000\u0000Z[\u0005v\u0000\u0000[\\\u0005"+
		"a\u0000\u0000\\\f\u0001\u0000\u0000\u0000]^\u0005s\u0000\u0000^_\u0005"+
		"e\u0000\u0000_\u000e\u0001\u0000\u0000\u0000`a\u0005s\u0000\u0000ab\u0005"+
		"e\u0000\u0000bc\u0005n\u0000\u0000cd\u0005a\u0000\u0000de\u0005o\u0000"+
		"\u0000e\u0010\u0001\u0000\u0000\u0000fg\u0005w\u0000\u0000gh\u0005h\u0000"+
		"\u0000hi\u0005i\u0000\u0000ij\u0005l\u0000\u0000jk\u0005e\u0000\u0000"+
		"k\u0012\u0001\u0000\u0000\u0000lm\u0005d\u0000\u0000mn\u0005o\u0000\u0000"+
		"n\u0014\u0001\u0000\u0000\u0000op\u0005(\u0000\u0000p\u0016\u0001\u0000"+
		"\u0000\u0000qr\u0005)\u0000\u0000r\u0018\u0001\u0000\u0000\u0000st\u0005"+
		".\u0000\u0000t\u001a\u0001\u0000\u0000\u0000uv\u0007\u0000\u0000\u0000"+
		"v\u001c\u0001\u0000\u0000\u0000wx\u0005=\u0000\u0000x\u001e\u0001\u0000"+
		"\u0000\u0000yz\u0005,\u0000\u0000z \u0001\u0000\u0000\u0000{|\u0005{\u0000"+
		"\u0000|\"\u0001\u0000\u0000\u0000}~\u0005}\u0000\u0000~$\u0001\u0000\u0000"+
		"\u0000\u007f\u0089\u0007\u0001\u0000\u0000\u0080\u0081\u0005>\u0000\u0000"+
		"\u0081\u0089\u0005=\u0000\u0000\u0082\u0083\u0005<\u0000\u0000\u0083\u0089"+
		"\u0005=\u0000\u0000\u0084\u0085\u0005=\u0000\u0000\u0085\u0089\u0005="+
		"\u0000\u0000\u0086\u0087\u0005!\u0000\u0000\u0087\u0089\u0005=\u0000\u0000"+
		"\u0088\u007f\u0001\u0000\u0000\u0000\u0088\u0080\u0001\u0000\u0000\u0000"+
		"\u0088\u0082\u0001\u0000\u0000\u0000\u0088\u0084\u0001\u0000\u0000\u0000"+
		"\u0088\u0086\u0001\u0000\u0000\u0000\u0089&\u0001\u0000\u0000\u0000\u008a"+
		"\u008e\u0007\u0002\u0000\u0000\u008b\u008d\u0007\u0003\u0000\u0000\u008c"+
		"\u008b\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"(\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0093"+
		"\u0007\u0004\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u009c\u0001\u0000\u0000\u0000\u0096\u0098"+
		"\u0005.\u0000\u0000\u0097\u0099\u0007\u0004\u0000\u0000\u0098\u0097\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u0098\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0001"+
		"\u0000\u0000\u0000\u009c\u0096\u0001\u0000\u0000\u0000\u009c\u009d\u0001"+
		"\u0000\u0000\u0000\u009d*\u0001\u0000\u0000\u0000\u009e\u00a2\u0003-\u0016"+
		"\u0000\u009f\u00a1\u0007\u0005\u0000\u0000\u00a0\u009f\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003-\u0016\u0000"+
		"\u00a6,\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\"\u0000\u0000\u00a8"+
		".\u0001\u0000\u0000\u0000\u00a9\u00aa\u0007\u0006\u0000\u0000\u00aa\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0006\u0017\u0000\u0000\u00ac0\u0001"+
		"\u0000\u0000\u0000\b\u0000\u0088\u008c\u008e\u0094\u009a\u009c\u00a2\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}