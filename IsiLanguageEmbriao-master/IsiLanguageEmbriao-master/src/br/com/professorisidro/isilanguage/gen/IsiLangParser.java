// Generated from C:/Users/User/Downloads/ExpressionLanguage-main/IsiLanguageEmbriao-master/IsiLanguageEmbriao-master\IsiLang.g4 by ANTLR 4.12.0
package src.br.com.professorisidro.isilanguage.gen;

	import src.br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import src.br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import src.br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import src.br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import src.br.com.professorisidro.isilanguage.ast.IsiProgram;
	import src.br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import src.br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import src.br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import src.br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import src.br.com.professorisidro.isilanguage.ast.CommandDecisao;
	import src.br.com.professorisidro.isilanguage.ast.CommandWhile;
	import src.br.com.professorisidro.isilanguage.ast.CommandDoWhile;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, AP=11, FP=12, SC=13, OP=14, ATTR=15, VIR=16, ACH=17, FCH=18, 
		OPREL=19, ID=20, NUMBER=21, STRING=22, ASPAS=23, WS=24;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdrepeticao = 10, RULE_expr = 11, RULE_termo = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
			"cmdattrib", "cmdselecao", "cmdrepeticao", "expr", "termo"
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

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(27);
			decl();
			setState(28);
			bloco();
			setState(29);
			match(T__1);
			  program.setVarTable(symbolTable);
			           	  program.setComandos(stack.pop());
			           	  ArrayList<IsiSymbol> lista = symbolTable.getAll();
			              for(int i = 0; i<lista.size();i++){
			                  boolean atribuido = ((IsiVariable)(lista.get(i))).getAtribuicao();

			                  boolean usado = ((IsiVariable)(lista.get(i))).getUso();
			                  if (atribuido && usado) {
			                  } else if ( atribuido && !usado){
			                      System.out.println("WARNING: Symbol "+ lista.get(i).getName()+" assigned but not used.");
			                  } else if (!atribuido && usado){
			                      System.out.println("WARNING: Symbol "+ lista.get(i).getName()+" used but not assigned.");
			                  } else {
			                      System.out.println("WARNING: Symbol "+ lista.get(i).getName()+" declared but not assigned and used.");
			                  }
			              }
			           
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				declaravar();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaravar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitDeclaravar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			tipo();
			setState(38);
			match(ID);

				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  symbol = new IsiVariable(_varName, _tipo, _varValue);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(symbol);	
				                  }
				                  else{
				                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
				                  }
			                    
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(40);
				match(VIR);
				setState(41);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
					                  symbol = new IsiVariable(_varName, _tipo, _varValue);
					                  if (!symbolTable.exists(_varName)){
					                     symbolTable.add(symbol);	
					                  }
					                  else{
					                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
					                  }
				                    
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__2);
				 _tipo = IsiVariable.NUMBER;  
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(T__3);
				 _tipo = IsiVariable.TEXT;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitBloco(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>();
				        stack.push(curThread);  
			          
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				cmd();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1050336L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdrepeticaoContext cmdrepeticao() {
			return getRuleContext(CmdrepeticaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				cmdattrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				cmdselecao();
				}
				break;
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				cmdrepeticao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitCmdleitura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__4);
			setState(70);
			match(AP);
			setState(71);
			match(ID);
			 if (symbolTable.exists(_input.LT(-1).getText())){
			                                      ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).setAtribuicao(true);
			                                  }
			                          verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(73);
			match(FP);
			setState(74);
			match(SC);

			              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
			              	CommandLeitura cmd = new CommandLeitura(_readID, var);
			              	stack.peek().add(cmd);
			              
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitCmdescrita(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__5);
			setState(78);
			match(AP);
			setState(79);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                      ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).setUso(true);
				                  _writeID = _input.LT(-1).getText();
			                     
			setState(81);
			match(FP);
			setState(82);
			match(SC);

			               	  CommandEscrita cmd = new CommandEscrita(_writeID);
			               	  stack.peek().add(cmd);
			               
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdattrib(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitCmdattrib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(ID);
			 if (symbolTable.exists(_input.LT(-1).getText())){
			                                ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).setAtribuicao(true);
			                            }
			                    verificaID(_input.LT(-1).getText());
			                    _exprID = _input.LT(-1).getText();
			                    leftDT = ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).getType();
			                   
			setState(87);
			match(ATTR);
			 _exprContent = ""; 
			setState(89);
			expr();
			setState(90);
			match(SC);

			               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			               	 stack.peek().add(cmd);
			               
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(IsiLangParser.STRING, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdselecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitCmdselecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__6);
			setState(94);
			match(AP);
			setState(95);
			match(ID);

			                            verificaID(_input.LT(-1).getText());
			                            ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).setUso(true);
			                            _exprDecision = _input.LT(-1).getText();
			                          
			setState(97);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(99);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprDecision += _input.LT(-1).getText(); 
			setState(101);
			match(FP);
			setState(102);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                      stack.push(curThread);
			                    
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(104);
				cmd();
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1050336L) != 0) );
			setState(109);
			match(FCH);

			                       listaTrue = stack.pop();	
			                    
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(111);
				match(T__7);
				setState(112);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(114);
					cmd();
					}
					}
					setState(117); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1050336L) != 0) );
				}
				setState(119);
				match(FCH);

				                   		listaFalse = stack.pop();
				                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
				                   		stack.peek().add(cmd);
				                   	
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdrepeticaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdrepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdrepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdrepeticao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitCmdrepeticao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdrepeticaoContext cmdrepeticao() throws RecognitionException {
		CmdrepeticaoContext _localctx = new CmdrepeticaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdrepeticao);
		int _la;
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(T__8);
				setState(125);
				match(AP);
				setState(126);
				expr();
				_exprWhile = _input.LT(-1).getText();
				setState(128);
				match(OPREL);
				_exprWhile += _input.LT(-1).getText();
				setState(130);
				expr();
				_exprWhile += _input.LT(-1).getText();
				setState(132);
				match(FP);
				setState(133);
				match(ACH);
				  curThread = new ArrayList<AbstractCommand>();
				                        stack.push(curThread);
				                     
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(135);
					cmd();
					}
					}
					setState(138); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1050336L) != 0) );
				setState(140);
				match(FCH);

				                    listaLoop = stack.pop();
				                    CommandWhile cmd = new CommandWhile(_exprWhile, listaLoop);
				                    stack.peek().add(cmd);
				                   
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(T__9);
				setState(144);
				match(ACH);
				 curThread = new ArrayList<AbstractCommand>();
				                      stack.push(curThread);
				                      
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(146);
					cmd();
					}
					}
					setState(149); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1050336L) != 0) );
				setState(151);
				match(FCH);
				setState(152);
				match(T__8);
				setState(153);
				match(AP);
				setState(154);
				expr();
				_exprWhile = _input.LT(-1).getText();
				setState(156);
				match(OPREL);
				_exprWhile += _input.LT(-1).getText();
				setState(158);
				expr();
				_exprWhile += _input.LT(-1).getText();
				setState(160);
				match(FP);
				   listaLoop = stack.pop();
				                      CommandDoWhile cmd = new CommandDoWhile(_exprWhile, listaLoop);
				                      stack.peek().add(cmd);
				                  
				setState(162);
				match(SC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			termo();
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(167);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(169);
				termo();
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(IsiLangParser.STRING, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IsiLangVisitor ) return ((IsiLangVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(ID);
				 verificaID(_input.LT(-1).getText());
				                   ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).setUso(true);
					               _exprContent += _input.LT(-1).getText();
					               rightDT = ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).getType();
				                   if (leftDT != rightDT){
				                   		throw new IsiSemanticException("Semantic ERROR - Type Mismatching "+leftDT+ "-"+rightDT);
				                   }
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(NUMBER);

				              	_exprContent += _input.LT(-1).getText();
				                if (leftDT != 0){
				                  throw new IsiSemanticException("Semantic ERROR - Type Mismatching "+leftDT+ "-"+0);
				                 }
				              
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				match(STRING);
				 _exprContent += _input.LT(-1).getText();
				                        if (leftDT != 1){
				                          throw new IsiSemanticException("Semantic ERROR - Type Mismatching "+leftDT+ "-"+1);
				                        }
				                     
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018\u00b8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0004\u0001\"\b\u0001\u000b\u0001\f\u0001"+
		"#\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002,\b\u0002\n\u0002\f\u0002/\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00037\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0004\u0004;\b\u0004\u000b\u0004\f\u0004<\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005D\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0004\tj\b\t\u000b\t\f\tk\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0004\tt\b\t\u000b\t\f\tu\u0001\t\u0001\t\u0001\t\u0003\t{\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0004\n\u0089\b\n\u000b\n\f\n\u008a\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u0094\b\n\u000b\n\f\n"+
		"\u0095\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00a5\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00ab\b\u000b\n\u000b"+
		"\f\u000b\u00ae\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u00b6\b\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0001\u0001\u0000\u0014\u0016"+
		"\u00bb\u0000\u001a\u0001\u0000\u0000\u0000\u0002!\u0001\u0000\u0000\u0000"+
		"\u0004%\u0001\u0000\u0000\u0000\u00066\u0001\u0000\u0000\u0000\b8\u0001"+
		"\u0000\u0000\u0000\nC\u0001\u0000\u0000\u0000\fE\u0001\u0000\u0000\u0000"+
		"\u000eM\u0001\u0000\u0000\u0000\u0010U\u0001\u0000\u0000\u0000\u0012]"+
		"\u0001\u0000\u0000\u0000\u0014\u00a4\u0001\u0000\u0000\u0000\u0016\u00a6"+
		"\u0001\u0000\u0000\u0000\u0018\u00b5\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0005\u0001\u0000\u0000\u001b\u001c\u0003\u0002\u0001\u0000\u001c\u001d"+
		"\u0003\b\u0004\u0000\u001d\u001e\u0005\u0002\u0000\u0000\u001e\u001f\u0006"+
		"\u0000\uffff\uffff\u0000\u001f\u0001\u0001\u0000\u0000\u0000 \"\u0003"+
		"\u0004\u0002\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\u0003\u0001\u0000"+
		"\u0000\u0000%&\u0003\u0006\u0003\u0000&\'\u0005\u0014\u0000\u0000\'-\u0006"+
		"\u0002\uffff\uffff\u0000()\u0005\u0010\u0000\u0000)*\u0005\u0014\u0000"+
		"\u0000*,\u0006\u0002\uffff\uffff\u0000+(\u0001\u0000\u0000\u0000,/\u0001"+
		"\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000"+
		".0\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u000001\u0005\r\u0000\u0000"+
		"1\u0005\u0001\u0000\u0000\u000023\u0005\u0003\u0000\u000037\u0006\u0003"+
		"\uffff\uffff\u000045\u0005\u0004\u0000\u000057\u0006\u0003\uffff\uffff"+
		"\u000062\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u00007\u0007\u0001"+
		"\u0000\u0000\u00008:\u0006\u0004\uffff\uffff\u00009;\u0003\n\u0005\u0000"+
		":9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=\t\u0001\u0000\u0000\u0000>D\u0003\f"+
		"\u0006\u0000?D\u0003\u000e\u0007\u0000@D\u0003\u0010\b\u0000AD\u0003\u0012"+
		"\t\u0000BD\u0003\u0014\n\u0000C>\u0001\u0000\u0000\u0000C?\u0001\u0000"+
		"\u0000\u0000C@\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CB\u0001"+
		"\u0000\u0000\u0000D\u000b\u0001\u0000\u0000\u0000EF\u0005\u0005\u0000"+
		"\u0000FG\u0005\u000b\u0000\u0000GH\u0005\u0014\u0000\u0000HI\u0006\u0006"+
		"\uffff\uffff\u0000IJ\u0005\f\u0000\u0000JK\u0005\r\u0000\u0000KL\u0006"+
		"\u0006\uffff\uffff\u0000L\r\u0001\u0000\u0000\u0000MN\u0005\u0006\u0000"+
		"\u0000NO\u0005\u000b\u0000\u0000OP\u0005\u0014\u0000\u0000PQ\u0006\u0007"+
		"\uffff\uffff\u0000QR\u0005\f\u0000\u0000RS\u0005\r\u0000\u0000ST\u0006"+
		"\u0007\uffff\uffff\u0000T\u000f\u0001\u0000\u0000\u0000UV\u0005\u0014"+
		"\u0000\u0000VW\u0006\b\uffff\uffff\u0000WX\u0005\u000f\u0000\u0000XY\u0006"+
		"\b\uffff\uffff\u0000YZ\u0003\u0016\u000b\u0000Z[\u0005\r\u0000\u0000["+
		"\\\u0006\b\uffff\uffff\u0000\\\u0011\u0001\u0000\u0000\u0000]^\u0005\u0007"+
		"\u0000\u0000^_\u0005\u000b\u0000\u0000_`\u0005\u0014\u0000\u0000`a\u0006"+
		"\t\uffff\uffff\u0000ab\u0005\u0013\u0000\u0000bc\u0006\t\uffff\uffff\u0000"+
		"cd\u0007\u0000\u0000\u0000de\u0006\t\uffff\uffff\u0000ef\u0005\f\u0000"+
		"\u0000fg\u0005\u0011\u0000\u0000gi\u0006\t\uffff\uffff\u0000hj\u0003\n"+
		"\u0005\u0000ih\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000ki\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"mn\u0005\u0012\u0000\u0000nz\u0006\t\uffff\uffff\u0000op\u0005\b\u0000"+
		"\u0000pq\u0005\u0011\u0000\u0000qs\u0006\t\uffff\uffff\u0000rt\u0003\n"+
		"\u0005\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wx\u0005\u0012\u0000\u0000xy\u0006\t\uffff\uffff\u0000y{\u0001\u0000\u0000"+
		"\u0000zo\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u0013\u0001"+
		"\u0000\u0000\u0000|}\u0005\t\u0000\u0000}~\u0005\u000b\u0000\u0000~\u007f"+
		"\u0003\u0016\u000b\u0000\u007f\u0080\u0006\n\uffff\uffff\u0000\u0080\u0081"+
		"\u0005\u0013\u0000\u0000\u0081\u0082\u0006\n\uffff\uffff\u0000\u0082\u0083"+
		"\u0003\u0016\u000b\u0000\u0083\u0084\u0006\n\uffff\uffff\u0000\u0084\u0085"+
		"\u0005\f\u0000\u0000\u0085\u0086\u0005\u0011\u0000\u0000\u0086\u0088\u0006"+
		"\n\uffff\uffff\u0000\u0087\u0089\u0003\n\u0005\u0000\u0088\u0087\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0005\u0012\u0000\u0000\u008d\u008e\u0006"+
		"\n\uffff\uffff\u0000\u008e\u00a5\u0001\u0000\u0000\u0000\u008f\u0090\u0005"+
		"\n\u0000\u0000\u0090\u0091\u0005\u0011\u0000\u0000\u0091\u0093\u0006\n"+
		"\uffff\uffff\u0000\u0092\u0094\u0003\n\u0005\u0000\u0093\u0092\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0005\u0012\u0000\u0000\u0098\u0099\u0005\t\u0000"+
		"\u0000\u0099\u009a\u0005\u000b\u0000\u0000\u009a\u009b\u0003\u0016\u000b"+
		"\u0000\u009b\u009c\u0006\n\uffff\uffff\u0000\u009c\u009d\u0005\u0013\u0000"+
		"\u0000\u009d\u009e\u0006\n\uffff\uffff\u0000\u009e\u009f\u0003\u0016\u000b"+
		"\u0000\u009f\u00a0\u0006\n\uffff\uffff\u0000\u00a0\u00a1\u0005\f\u0000"+
		"\u0000\u00a1\u00a2\u0006\n\uffff\uffff\u0000\u00a2\u00a3\u0005\r\u0000"+
		"\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4|\u0001\u0000\u0000\u0000"+
		"\u00a4\u008f\u0001\u0000\u0000\u0000\u00a5\u0015\u0001\u0000\u0000\u0000"+
		"\u00a6\u00ac\u0003\u0018\f\u0000\u00a7\u00a8\u0005\u000e\u0000\u0000\u00a8"+
		"\u00a9\u0006\u000b\uffff\uffff\u0000\u00a9\u00ab\u0003\u0018\f\u0000\u00aa"+
		"\u00a7\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad"+
		"\u0017\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0005\u0014\u0000\u0000\u00b0\u00b6\u0006\f\uffff\uffff\u0000\u00b1"+
		"\u00b2\u0005\u0015\u0000\u0000\u00b2\u00b6\u0006\f\uffff\uffff\u0000\u00b3"+
		"\u00b4\u0005\u0016\u0000\u0000\u00b4\u00b6\u0006\f\uffff\uffff\u0000\u00b5"+
		"\u00af\u0001\u0000\u0000\u0000\u00b5\u00b1\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b6\u0019\u0001\u0000\u0000\u0000\r#"+
		"-6<Ckuz\u008a\u0095\u00a4\u00ac\u00b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}