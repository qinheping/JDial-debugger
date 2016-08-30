package visitor;

import java.util.List;

import javaparser.*;
import sketchobj.core.*;
import sketchobj.expr.*;
import sketchobj.stmts.*;

public class EvalVisitor extends simpleJavaBaseVisitor<SketchObject> {

	/** methodModifier* methodHeader methodBody **/
	@Override
	public SketchObject visitMethodDeclaration(simpleJavaParser.MethodDeclarationContext ctx) {
		FcnHeader head = (FcnHeader) visit(ctx.methodHeader());
		Statement body = (Statement) visit(ctx.methodBody());
		return new Function(head, body);
	}

	/** result methodDeclarator throws_? **/
	@Override
	public SketchObject visitExpandHeader(simpleJavaParser.ExpandHeaderContext ctx) {
		FcnHeader head = (FcnHeader) visit(ctx.methodDeclarator());
		head.setReturnType((Type) visit(ctx.result()));
		return head;
	}

	/** Identifier '(' formalParameterList? ')' dims? **/
	@Override
	public SketchObject visitMethodDeclarator(simpleJavaParser.MethodDeclaratorContext ctx) {
		return new FcnHeader(ctx.Identifier().getText(), null, (ParametersList) visit(ctx.formalParameterList()));
	}

	/** : unannType | 'void' **/
	@Override
	public SketchObject visitResult(simpleJavaParser.ResultContext ctx) {
		if (ctx.start.getText().equals("void")) {
			throw new IllegalArgumentException("Invalid return type " + ctx.start.getText());
		}
		return visit(ctx.unannType());
	}

	/** unannPrimitiveType **/
	@Override
	public SketchObject visitUnannTypePri(simpleJavaParser.UnannTypePriContext ctx) {
		return visit(ctx.unannPrimitiveType());
	}

	@Override
	public SketchObject visitBoolType(simpleJavaParser.BoolTypeContext ctx) {
		return new TypePrimitive(TypePrimitive.TYPE_BIT);
	}

	@Override
	public SketchObject visitNumType(simpleJavaParser.NumTypeContext ctx) {
		return visit(ctx.numericType());
	}

	@Override
	public SketchObject visitNumericIntegeralType(simpleJavaParser.NumericIntegeralTypeContext ctx) {
		return visit(ctx.integralType());
	}

	@Override
	public SketchObject visitIntegralType(simpleJavaParser.IntegralTypeContext ctx) {
		String t = ctx.getStart().getText();
		switch (t) {
		case "byte":
			return new TypePrimitive(TypePrimitive.TYPE_BIT);
		case "short":
			return new TypePrimitive(TypePrimitive.TYPE_INT16);
		case "int":
			return new TypePrimitive(TypePrimitive.TYPE_INT);
		case "long":
			return new TypePrimitive(TypePrimitive.TYPE_INT64);
		case "char":
			return new TypePrimitive(TypePrimitive.TYPE_CHAR);
		default:
			throw new IllegalArgumentException("Unknown type " + t);
		}
	}

	@Override
	public SketchObject visitNumericFloatingPointType(simpleJavaParser.NumericFloatingPointTypeContext ctx) {
		return visit(ctx.floatingPointType());
	}
	
	@Override
	public SketchObject visitFloatingPointType(simpleJavaParser.FloatingPointTypeContext ctx) {
		String t = ctx.getStart().getText();
		switch (t) {
		case "float":
			return new TypePrimitive(TypePrimitive.TYPE_FLOAT);
		case "double":
			return new TypePrimitive(TypePrimitive.TYPE_DOUBLE);
		default:
			throw new IllegalArgumentException("Unknown type " + t);
		}
	}

	/** unannReferenceType **/
	@Override
	public SketchObject visitUnannTypeRef(simpleJavaParser.UnannTypeRefContext ctx) {
		return visit(ctx.unannReferenceType());
	}
	
	@Override
	public SketchObject visitUarrayType(simpleJavaParser.UarrayTypeContext ctx){
		return visit(ctx.unannArrayType());
	}
	
	/** unannPrimitiveType dims **/
	@Override 
	public SketchObject visitUnannArrayTypePri(simpleJavaParser.UnannArrayTypePriContext ctx){
		return new TypeArray((Type)visit(ctx.unannPrimitiveType()), null);
	}
	
	/** annotation* '[' ']' (annotation* '[' ']')* **/
	@Override
	public SketchObject visitDims(simpleJavaParser.DimsContext ctx){
		// TODO 2dimArray
		return null;
	}

	/** formalParameters ',' lastFormalParameter **/
	@Override
	public SketchObject visitExpandParaList(simpleJavaParser.ExpandParaListContext ctx){
		ParametersList list = (ParametersList)visit(ctx.formalParameters());
		list.add((Parameter) visit(ctx.lastFormalParameter()));
		return list;
	}
	
	/** lastFormalParameter **/
	@Override
	public SketchObject visitOnlyOnePara(simpleJavaParser.OnlyOneParaContext ctx){
		ParametersList list = new ParametersList();
		list.add((Parameter) visit(ctx.lastFormalParameter()));
		return list;
	}
	
	@Override
	public SketchObject visitExpandLastPara(simpleJavaParser.ExpandLastParaContext ctx){
		return visit(ctx.formalParameter());
	}
	
	/** variableModifier* unannType variableDeclaratorId **/
}
