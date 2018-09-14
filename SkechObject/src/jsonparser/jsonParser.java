// Generated from json.g4 by ANTLR 4.5.3
package jsonparser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class jsonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, COLON=28, COMMA=29, BOOLEAN=30, STRING=31, 
		ESC=32, NUMBER=33, WS=34;
	public static final int
		RULE_json = 0, RULE_code = 1, RULE_stdin = 2, RULE_traces = 3, RULE_trace = 4, 
		RULE_userlog = 5, RULE_stdout = 6, RULE_event = 7, RULE_line = 8, RULE_globals = 9, 
		RULE_ordered_globals = 10, RULE_func_name = 11, RULE_heap = 12, RULE_varlist = 13, 
		RULE_var = 14, RULE_value = 15, RULE_heap_content = 16, RULE_heap_object = 17, 
		RULE_list = 18, RULE_stack_to_render = 19, RULE_stack = 20, RULE_frame = 21, 
		RULE_encoded_locals = 22, RULE_varnames = 23, RULE_ordered_varnames = 24, 
		RULE_parent_frame_id_list = 25, RULE_is_highlighted = 26, RULE_is_zombie = 27, 
		RULE_is_parent = 28, RULE_unique_hash = 29, RULE_frame_id = 30;
	public static final String[] ruleNames = {
		"json", "code", "stdin", "traces", "trace", "userlog", "stdout", "event", 
		"line", "globals", "ordered_globals", "func_name", "heap", "varlist", 
		"var", "value", "heap_content", "heap_object", "list", "stack_to_render", 
		"stack", "frame", "encoded_locals", "varnames", "ordered_varnames", "parent_frame_id_list", 
		"is_highlighted", "is_zombie", "is_parent", "unique_hash", "frame_id"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'\"code\"'", "'\"stdin\"'", "'\"trace\"'", "'\"userlog\"'", 
		"'}'", "'['", "']'", "'\"stdout\"'", "'\"event\"'", "'\"line\"'", "'\"globals\"'", 
		"'\"ordered_globals\"'", "'\"func_name\"'", "'\"heap\"'", "'\"REF\"'", 
		"'\"VOID\"'", "'\"LIST\"'", "'\"stack_to_render\"'", "'\"encoded_locals\"'", 
		"'\"ordered_varnames\"'", "'\"parent_frame_id_list\"'", "'\"is_highlighted\"'", 
		"'\"is_zombie\"'", "'\"is_parent\"'", "'\"unique_hash\"'", "'\"frame_id\"'", 
		"':'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "COLON", "COMMA", "BOOLEAN", "STRING", "ESC", 
		"NUMBER", "WS"
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

	@Override
	public String getGrammarFileName() { return "json.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public jsonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class JsonContext extends ParserRuleContext {
		public List<TerminalNode> COLON() { return getTokens(jsonParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(jsonParser.COLON, i);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(jsonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(jsonParser.COMMA, i);
		}
		public StdinContext stdin() {
			return getRuleContext(StdinContext.class,0);
		}
		public TracesContext traces() {
			return getRuleContext(TracesContext.class,0);
		}
		public UserlogContext userlog() {
			return getRuleContext(UserlogContext.class,0);
		}
		public JsonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitJson(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonContext json() throws RecognitionException {
		JsonContext _localctx = new JsonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_json);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__0);
			setState(63);
			match(T__1);
			setState(64);
			match(COLON);
			setState(65);
			code();
			setState(66);
			match(COMMA);
			setState(67);
			match(T__2);
			setState(68);
			match(COLON);
			setState(69);
			stdin();
			setState(70);
			match(COMMA);
			setState(71);
			match(T__3);
			setState(72);
			match(COLON);
			setState(73);
			traces();
			setState(74);
			match(COMMA);
			setState(75);
			match(T__4);
			setState(76);
			match(COLON);
			setState(77);
			userlog();
			setState(78);
			match(T__5);
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

	public static class CodeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(STRING);
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

	public static class StdinContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public StdinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stdin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitStdin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StdinContext stdin() throws RecognitionException {
		StdinContext _localctx = new StdinContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stdin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(STRING);
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

	public static class TracesContext extends ParserRuleContext {
		public List<TraceContext> trace() {
			return getRuleContexts(TraceContext.class);
		}
		public TraceContext trace(int i) {
			return getRuleContext(TraceContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(jsonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(jsonParser.COMMA, i);
		}
		public TracesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traces; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitTraces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TracesContext traces() throws RecognitionException {
		TracesContext _localctx = new TracesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_traces);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__6);
			setState(90);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(85);
					trace();
					setState(86);
					match(COMMA);
					}
					} 
				}
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(93);
			trace();
			setState(94);
			match(T__7);
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

	public static class TraceContext extends ParserRuleContext {
		public StdoutContext stdout() {
			return getRuleContext(StdoutContext.class,0);
		}
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public Stack_to_renderContext stack_to_render() {
			return getRuleContext(Stack_to_renderContext.class,0);
		}
		public GlobalsContext globals() {
			return getRuleContext(GlobalsContext.class,0);
		}
		public Ordered_globalsContext ordered_globals() {
			return getRuleContext(Ordered_globalsContext.class,0);
		}
		public Func_nameContext func_name() {
			return getRuleContext(Func_nameContext.class,0);
		}
		public HeapContext heap() {
			return getRuleContext(HeapContext.class,0);
		}
		public TraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trace; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitTrace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraceContext trace() throws RecognitionException {
		TraceContext _localctx = new TraceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_trace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__0);
			setState(97);
			stdout();
			setState(98);
			event();
			setState(99);
			line();
			setState(100);
			stack_to_render();
			setState(101);
			globals();
			setState(102);
			ordered_globals();
			setState(103);
			func_name();
			setState(104);
			heap();
			setState(105);
			match(T__5);
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

	public static class UserlogContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public UserlogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userlog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitUserlog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserlogContext userlog() throws RecognitionException {
		UserlogContext _localctx = new UserlogContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_userlog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(STRING);
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

	public static class StdoutContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public StdoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stdout; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitStdout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StdoutContext stdout() throws RecognitionException {
		StdoutContext _localctx = new StdoutContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stdout);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__8);
			setState(110);
			match(COLON);
			setState(111);
			match(STRING);
			setState(112);
			match(COMMA);
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

	public static class EventContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_event);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__9);
			setState(115);
			match(COLON);
			setState(116);
			match(STRING);
			setState(117);
			match(COMMA);
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

	public static class LineContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode NUMBER() { return getToken(jsonParser.NUMBER, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__10);
			setState(120);
			match(COLON);
			setState(121);
			match(NUMBER);
			setState(122);
			match(COMMA);
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

	public static class GlobalsContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public VarlistContext varlist() {
			return getRuleContext(VarlistContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public GlobalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitGlobals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalsContext globals() throws RecognitionException {
		GlobalsContext _localctx = new GlobalsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_globals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__11);
			setState(125);
			match(COLON);
			setState(126);
			match(T__0);
			setState(127);
			varlist();
			setState(128);
			match(T__5);
			setState(129);
			match(COMMA);
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

	public static class Ordered_globalsContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public VarnamesContext varnames() {
			return getRuleContext(VarnamesContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public Ordered_globalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordered_globals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitOrdered_globals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ordered_globalsContext ordered_globals() throws RecognitionException {
		Ordered_globalsContext _localctx = new Ordered_globalsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ordered_globals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__12);
			setState(132);
			match(COLON);
			setState(133);
			match(T__6);
			setState(134);
			varnames();
			setState(135);
			match(T__7);
			setState(136);
			match(COMMA);
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

	public static class Func_nameContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public Func_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitFunc_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_nameContext func_name() throws RecognitionException {
		Func_nameContext _localctx = new Func_nameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_func_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__13);
			setState(139);
			match(COLON);
			setState(140);
			match(STRING);
			setState(141);
			match(COMMA);
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

	public static class HeapContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public Heap_contentContext heap_content() {
			return getRuleContext(Heap_contentContext.class,0);
		}
		public HeapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_heap; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitHeap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeapContext heap() throws RecognitionException {
		HeapContext _localctx = new HeapContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_heap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__14);
			setState(144);
			match(COLON);
			setState(145);
			match(T__0);
			setState(146);
			heap_content();
			setState(147);
			match(T__5);
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

	public static class VarlistContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(jsonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(jsonParser.COMMA, i);
		}
		public VarlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitVarlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarlistContext varlist() throws RecognitionException {
		VarlistContext _localctx = new VarlistContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(149);
					var();
					setState(150);
					match(COMMA);
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(158);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(157);
				var();
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(STRING);
			setState(161);
			match(COLON);
			setState(162);
			value();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(jsonParser.NUMBER, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(T__6);
				setState(166);
				match(T__15);
				setState(167);
				match(COMMA);
				setState(168);
				match(NUMBER);
				setState(169);
				match(T__7);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(T__6);
				setState(171);
				match(T__16);
				setState(172);
				match(T__7);
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

	public static class Heap_contentContext extends ParserRuleContext {
		public List<Heap_objectContext> heap_object() {
			return getRuleContexts(Heap_objectContext.class);
		}
		public Heap_objectContext heap_object(int i) {
			return getRuleContext(Heap_objectContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(jsonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(jsonParser.COMMA, i);
		}
		public Heap_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_heap_content; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitHeap_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Heap_contentContext heap_content() throws RecognitionException {
		Heap_contentContext _localctx = new Heap_contentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_heap_content);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(175);
					heap_object();
					setState(176);
					match(COMMA);
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(184);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(183);
				heap_object();
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

	public static class Heap_objectContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public Heap_objectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_heap_object; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitHeap_object(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Heap_objectContext heap_object() throws RecognitionException {
		Heap_objectContext _localctx = new Heap_objectContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_heap_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(STRING);
			setState(187);
			match(COLON);
			setState(188);
			match(T__6);
			setState(189);
			match(T__17);
			setState(190);
			match(COMMA);
			setState(191);
			list();
			setState(192);
			match(T__7);
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

	public static class ListContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(jsonParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(jsonParser.NUMBER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(jsonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(jsonParser.COMMA, i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(194);
					match(NUMBER);
					setState(195);
					match(COMMA);
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(201);
			match(NUMBER);
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

	public static class Stack_to_renderContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public StackContext stack() {
			return getRuleContext(StackContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public Stack_to_renderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stack_to_render; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitStack_to_render(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stack_to_renderContext stack_to_render() throws RecognitionException {
		Stack_to_renderContext _localctx = new Stack_to_renderContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_stack_to_render);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__18);
			setState(204);
			match(COLON);
			setState(205);
			match(T__6);
			setState(206);
			stack();
			setState(207);
			match(T__7);
			setState(208);
			match(COMMA);
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

	public static class StackContext extends ParserRuleContext {
		public List<FrameContext> frame() {
			return getRuleContexts(FrameContext.class);
		}
		public FrameContext frame(int i) {
			return getRuleContext(FrameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(jsonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(jsonParser.COMMA, i);
		}
		public StackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stack; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitStack(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StackContext stack() throws RecognitionException {
		StackContext _localctx = new StackContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stack);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(210);
					match(T__0);
					setState(211);
					frame();
					setState(212);
					match(T__5);
					setState(213);
					match(COMMA);
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(220);
			match(T__0);
			setState(221);
			frame();
			setState(222);
			match(T__5);
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

	public static class FrameContext extends ParserRuleContext {
		public Func_nameContext func_name() {
			return getRuleContext(Func_nameContext.class,0);
		}
		public Encoded_localsContext encoded_locals() {
			return getRuleContext(Encoded_localsContext.class,0);
		}
		public Ordered_varnamesContext ordered_varnames() {
			return getRuleContext(Ordered_varnamesContext.class,0);
		}
		public Parent_frame_id_listContext parent_frame_id_list() {
			return getRuleContext(Parent_frame_id_listContext.class,0);
		}
		public Is_highlightedContext is_highlighted() {
			return getRuleContext(Is_highlightedContext.class,0);
		}
		public Is_zombieContext is_zombie() {
			return getRuleContext(Is_zombieContext.class,0);
		}
		public Is_parentContext is_parent() {
			return getRuleContext(Is_parentContext.class,0);
		}
		public Unique_hashContext unique_hash() {
			return getRuleContext(Unique_hashContext.class,0);
		}
		public Frame_idContext frame_id() {
			return getRuleContext(Frame_idContext.class,0);
		}
		public FrameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitFrame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameContext frame() throws RecognitionException {
		FrameContext _localctx = new FrameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_frame);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			func_name();
			setState(225);
			encoded_locals();
			setState(226);
			ordered_varnames();
			setState(227);
			parent_frame_id_list();
			setState(228);
			is_highlighted();
			setState(229);
			is_zombie();
			setState(230);
			is_parent();
			setState(231);
			unique_hash();
			setState(232);
			frame_id();
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

	public static class Encoded_localsContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public VarlistContext varlist() {
			return getRuleContext(VarlistContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public Encoded_localsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_encoded_locals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitEncoded_locals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Encoded_localsContext encoded_locals() throws RecognitionException {
		Encoded_localsContext _localctx = new Encoded_localsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_encoded_locals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__19);
			setState(235);
			match(COLON);
			setState(236);
			match(T__0);
			setState(237);
			varlist();
			setState(238);
			match(T__5);
			setState(239);
			match(COMMA);
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

	public static class VarnamesContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(jsonParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(jsonParser.STRING, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(jsonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(jsonParser.COMMA, i);
		}
		public VarnamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varnames; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitVarnames(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarnamesContext varnames() throws RecognitionException {
		VarnamesContext _localctx = new VarnamesContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_varnames);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(241);
					match(STRING);
					setState(242);
					match(COMMA);
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(249);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(248);
				match(STRING);
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

	public static class Ordered_varnamesContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public VarnamesContext varnames() {
			return getRuleContext(VarnamesContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public Ordered_varnamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordered_varnames; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitOrdered_varnames(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ordered_varnamesContext ordered_varnames() throws RecognitionException {
		Ordered_varnamesContext _localctx = new Ordered_varnamesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ordered_varnames);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__20);
			setState(252);
			match(COLON);
			setState(253);
			match(T__6);
			setState(254);
			varnames();
			setState(255);
			match(T__7);
			setState(256);
			match(COMMA);
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

	public static class Parent_frame_id_listContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public Parent_frame_id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parent_frame_id_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitParent_frame_id_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parent_frame_id_listContext parent_frame_id_list() throws RecognitionException {
		Parent_frame_id_listContext _localctx = new Parent_frame_id_listContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parent_frame_id_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(T__21);
			setState(259);
			match(COLON);
			setState(260);
			match(T__6);
			setState(261);
			match(T__7);
			setState(262);
			match(COMMA);
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

	public static class Is_highlightedContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode BOOLEAN() { return getToken(jsonParser.BOOLEAN, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public Is_highlightedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_highlighted; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitIs_highlighted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Is_highlightedContext is_highlighted() throws RecognitionException {
		Is_highlightedContext _localctx = new Is_highlightedContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_is_highlighted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(T__22);
			setState(265);
			match(COLON);
			setState(266);
			match(BOOLEAN);
			setState(267);
			match(COMMA);
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

	public static class Is_zombieContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode BOOLEAN() { return getToken(jsonParser.BOOLEAN, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public Is_zombieContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_zombie; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitIs_zombie(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Is_zombieContext is_zombie() throws RecognitionException {
		Is_zombieContext _localctx = new Is_zombieContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_is_zombie);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(T__23);
			setState(270);
			match(COLON);
			setState(271);
			match(BOOLEAN);
			setState(272);
			match(COMMA);
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

	public static class Is_parentContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode BOOLEAN() { return getToken(jsonParser.BOOLEAN, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public Is_parentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_parent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitIs_parent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Is_parentContext is_parent() throws RecognitionException {
		Is_parentContext _localctx = new Is_parentContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_is_parent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(T__24);
			setState(275);
			match(COLON);
			setState(276);
			match(BOOLEAN);
			setState(277);
			match(COMMA);
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

	public static class Unique_hashContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public TerminalNode COMMA() { return getToken(jsonParser.COMMA, 0); }
		public Unique_hashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unique_hash; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitUnique_hash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unique_hashContext unique_hash() throws RecognitionException {
		Unique_hashContext _localctx = new Unique_hashContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unique_hash);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__25);
			setState(280);
			match(COLON);
			setState(281);
			match(STRING);
			setState(282);
			match(COMMA);
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

	public static class Frame_idContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(jsonParser.COLON, 0); }
		public TerminalNode NUMBER() { return getToken(jsonParser.NUMBER, 0); }
		public Frame_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof jsonVisitor ) return ((jsonVisitor<? extends T>)visitor).visitFrame_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Frame_idContext frame_id() throws RecognitionException {
		Frame_idContext _localctx = new Frame_idContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_frame_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__26);
			setState(285);
			match(COLON);
			setState(286);
			match(NUMBER);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$\u0123\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\7\5[\n\5\f\5\16\5^\13\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\7\17\u009b\n\17\f\17\16\17\u009e\13\17\3\17"+
		"\5\17\u00a1\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00b0\n\21\3\22\3\22\3\22\7\22\u00b5\n\22\f\22\16\22\u00b8"+
		"\13\22\3\22\5\22\u00bb\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\7\24\u00c7\n\24\f\24\16\24\u00ca\13\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\7\26\u00da\n\26\f\26"+
		"\16\26\u00dd\13\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\7\31\u00f6"+
		"\n\31\f\31\16\31\u00f9\13\31\3\31\5\31\u00fc\n\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \2\2!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\668:<>\2\2\u010e\2@\3\2\2\2\4R\3\2\2\2\6T\3\2\2\2\bV\3\2"+
		"\2\2\nb\3\2\2\2\fm\3\2\2\2\16o\3\2\2\2\20t\3\2\2\2\22y\3\2\2\2\24~\3\2"+
		"\2\2\26\u0085\3\2\2\2\30\u008c\3\2\2\2\32\u0091\3\2\2\2\34\u009c\3\2\2"+
		"\2\36\u00a2\3\2\2\2 \u00af\3\2\2\2\"\u00b6\3\2\2\2$\u00bc\3\2\2\2&\u00c8"+
		"\3\2\2\2(\u00cd\3\2\2\2*\u00db\3\2\2\2,\u00e2\3\2\2\2.\u00ec\3\2\2\2\60"+
		"\u00f7\3\2\2\2\62\u00fd\3\2\2\2\64\u0104\3\2\2\2\66\u010a\3\2\2\28\u010f"+
		"\3\2\2\2:\u0114\3\2\2\2<\u0119\3\2\2\2>\u011e\3\2\2\2@A\7\3\2\2AB\7\4"+
		"\2\2BC\7\36\2\2CD\5\4\3\2DE\7\37\2\2EF\7\5\2\2FG\7\36\2\2GH\5\6\4\2HI"+
		"\7\37\2\2IJ\7\6\2\2JK\7\36\2\2KL\5\b\5\2LM\7\37\2\2MN\7\7\2\2NO\7\36\2"+
		"\2OP\5\f\7\2PQ\7\b\2\2Q\3\3\2\2\2RS\7!\2\2S\5\3\2\2\2TU\7!\2\2U\7\3\2"+
		"\2\2V\\\7\t\2\2WX\5\n\6\2XY\7\37\2\2Y[\3\2\2\2ZW\3\2\2\2[^\3\2\2\2\\Z"+
		"\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\5\n\6\2`a\7\n\2\2a\t\3\2\2"+
		"\2bc\7\3\2\2cd\5\16\b\2de\5\20\t\2ef\5\22\n\2fg\5(\25\2gh\5\24\13\2hi"+
		"\5\26\f\2ij\5\30\r\2jk\5\32\16\2kl\7\b\2\2l\13\3\2\2\2mn\7!\2\2n\r\3\2"+
		"\2\2op\7\13\2\2pq\7\36\2\2qr\7!\2\2rs\7\37\2\2s\17\3\2\2\2tu\7\f\2\2u"+
		"v\7\36\2\2vw\7!\2\2wx\7\37\2\2x\21\3\2\2\2yz\7\r\2\2z{\7\36\2\2{|\7#\2"+
		"\2|}\7\37\2\2}\23\3\2\2\2~\177\7\16\2\2\177\u0080\7\36\2\2\u0080\u0081"+
		"\7\3\2\2\u0081\u0082\5\34\17\2\u0082\u0083\7\b\2\2\u0083\u0084\7\37\2"+
		"\2\u0084\25\3\2\2\2\u0085\u0086\7\17\2\2\u0086\u0087\7\36\2\2\u0087\u0088"+
		"\7\t\2\2\u0088\u0089\5\60\31\2\u0089\u008a\7\n\2\2\u008a\u008b\7\37\2"+
		"\2\u008b\27\3\2\2\2\u008c\u008d\7\20\2\2\u008d\u008e\7\36\2\2\u008e\u008f"+
		"\7!\2\2\u008f\u0090\7\37\2\2\u0090\31\3\2\2\2\u0091\u0092\7\21\2\2\u0092"+
		"\u0093\7\36\2\2\u0093\u0094\7\3\2\2\u0094\u0095\5\"\22\2\u0095\u0096\7"+
		"\b\2\2\u0096\33\3\2\2\2\u0097\u0098\5\36\20\2\u0098\u0099\7\37\2\2\u0099"+
		"\u009b\3\2\2\2\u009a\u0097\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a1\5\36\20\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\35\3\2"+
		"\2\2\u00a2\u00a3\7!\2\2\u00a3\u00a4\7\36\2\2\u00a4\u00a5\5 \21\2\u00a5"+
		"\37\3\2\2\2\u00a6\u00b0\7#\2\2\u00a7\u00a8\7\t\2\2\u00a8\u00a9\7\22\2"+
		"\2\u00a9\u00aa\7\37\2\2\u00aa\u00ab\7#\2\2\u00ab\u00b0\7\n\2\2\u00ac\u00ad"+
		"\7\t\2\2\u00ad\u00ae\7\23\2\2\u00ae\u00b0\7\n\2\2\u00af\u00a6\3\2\2\2"+
		"\u00af\u00a7\3\2\2\2\u00af\u00ac\3\2\2\2\u00b0!\3\2\2\2\u00b1\u00b2\5"+
		"$\23\2\u00b2\u00b3\7\37\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00ba\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\5$\23\2\u00ba\u00b9\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb#\3\2\2\2\u00bc\u00bd\7!\2\2\u00bd\u00be\7\36\2\2"+
		"\u00be\u00bf\7\t\2\2\u00bf\u00c0\7\24\2\2\u00c0\u00c1\7\37\2\2\u00c1\u00c2"+
		"\5&\24\2\u00c2\u00c3\7\n\2\2\u00c3%\3\2\2\2\u00c4\u00c5\7#\2\2\u00c5\u00c7"+
		"\7\37\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc"+
		"\7#\2\2\u00cc\'\3\2\2\2\u00cd\u00ce\7\25\2\2\u00ce\u00cf\7\36\2\2\u00cf"+
		"\u00d0\7\t\2\2\u00d0\u00d1\5*\26\2\u00d1\u00d2\7\n\2\2\u00d2\u00d3\7\37"+
		"\2\2\u00d3)\3\2\2\2\u00d4\u00d5\7\3\2\2\u00d5\u00d6\5,\27\2\u00d6\u00d7"+
		"\7\b\2\2\u00d7\u00d8\7\37\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d4\3\2\2\2"+
		"\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de"+
		"\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7\3\2\2\u00df\u00e0\5,\27\2\u00e0"+
		"\u00e1\7\b\2\2\u00e1+\3\2\2\2\u00e2\u00e3\5\30\r\2\u00e3\u00e4\5.\30\2"+
		"\u00e4\u00e5\5\62\32\2\u00e5\u00e6\5\64\33\2\u00e6\u00e7\5\66\34\2\u00e7"+
		"\u00e8\58\35\2\u00e8\u00e9\5:\36\2\u00e9\u00ea\5<\37\2\u00ea\u00eb\5>"+
		" \2\u00eb-\3\2\2\2\u00ec\u00ed\7\26\2\2\u00ed\u00ee\7\36\2\2\u00ee\u00ef"+
		"\7\3\2\2\u00ef\u00f0\5\34\17\2\u00f0\u00f1\7\b\2\2\u00f1\u00f2\7\37\2"+
		"\2\u00f2/\3\2\2\2\u00f3\u00f4\7!\2\2\u00f4\u00f6\7\37\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fc\7!\2\2\u00fb\u00fa\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc\61\3\2\2\2\u00fd\u00fe\7\27\2\2\u00fe\u00ff"+
		"\7\36\2\2\u00ff\u0100\7\t\2\2\u0100\u0101\5\60\31\2\u0101\u0102\7\n\2"+
		"\2\u0102\u0103\7\37\2\2\u0103\63\3\2\2\2\u0104\u0105\7\30\2\2\u0105\u0106"+
		"\7\36\2\2\u0106\u0107\7\t\2\2\u0107\u0108\7\n\2\2\u0108\u0109\7\37\2\2"+
		"\u0109\65\3\2\2\2\u010a\u010b\7\31\2\2\u010b\u010c\7\36\2\2\u010c\u010d"+
		"\7 \2\2\u010d\u010e\7\37\2\2\u010e\67\3\2\2\2\u010f\u0110\7\32\2\2\u0110"+
		"\u0111\7\36\2\2\u0111\u0112\7 \2\2\u0112\u0113\7\37\2\2\u01139\3\2\2\2"+
		"\u0114\u0115\7\33\2\2\u0115\u0116\7\36\2\2\u0116\u0117\7 \2\2\u0117\u0118"+
		"\7\37\2\2\u0118;\3\2\2\2\u0119\u011a\7\34\2\2\u011a\u011b\7\36\2\2\u011b"+
		"\u011c\7!\2\2\u011c\u011d\7\37\2\2\u011d=\3\2\2\2\u011e\u011f\7\35\2\2"+
		"\u011f\u0120\7\36\2\2\u0120\u0121\7#\2\2\u0121?\3\2\2\2\f\\\u009c\u00a0"+
		"\u00af\u00b6\u00ba\u00c8\u00db\u00f7\u00fb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}