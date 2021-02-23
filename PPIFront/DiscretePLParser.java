// Generated from DiscretePL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DiscretePLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, BOP=22, UOP=23, C=24, EQ=25, GT=26, 
		LT=27, EBRANCH=28, INT=29, DOUBLE=30, FILENAME=31, ID=32, STRING=33, LETTER=34, 
		DIGIT=35, NL=36, LINE_COMMENT=37, WS=38;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_data = 2, RULE_stat = 3, RULE_r = 4, 
		RULE_ebranch = 5, RULE_expr = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "data", "stat", "r", "ebranch", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bool'", "','", "';'", "'int'", "'='", "'['", "']'", "'read'", 
			"'('", "')'", "'double'", "'{'", "'}'", "'if'", "'while'", "'for'", "'in'", 
			"'Bernoulli'", "'Discrete'", "'observe'", "'Infer'", null, "'!'", null, 
			"'=='", "'>'", "'<'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "BOP", "UOP", 
			"C", "EQ", "GT", "LT", "EBRANCH", "INT", "DOUBLE", "FILENAME", "ID", 
			"STRING", "LETTER", "DIGIT", "NL", "LINE_COMMENT", "WS"
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
	public String getGrammarFileName() { return "DiscretePL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DiscretePLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<DataContext> data() {
			return getRuleContexts(DataContext.class);
		}
		public DataContext data(int i) {
			return getRuleContext(DataContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(14);
					decl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(17); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__10))) != 0)) {
				{
				{
				setState(19);
				data();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				stat(0);
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__19) | (1L << T__20) | (1L << ID) | (1L << NL))) != 0) );
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

	public static class DeclContext extends ParserRuleContext {
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	 
		public DeclContext() { }
		public void copyFrom(DeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntVarContext extends DeclContext {
		public List<TerminalNode> ID() { return getTokens(DiscretePLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DiscretePLParser.ID, i);
		}
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public IntVarContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterIntVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitIntVar(this);
		}
	}
	public static class BoolVarContext extends DeclContext {
		public List<TerminalNode> ID() { return getTokens(DiscretePLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DiscretePLParser.ID, i);
		}
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public BoolVarContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterBoolVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitBoolVar(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			int _alt;
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new BoolVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(T__0);
				setState(31);
				match(ID);
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(32);
					match(T__1);
					setState(33);
					match(ID);
					}
					}
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(39);
				match(T__2);
				setState(41); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(40);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(43); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case T__3:
				_localctx = new IntVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__3);
				setState(46);
				match(ID);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(47);
					match(T__1);
					setState(48);
					match(ID);
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54);
				match(T__2);
				setState(56); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(55);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(58); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class DataContext extends ParserRuleContext {
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
	 
		public DataContext() { }
		public void copyFrom(DataContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntReadContext extends DataContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public TerminalNode FILENAME() { return getToken(DiscretePLParser.FILENAME, 0); }
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public IntReadContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterIntRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitIntRead(this);
		}
	}
	public static class BoolArrayContext extends DataContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public List<TerminalNode> C() { return getTokens(DiscretePLParser.C); }
		public TerminalNode C(int i) {
			return getToken(DiscretePLParser.C, i);
		}
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public BoolArrayContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterBoolArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitBoolArray(this);
		}
	}
	public static class BoolReadContext extends DataContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public TerminalNode FILENAME() { return getToken(DiscretePLParser.FILENAME, 0); }
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public BoolReadContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterBoolRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitBoolRead(this);
		}
	}
	public static class IntArrayContext extends DataContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public List<TerminalNode> INT() { return getTokens(DiscretePLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(DiscretePLParser.INT, i);
		}
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public IntArrayContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterIntArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitIntArray(this);
		}
	}
	public static class IntDataContext extends DataContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public TerminalNode INT() { return getToken(DiscretePLParser.INT, 0); }
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public IntDataContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterIntData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitIntData(this);
		}
	}
	public static class BoolDataContext extends DataContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public TerminalNode C() { return getToken(DiscretePLParser.C, 0); }
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public BoolDataContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterBoolData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitBoolData(this);
		}
	}
	public static class DoubleReadContext extends DataContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public TerminalNode FILENAME() { return getToken(DiscretePLParser.FILENAME, 0); }
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public DoubleReadContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterDoubleRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitDoubleRead(this);
		}
	}
	public static class DoubleArrayContext extends DataContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public List<TerminalNode> DOUBLE() { return getTokens(DiscretePLParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(DiscretePLParser.DOUBLE, i);
		}
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public DoubleArrayContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterDoubleArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitDoubleArray(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data);
		int _la;
		try {
			int _alt;
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new IntDataContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(T__3);
				setState(63);
				match(ID);
				setState(64);
				match(T__4);
				setState(65);
				match(INT);
				setState(66);
				match(T__2);
				setState(68); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(67);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(70); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				_localctx = new BoolDataContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(T__0);
				setState(73);
				match(ID);
				setState(74);
				match(T__4);
				setState(75);
				match(C);
				setState(76);
				match(T__2);
				setState(78); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(77);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(80); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				_localctx = new BoolReadContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				match(T__0);
				setState(83);
				match(T__5);
				setState(84);
				match(T__6);
				setState(85);
				match(ID);
				setState(86);
				match(T__4);
				setState(87);
				match(T__7);
				setState(88);
				match(T__8);
				setState(89);
				match(FILENAME);
				setState(90);
				match(T__9);
				setState(91);
				match(T__2);
				setState(93); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(92);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(95); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				_localctx = new IntReadContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				match(T__3);
				setState(98);
				match(T__5);
				setState(99);
				match(T__6);
				setState(100);
				match(ID);
				setState(101);
				match(T__4);
				setState(102);
				match(T__7);
				setState(103);
				match(T__8);
				setState(104);
				match(FILENAME);
				setState(105);
				match(T__9);
				setState(106);
				match(T__2);
				setState(108); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(107);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(110); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				_localctx = new DoubleReadContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(112);
				match(T__10);
				setState(113);
				match(T__5);
				setState(114);
				match(T__6);
				setState(115);
				match(ID);
				setState(116);
				match(T__4);
				setState(117);
				match(T__7);
				setState(118);
				match(T__8);
				setState(119);
				match(FILENAME);
				setState(120);
				match(T__9);
				setState(121);
				match(T__2);
				setState(123); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(122);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(125); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 6:
				_localctx = new BoolArrayContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				match(T__0);
				setState(128);
				match(T__5);
				setState(129);
				match(T__6);
				setState(130);
				match(ID);
				setState(131);
				match(T__4);
				setState(132);
				match(T__11);
				setState(133);
				match(C);
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(134);
					match(T__1);
					setState(135);
					match(C);
					}
					}
					setState(138); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 );
				setState(140);
				match(T__12);
				setState(141);
				match(T__2);
				setState(143); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(142);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(145); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 7:
				_localctx = new IntArrayContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				match(T__3);
				setState(148);
				match(T__5);
				setState(149);
				match(T__6);
				setState(150);
				match(ID);
				setState(151);
				match(T__4);
				setState(152);
				match(T__11);
				setState(153);
				match(INT);
				setState(156); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(154);
					match(T__1);
					setState(155);
					match(INT);
					}
					}
					setState(158); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 );
				setState(160);
				match(T__12);
				setState(161);
				match(T__2);
				setState(163); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(162);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(165); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 8:
				_localctx = new DoubleArrayContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(167);
				match(T__10);
				setState(168);
				match(T__5);
				setState(169);
				match(T__6);
				setState(170);
				match(ID);
				setState(171);
				match(T__4);
				setState(172);
				match(T__11);
				setState(173);
				match(DOUBLE);
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(174);
					match(T__1);
					setState(175);
					match(DOUBLE);
					}
					}
					setState(178); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 );
				setState(180);
				match(T__12);
				setState(181);
				match(T__2);
				setState(183); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(182);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(185); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LoopContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public LoopContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitLoop(this);
		}
	}
	public static class DeterAssgContext extends StatContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeterAssgContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterDeterAssg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitDeterAssg(this);
		}
	}
	public static class DiscreteAssgContext extends StatContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public RContext r() {
			return getRuleContext(RContext.class,0);
		}
		public DiscreteAssgContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterDiscreteAssg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitDiscreteAssg(this);
		}
	}
	public static class InferExpectationContext extends StatContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public InferExpectationContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterInferExpectation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitInferExpectation(this);
		}
	}
	public static class SequentialContext extends StatContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public SequentialContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterSequential(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitSequential(this);
		}
	}
	public static class BernoulliAssgContext extends StatContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public RContext r() {
			return getRuleContext(RContext.class,0);
		}
		public BernoulliAssgContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterBernoulliAssg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitBernoulliAssg(this);
		}
	}
	public static class ObserveContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ObserveContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterObserve(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitObserve(this);
		}
	}
	public static class SkipContext extends StatContext {
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public SkipContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitSkip(this);
		}
	}
	public static class ConditionalContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public EbranchContext ebranch() {
			return getRuleContext(EbranchContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ConditionalContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitConditional(this);
		}
	}
	public static class ForfoldContext extends StatContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public RContext r() {
			return getRuleContext(RContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(DiscretePLParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DiscretePLParser.NL, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ForfoldContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterForfold(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitForfold(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_stat, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				_localctx = new ConditionalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(190);
				match(T__13);
				setState(191);
				match(T__8);
				setState(192);
				expr(0);
				setState(193);
				match(T__9);
				setState(194);
				match(T__11);
				setState(195);
				match(NL);
				setState(197); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(196);
						stat(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(199); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(201);
					match(NL);
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(207);
				match(T__12);
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(208);
					match(NL);
					}
					}
					setState(211); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				setState(213);
				ebranch();
				setState(214);
				match(T__11);
				setState(215);
				match(NL);
				setState(217); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(216);
						stat(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(219); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(221);
					match(NL);
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(227);
				match(T__12);
				setState(229); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(228);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(231); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				{
				_localctx = new LoopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233);
				match(T__14);
				setState(234);
				match(T__8);
				setState(235);
				expr(0);
				setState(236);
				match(T__9);
				setState(237);
				match(T__11);
				setState(238);
				match(NL);
				setState(240); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(239);
						stat(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(242); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(244);
					match(NL);
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250);
				match(T__12);
				setState(252); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(251);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(254); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				{
				_localctx = new ForfoldContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(T__15);
				setState(257);
				match(T__8);
				setState(258);
				match(ID);
				setState(259);
				match(T__16);
				setState(260);
				r();
				setState(261);
				match(T__9);
				setState(262);
				match(T__11);
				setState(263);
				match(NL);
				setState(265); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(264);
						stat(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(267); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(269);
					match(NL);
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(275);
				match(T__12);
				setState(277); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(276);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(279); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				{
				_localctx = new BernoulliAssgContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(281);
				match(ID);
				setState(282);
				match(T__4);
				setState(283);
				match(T__17);
				setState(284);
				match(T__8);
				setState(285);
				r();
				setState(286);
				match(T__9);
				}
				break;
			case 5:
				{
				_localctx = new DiscreteAssgContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				match(ID);
				setState(289);
				match(T__4);
				setState(290);
				match(T__18);
				setState(291);
				match(T__8);
				setState(292);
				r();
				setState(293);
				match(T__9);
				}
				break;
			case 6:
				{
				_localctx = new DeterAssgContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(295);
				match(ID);
				setState(296);
				match(T__4);
				setState(297);
				expr(0);
				}
				break;
			case 7:
				{
				_localctx = new ObserveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				match(T__19);
				setState(299);
				match(T__8);
				setState(300);
				expr(0);
				setState(301);
				match(T__9);
				}
				break;
			case 8:
				{
				_localctx = new InferExpectationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(303);
				match(T__20);
				setState(304);
				match(T__8);
				setState(305);
				match(ID);
				setState(306);
				match(T__9);
				}
				break;
			case 9:
				{
				_localctx = new SkipContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(308); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(307);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(310); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(321);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SequentialContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(314);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(315);
					match(T__2);
					setState(317);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						setState(316);
						stat(0);
						}
						break;
					}
					}
					} 
				}
				setState(323);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RContext extends ParserRuleContext {
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
	 
		public RContext() { }
		public void copyFrom(RContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DoubleNumberContext extends RContext {
		public TerminalNode DOUBLE() { return getToken(DiscretePLParser.DOUBLE, 0); }
		public DoubleNumberContext(RContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterDoubleNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitDoubleNumber(this);
		}
	}
	public static class IntNumberContext extends RContext {
		public TerminalNode INT() { return getToken(DiscretePLParser.INT, 0); }
		public IntNumberContext(RContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterIntNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitIntNumber(this);
		}
	}
	public static class VarOrDataContext extends RContext {
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public VarOrDataContext(RContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterVarOrData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitVarOrData(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_r);
		try {
			setState(327);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarOrDataContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				match(ID);
				}
				break;
			case INT:
				_localctx = new IntNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
				match(INT);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleNumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(326);
				match(DOUBLE);
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

	public static class EbranchContext extends ParserRuleContext {
		public TerminalNode EBRANCH() { return getToken(DiscretePLParser.EBRANCH, 0); }
		public EbranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ebranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterEbranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitEbranch(this);
		}
	}

	public final EbranchContext ebranch() throws RecognitionException {
		EbranchContext _localctx = new EbranchContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ebranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(EBRANCH);
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

	public static class ExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode UOP() { return getToken(DiscretePLParser.UOP, 0); }
		public List<RContext> r() {
			return getRuleContexts(RContext.class);
		}
		public RContext r(int i) {
			return getRuleContext(RContext.class,i);
		}
		public TerminalNode EQ() { return getToken(DiscretePLParser.EQ, 0); }
		public TerminalNode GT() { return getToken(DiscretePLParser.GT, 0); }
		public TerminalNode LT() { return getToken(DiscretePLParser.LT, 0); }
		public TerminalNode ID() { return getToken(DiscretePLParser.ID, 0); }
		public TerminalNode C() { return getToken(DiscretePLParser.C, 0); }
		public TerminalNode INT() { return getToken(DiscretePLParser.INT, 0); }
		public TerminalNode BOP() { return getToken(DiscretePLParser.BOP, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DiscretePLListener ) ((DiscretePLListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(332);
				match(T__8);
				setState(333);
				expr(0);
				setState(334);
				match(T__9);
				}
				break;
			case 2:
				{
				setState(336);
				match(UOP);
				setState(337);
				expr(8);
				}
				break;
			case 3:
				{
				setState(338);
				r();
				setState(339);
				match(EQ);
				setState(340);
				r();
				}
				break;
			case 4:
				{
				setState(342);
				r();
				setState(343);
				match(GT);
				setState(344);
				r();
				}
				break;
			case 5:
				{
				setState(346);
				r();
				setState(347);
				match(LT);
				setState(348);
				r();
				}
				break;
			case 6:
				{
				setState(350);
				match(ID);
				}
				break;
			case 7:
				{
				setState(351);
				match(C);
				}
				break;
			case 8:
				{
				setState(352);
				match(INT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(360);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(355);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(356);
					match(BOP);
					setState(357);
					expr(5);
					}
					} 
				}
				setState(362);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return stat_sempred((StatContext)_localctx, predIndex);
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u016e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2"+
		"\23\3\2\7\2\27\n\2\f\2\16\2\32\13\2\3\2\6\2\35\n\2\r\2\16\2\36\3\3\3\3"+
		"\3\3\3\3\7\3%\n\3\f\3\16\3(\13\3\3\3\3\3\6\3,\n\3\r\3\16\3-\3\3\3\3\3"+
		"\3\3\3\7\3\64\n\3\f\3\16\3\67\13\3\3\3\3\3\6\3;\n\3\r\3\16\3<\5\3?\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\6\4G\n\4\r\4\16\4H\3\4\3\4\3\4\3\4\3\4\3\4\6"+
		"\4Q\n\4\r\4\16\4R\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4`\n\4"+
		"\r\4\16\4a\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4o\n\4\r\4\16"+
		"\4p\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4~\n\4\r\4\16\4\177"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\u008b\n\4\r\4\16\4\u008c\3\4"+
		"\3\4\3\4\6\4\u0092\n\4\r\4\16\4\u0093\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\6\4\u009f\n\4\r\4\16\4\u00a0\3\4\3\4\3\4\6\4\u00a6\n\4\r\4\16\4\u00a7"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\u00b3\n\4\r\4\16\4\u00b4\3\4"+
		"\3\4\3\4\6\4\u00ba\n\4\r\4\16\4\u00bb\5\4\u00be\n\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\6\5\u00c8\n\5\r\5\16\5\u00c9\3\5\7\5\u00cd\n\5\f\5\16\5"+
		"\u00d0\13\5\3\5\3\5\6\5\u00d4\n\5\r\5\16\5\u00d5\3\5\3\5\3\5\3\5\6\5\u00dc"+
		"\n\5\r\5\16\5\u00dd\3\5\7\5\u00e1\n\5\f\5\16\5\u00e4\13\5\3\5\3\5\6\5"+
		"\u00e8\n\5\r\5\16\5\u00e9\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5\u00f3\n\5\r"+
		"\5\16\5\u00f4\3\5\7\5\u00f8\n\5\f\5\16\5\u00fb\13\5\3\5\3\5\6\5\u00ff"+
		"\n\5\r\5\16\5\u0100\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5\u010c\n\5"+
		"\r\5\16\5\u010d\3\5\7\5\u0111\n\5\f\5\16\5\u0114\13\5\3\5\3\5\6\5\u0118"+
		"\n\5\r\5\16\5\u0119\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5\u0137\n"+
		"\5\r\5\16\5\u0138\5\5\u013b\n\5\3\5\3\5\3\5\5\5\u0140\n\5\7\5\u0142\n"+
		"\5\f\5\16\5\u0145\13\5\3\6\3\6\3\6\5\6\u014a\n\6\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\b\u0164\n\b\3\b\3\b\3\b\7\b\u0169\n\b\f\b\16\b\u016c\13\b\3\b\2"+
		"\4\b\16\t\2\4\6\b\n\f\16\2\2\2\u01a1\2\21\3\2\2\2\4>\3\2\2\2\6\u00bd\3"+
		"\2\2\2\b\u013a\3\2\2\2\n\u0149\3\2\2\2\f\u014b\3\2\2\2\16\u0163\3\2\2"+
		"\2\20\22\5\4\3\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2"+
		"\2\24\30\3\2\2\2\25\27\5\6\4\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2"+
		"\2\30\31\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\33\35\5\b\5\2\34\33\3\2\2"+
		"\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\3\3\2\2\2 !\7\3\2\2!&"+
		"\7\"\2\2\"#\7\4\2\2#%\7\"\2\2$\"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2"+
		"\2\')\3\2\2\2(&\3\2\2\2)+\7\5\2\2*,\7&\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2"+
		"\2-.\3\2\2\2.?\3\2\2\2/\60\7\6\2\2\60\65\7\"\2\2\61\62\7\4\2\2\62\64\7"+
		"\"\2\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2"+
		"\2\2\67\65\3\2\2\28:\7\5\2\29;\7&\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<="+
		"\3\2\2\2=?\3\2\2\2> \3\2\2\2>/\3\2\2\2?\5\3\2\2\2@A\7\6\2\2AB\7\"\2\2"+
		"BC\7\7\2\2CD\7\37\2\2DF\7\5\2\2EG\7&\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2"+
		"HI\3\2\2\2I\u00be\3\2\2\2JK\7\3\2\2KL\7\"\2\2LM\7\7\2\2MN\7\32\2\2NP\7"+
		"\5\2\2OQ\7&\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\u00be\3\2\2\2"+
		"TU\7\3\2\2UV\7\b\2\2VW\7\t\2\2WX\7\"\2\2XY\7\7\2\2YZ\7\n\2\2Z[\7\13\2"+
		"\2[\\\7!\2\2\\]\7\f\2\2]_\7\5\2\2^`\7&\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2"+
		"\2ab\3\2\2\2b\u00be\3\2\2\2cd\7\6\2\2de\7\b\2\2ef\7\t\2\2fg\7\"\2\2gh"+
		"\7\7\2\2hi\7\n\2\2ij\7\13\2\2jk\7!\2\2kl\7\f\2\2ln\7\5\2\2mo\7&\2\2nm"+
		"\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\u00be\3\2\2\2rs\7\r\2\2st\7\b"+
		"\2\2tu\7\t\2\2uv\7\"\2\2vw\7\7\2\2wx\7\n\2\2xy\7\13\2\2yz\7!\2\2z{\7\f"+
		"\2\2{}\7\5\2\2|~\7&\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u00be\3\2\2\2\u0081\u0082\7\3\2\2\u0082\u0083\7\b\2\2\u0083"+
		"\u0084\7\t\2\2\u0084\u0085\7\"\2\2\u0085\u0086\7\7\2\2\u0086\u0087\7\16"+
		"\2\2\u0087\u008a\7\32\2\2\u0088\u0089\7\4\2\2\u0089\u008b\7\32\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\17\2\2\u008f\u0091\7\5\2\2\u0090"+
		"\u0092\7&\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u00be\3\2\2\2\u0095\u0096\7\6\2\2\u0096"+
		"\u0097\7\b\2\2\u0097\u0098\7\t\2\2\u0098\u0099\7\"\2\2\u0099\u009a\7\7"+
		"\2\2\u009a\u009b\7\16\2\2\u009b\u009e\7\37\2\2\u009c\u009d\7\4\2\2\u009d"+
		"\u009f\7\37\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3"+
		"\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\17\2\2\u00a3"+
		"\u00a5\7\5\2\2\u00a4\u00a6\7&\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00be\3\2\2\2\u00a9"+
		"\u00aa\7\r\2\2\u00aa\u00ab\7\b\2\2\u00ab\u00ac\7\t\2\2\u00ac\u00ad\7\""+
		"\2\2\u00ad\u00ae\7\7\2\2\u00ae\u00af\7\16\2\2\u00af\u00b2\7 \2\2\u00b0"+
		"\u00b1\7\4\2\2\u00b1\u00b3\7 \2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b7\7\17\2\2\u00b7\u00b9\7\5\2\2\u00b8\u00ba\7&\2\2\u00b9\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00be\3\2\2\2\u00bd@\3\2\2\2\u00bdJ\3\2\2\2\u00bdT\3\2\2\2\u00bdc\3\2"+
		"\2\2\u00bdr\3\2\2\2\u00bd\u0081\3\2\2\2\u00bd\u0095\3\2\2\2\u00bd\u00a9"+
		"\3\2\2\2\u00be\7\3\2\2\2\u00bf\u00c0\b\5\1\2\u00c0\u00c1\7\20\2\2\u00c1"+
		"\u00c2\7\13\2\2\u00c2\u00c3\5\16\b\2\u00c3\u00c4\7\f\2\2\u00c4\u00c5\7"+
		"\16\2\2\u00c5\u00c7\7&\2\2\u00c6\u00c8\5\b\5\2\u00c7\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00ce\3\2"+
		"\2\2\u00cb\u00cd\7&\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2"+
		"\2\2\u00d1\u00d3\7\17\2\2\u00d2\u00d4\7&\2\2\u00d3\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00d8\5\f\7\2\u00d8\u00d9\7\16\2\2\u00d9\u00db\7&\2\2\u00da"+
		"\u00dc\5\b\5\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2"+
		"\2\2\u00dd\u00de\3\2\2\2\u00de\u00e2\3\2\2\2\u00df\u00e1\7&\2\2\u00e0"+
		"\u00df\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e7\7\17\2\2\u00e6"+
		"\u00e8\7&\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u013b\3\2\2\2\u00eb\u00ec\7\21\2\2\u00ec"+
		"\u00ed\7\13\2\2\u00ed\u00ee\5\16\b\2\u00ee\u00ef\7\f\2\2\u00ef\u00f0\7"+
		"\16\2\2\u00f0\u00f2\7&\2\2\u00f1\u00f3\5\b\5\2\u00f2\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f9\3\2"+
		"\2\2\u00f6\u00f8\7&\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fc\u00fe\7\17\2\2\u00fd\u00ff\7&\2\2\u00fe\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u013b\3\2"+
		"\2\2\u0102\u0103\7\22\2\2\u0103\u0104\7\13\2\2\u0104\u0105\7\"\2\2\u0105"+
		"\u0106\7\23\2\2\u0106\u0107\5\n\6\2\u0107\u0108\7\f\2\2\u0108\u0109\7"+
		"\16\2\2\u0109\u010b\7&\2\2\u010a\u010c\5\b\5\2\u010b\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0112\3\2"+
		"\2\2\u010f\u0111\7&\2\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0115\u0117\7\17\2\2\u0116\u0118\7&\2\2\u0117\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u013b\3\2"+
		"\2\2\u011b\u011c\7\"\2\2\u011c\u011d\7\7\2\2\u011d\u011e\7\24\2\2\u011e"+
		"\u011f\7\13\2\2\u011f\u0120\5\n\6\2\u0120\u0121\7\f\2\2\u0121\u013b\3"+
		"\2\2\2\u0122\u0123\7\"\2\2\u0123\u0124\7\7\2\2\u0124\u0125\7\25\2\2\u0125"+
		"\u0126\7\13\2\2\u0126\u0127\5\n\6\2\u0127\u0128\7\f\2\2\u0128\u013b\3"+
		"\2\2\2\u0129\u012a\7\"\2\2\u012a\u012b\7\7\2\2\u012b\u013b\5\16\b\2\u012c"+
		"\u012d\7\26\2\2\u012d\u012e\7\13\2\2\u012e\u012f\5\16\b\2\u012f\u0130"+
		"\7\f\2\2\u0130\u013b\3\2\2\2\u0131\u0132\7\27\2\2\u0132\u0133\7\13\2\2"+
		"\u0133\u0134\7\"\2\2\u0134\u013b\7\f\2\2\u0135\u0137\7&\2\2\u0136\u0135"+
		"\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013b\3\2\2\2\u013a\u00bf\3\2\2\2\u013a\u00eb\3\2\2\2\u013a\u0102\3\2"+
		"\2\2\u013a\u011b\3\2\2\2\u013a\u0122\3\2\2\2\u013a\u0129\3\2\2\2\u013a"+
		"\u012c\3\2\2\2\u013a\u0131\3\2\2\2\u013a\u0136\3\2\2\2\u013b\u0143\3\2"+
		"\2\2\u013c\u013d\f\4\2\2\u013d\u013f\7\5\2\2\u013e\u0140\5\b\5\2\u013f"+
		"\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2\2\2\u0141\u013c\3\2"+
		"\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\t\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u014a\7\"\2\2\u0147\u014a\7\37\2"+
		"\2\u0148\u014a\7 \2\2\u0149\u0146\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u0148"+
		"\3\2\2\2\u014a\13\3\2\2\2\u014b\u014c\7\36\2\2\u014c\r\3\2\2\2\u014d\u014e"+
		"\b\b\1\2\u014e\u014f\7\13\2\2\u014f\u0150\5\16\b\2\u0150\u0151\7\f\2\2"+
		"\u0151\u0164\3\2\2\2\u0152\u0153\7\31\2\2\u0153\u0164\5\16\b\n\u0154\u0155"+
		"\5\n\6\2\u0155\u0156\7\33\2\2\u0156\u0157\5\n\6\2\u0157\u0164\3\2\2\2"+
		"\u0158\u0159\5\n\6\2\u0159\u015a\7\34\2\2\u015a\u015b\5\n\6\2\u015b\u0164"+
		"\3\2\2\2\u015c\u015d\5\n\6\2\u015d\u015e\7\35\2\2\u015e\u015f\5\n\6\2"+
		"\u015f\u0164\3\2\2\2\u0160\u0164\7\"\2\2\u0161\u0164\7\32\2\2\u0162\u0164"+
		"\7\37\2\2\u0163\u014d\3\2\2\2\u0163\u0152\3\2\2\2\u0163\u0154\3\2\2\2"+
		"\u0163\u0158\3\2\2\2\u0163\u015c\3\2\2\2\u0163\u0160\3\2\2\2\u0163\u0161"+
		"\3\2\2\2\u0163\u0162\3\2\2\2\u0164\u016a\3\2\2\2\u0165\u0166\f\6\2\2\u0166"+
		"\u0167\7\30\2\2\u0167\u0169\5\16\b\7\u0168\u0165\3\2\2\2\u0169\u016c\3"+
		"\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\17\3\2\2\2\u016c"+
		"\u016a\3\2\2\2)\23\30\36&-\65<>HRap\177\u008c\u0093\u00a0\u00a7\u00b4"+
		"\u00bb\u00bd\u00c9\u00ce\u00d5\u00dd\u00e2\u00e9\u00f4\u00f9\u0100\u010d"+
		"\u0112\u0119\u0138\u013a\u013f\u0143\u0149\u0163\u016a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}