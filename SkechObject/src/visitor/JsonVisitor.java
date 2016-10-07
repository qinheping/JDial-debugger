package visitor;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import jsonast.*;
import jsonparser.jsonBaseVisitor;
import jsonparser.jsonParser;

public class JsonVisitor extends jsonBaseVisitor<JsonNode> {
	@Override
	public Root visitJson(jsonParser.JsonContext ctx) {
		return new Root((Code) visit(ctx.code()), (Traces) visit(ctx.traces()), (Stdin) visit(ctx.stdin()));
	}

	@Override
	public Code visitCode(jsonParser.CodeContext ctx) {
		return new Code(ctx.STRING().getText());
	}

	@Override
	public Stdin visitStdin(jsonParser.StdinContext ctx) {
		return new Stdin(ctx.STRING().getText());
	}

	@Override
	public Traces visitTraces(jsonParser.TracesContext ctx) {
		List<Trace> t = new ArrayList<Trace>();
		for(int i = 0; i < ctx.trace().size(); i ++){
			t.add((Trace) visit(ctx.trace(i)));
		}
		return new Traces(t);
	}

	@Override
	public Trace visitTrace(jsonParser.TraceContext ctx) {
		return new Trace((String) ctx.stdout().STRING().getText(), (String) ctx.event().STRING().getText(),
				(Integer) Integer.parseInt(ctx.line().getText()), (RenderStack) visit(ctx.stack_to_render().stack()),
				(VarList) visit(ctx.globals()), (VarList) visit(ctx.ordered_globals()),
				(String) ctx.func_name().STRING().getText(), (VarList) visit(ctx.heap()));
	}

	@Override
	public VarList visitGlobals(jsonParser.GlobalsContext ctx) {
		return (VarList) visit(ctx.varlist());
	}

	@Override
	public VarList visitVarlist(jsonParser.VarlistContext ctx) {
		List<Var> varl = new ArrayList<Var>();
		for (jsonParser.VarContext v : ctx.var())
			varl.add((Var) visit(v));
		return new VarList(varl);
	}

	@Override
	public Var visitVar(jsonParser.VarContext ctx) {
		if (ctx.value().children.size() == 1)
			return new Var(ctx.STRING().getText(), Integer.parseInt(ctx.value().NUMBER().getText()));
		if (ctx.value().getChild(1).getText().equals("REF"))
			return new Var(ctx.STRING().getText(), Integer.parseInt(ctx.value().NUMBER().getText()), 2);

		return new Var(ctx.STRING().getText(), 0, 3);
	}

	@Override
	public VarList visitOrdered_globals(jsonParser.Ordered_globalsContext ctx) {
		return (VarList) visit(ctx.varnames());
	}

	@Override
	public VarList visitVarnames(jsonParser.VarnamesContext ctx) {
		List<Var> varl = new ArrayList<Var>();
		for (TerminalNode s : ctx.STRING())
			varl.add(new Var(s.getText(), 0, 0));
		return new VarList(varl);
	}

	@Override
	public VarList visitHeap(jsonParser.HeapContext ctx) {
		return (VarList) visit(ctx.heap_content());
	}

	@Override
	public VarList visitHeap_content(jsonParser.Heap_contentContext ctx) {
		List<Var> varl = new ArrayList<Var>();
		for (jsonParser.Heap_objectContext s : ctx.heap_object())
			varl.add((Var) visit(s));
		return new VarList(varl);
	}

	@Override
	public Var visitHeap_object(jsonParser.Heap_objectContext ctx) {
		List<Integer> intl = new ArrayList<Integer>();
		for (TerminalNode n : ctx.list().NUMBER()) {
			intl.add(Integer.parseInt(n.getText()));
		}
		return new Var(ctx.STRING().getText(), intl);
	}

	@Override
	public RenderStack visitStack(jsonParser.StackContext ctx) {
		List<Frame> flist = new ArrayList<Frame>();
		for (int i = 0; i < ctx.frame().size(); i++) {
			flist.add((Frame) visit(ctx.frame(i)));
		}
		return new RenderStack(flist);
	}

	@Override
	public Frame visitFrame(jsonParser.FrameContext ctx) {
		String name = ctx.func_name().getText();
		VarList encoded_locals = (VarList) visit(ctx.encoded_locals().varlist());
		VarList ordered_varnames = (VarList) visit(ctx.ordered_varnames().varnames());
		//List<Integer> parentId = new ArrayList<Integer>();
		boolean is_highlighted = ctx.is_highlighted().BOOLEAN().equals("true");
		boolean is_zombie = ctx.is_zombie().BOOLEAN().equals("true");
		Integer id = Integer.parseInt(ctx.frame_id().NUMBER().getText());
		return new Frame(name, encoded_locals, ordered_varnames, is_highlighted, is_zombie, id);
	}
	
	@Override
	public VarList visitEncoded_locals(jsonParser.Encoded_localsContext ctx){
		return (VarList)visit(ctx.varlist());
	}
	
	@Override
	public VarList visitOrdered_varnames(jsonParser.Ordered_varnamesContext ctx){
		return (VarList)visit(ctx.varnames());
	}
	
	// visitParent_frame_id_list

}
