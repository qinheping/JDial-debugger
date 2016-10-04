// Generated from json.g4 by ANTLR 4.5.3
package jsonparser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link jsonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface jsonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link jsonParser#json}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson(jsonParser.JsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(jsonParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#stdin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStdin(jsonParser.StdinContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#traces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraces(jsonParser.TracesContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#trace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrace(jsonParser.TraceContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#userlog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserlog(jsonParser.UserlogContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#stdout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStdout(jsonParser.StdoutContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(jsonParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(jsonParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#globals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobals(jsonParser.GlobalsContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#ordered_globals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdered_globals(jsonParser.Ordered_globalsContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#func_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_name(jsonParser.Func_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#heap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeap(jsonParser.HeapContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#varlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarlist(jsonParser.VarlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(jsonParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(jsonParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#heap_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeap_content(jsonParser.Heap_contentContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#heap_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeap_object(jsonParser.Heap_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(jsonParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#stack_to_render}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStack_to_render(jsonParser.Stack_to_renderContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#stack}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStack(jsonParser.StackContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#frame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrame(jsonParser.FrameContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#encoded_locals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncoded_locals(jsonParser.Encoded_localsContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#varnames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarnames(jsonParser.VarnamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#ordered_varnames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdered_varnames(jsonParser.Ordered_varnamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#parent_frame_id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent_frame_id_list(jsonParser.Parent_frame_id_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#is_highlighted}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_highlighted(jsonParser.Is_highlightedContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#is_zombie}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_zombie(jsonParser.Is_zombieContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#is_parent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_parent(jsonParser.Is_parentContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#unique_hash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnique_hash(jsonParser.Unique_hashContext ctx);
	/**
	 * Visit a parse tree produced by {@link jsonParser#frame_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrame_id(jsonParser.Frame_idContext ctx);
}