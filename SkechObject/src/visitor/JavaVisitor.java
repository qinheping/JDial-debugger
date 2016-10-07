package visitor;

import java.util.ArrayList;
import java.util.List;

import javaparser.*;
import sketchobj.core.*;
import sketchobj.expr.*;
import sketchobj.expr.ExprArrayRange.RangeLen;
import sketchobj.stmts.*;

public class JavaVisitor extends simpleJavaBaseVisitor<SketchObject> {

	// ----------head----------

	private String targetFunc;

	public JavaVisitor(String targetFunc) {
		this.targetFunc = targetFunc;
	}

	/**
	 * compilationUnit : packageDeclaration? importDeclaration* typeDeclaration*
	 * EOF
	 **/
	@Override
	public SketchObject visitCompilationUnit(simpleJavaParser.CompilationUnitContext ctx) {
		return visit(ctx.typeDeclaration(0).classDeclaration().normalClassDeclaration().classBody());
	}

	/**
	 * classBody : '{' classBodyDeclaration* '}' ;
	 */
	@Override
	public SketchObject visitClassBody(simpleJavaParser.ClassBodyContext ctx) {
		for(int i = 0; i < ctx.classBodyDeclaration().size(); i++){
			if(ctx.classBodyDeclaration().get(i).classMemberDeclaration().methodDeclaration().methodHeader().getChild(1).getChild(0).getText().equals(targetFunc))
				return visit(ctx.classBodyDeclaration().get(i).classMemberDeclaration().methodDeclaration());
		}
		return null;
	}

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
		if (ctx.formalParameterList() != null)
			return new FcnHeader(ctx.Identifier().getText(), null, (ParametersList) visit(ctx.formalParameterList()));
		else
			return new FcnHeader(ctx.Identifier().getText(), null, new ArrayList<Parameter>());
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
	public SketchObject visitUarrayType(simpleJavaParser.UarrayTypeContext ctx) {
		return visit(ctx.unannArrayType());
	}

	/** unannPrimitiveType dims **/
	@Override
	public SketchObject visitUnannArrayTypePri(simpleJavaParser.UnannArrayTypePriContext ctx) {
		return new TypeArray((Type) visit(ctx.unannPrimitiveType()), null);
	}

	/** annotation* '[' ']' (annotation* '[' ']')* **/
	@Override
	public SketchObject visitDims(simpleJavaParser.DimsContext ctx) {
		// TODO 2dimArray
		return null;
	}

	/** formalParameters ',' lastFormalParameter **/
	@Override
	public SketchObject visitExpandParaList(simpleJavaParser.ExpandParaListContext ctx) {
		ParametersList list = (ParametersList) visit(ctx.formalParameters());
		list.add((Parameter) visit(ctx.lastFormalParameter()));
		return list;
	}

	/** lastFormalParameter **/
	@Override
	public SketchObject visitOnlyOnePara(simpleJavaParser.OnlyOneParaContext ctx) {
		ParametersList list = new ParametersList();
		list.add((Parameter) visit(ctx.lastFormalParameter()));
		return list;
	}

	@Override
	public SketchObject visitExpandLastPara(simpleJavaParser.ExpandLastParaContext ctx) {
		return visit(ctx.formalParameter());
	}

	/** formalParameter (',' formalParameter)* **/
	@Override
	public SketchObject visitFormalPara(simpleJavaParser.FormalParaContext ctx) {
		ParametersList list = new ParametersList();
		for (int i = 0; i < ctx.formalParameter().size(); i++) {
			list.add((Parameter) visit(ctx.formalParameter(i)));
		}
		return list;
	}

	/** variableModifier* unannType variableDeclaratorId **/
	@Override
	public SketchObject visitFormalParameter(simpleJavaParser.FormalParameterContext ctx) {
		// TODO dims?
		return new Parameter((Type) visit(ctx.unannType()), ctx.variableDeclaratorId().Identifier().getText(), 0,
				false);
	}

	// ----------body----------

	/** block | ';' **/
	@Override
	public SketchObject visitMethodBody(simpleJavaParser.MethodBodyContext ctx) {
		return visit(ctx.block());
	}

	/** '{' blockStatements? '}' **/
	@Override
	public SketchObject visitBlock(simpleJavaParser.BlockContext ctx) {
		List<Statement> list = new ArrayList<Statement>();
		for (int i = 0; i < ctx.blockStatements().blockStatement().size(); i++) {
			list.add((Statement) visit(ctx.blockStatements().blockStatement(i)));
		}
		return new StmtBlock(list);
	}

	/** localVariableDeclarationStatement **/
	@Override
	public Statement visitLocalVarDecl(simpleJavaParser.LocalVarDeclContext ctx) {
		Type t = (Type) visit(ctx.localVariableDeclarationStatement().localVariableDeclaration().unannType());
		ArrayList<Type> types = new java.util.ArrayList<Type>();
		ArrayList<String> names = new java.util.ArrayList<String>();
		ArrayList<Expression> inits = new java.util.ArrayList<Expression>();
		for (int i = 0; i < ctx.localVariableDeclarationStatement().localVariableDeclaration().variableDeclaratorList()
				.variableDeclarator().size(); i++) {
			types.add(t);
			// TODO dims
			names.add(ctx.localVariableDeclarationStatement().localVariableDeclaration().variableDeclaratorList()
					.variableDeclarator().get(i).variableDeclaratorId().Identifier().getText());
			// TODO check what if variableInitializer dosen't exist
			inits.add((Expression) visit(ctx.localVariableDeclarationStatement().localVariableDeclaration()
					.variableDeclaratorList().variableDeclarator().get(i).variableInitializer()));
		}

		return new StmtVarDecl(types, names, inits,ctx.start.getLine());
	}

	@Override
	public Statement visitLocalVariableDeclarationStatement(
			simpleJavaParser.LocalVariableDeclarationStatementContext ctx) {
		return (Statement) visit(ctx.localVariableDeclaration());
	}

	@Override
	public Statement visitLocalVariableDeclaration(simpleJavaParser.LocalVariableDeclarationContext ctx) {
		Type t = (Type) visit(ctx.unannType());
		ArrayList<Type> types = new java.util.ArrayList<Type>();
		ArrayList<String> names = new java.util.ArrayList<String>();
		ArrayList<Expression> inits = new java.util.ArrayList<Expression>();
		for (int i = 0; i < ctx.variableDeclaratorList().variableDeclarator().size(); i++) {
			types.add(t);
			// TODO dims
			names.add(ctx.variableDeclaratorList().variableDeclarator().get(i).variableDeclaratorId().Identifier()
					.getText());
			// TODO check what if variableInitializer dosen't exist
			inits.add(
					(Expression) visit(ctx.variableDeclaratorList().variableDeclarator().get(i).variableInitializer()));
		}

		return new StmtVarDecl(types, names, inits,ctx.start.getLine());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Expression visitVarInitArray(simpleJavaParser.VarInitArrayContext ctx) {
		@SuppressWarnings("rawtypes")
		List list = new ArrayList<Expression>();
		for (int i = 0; i < ctx.arrayInitializer().variableInitializerList().variableInitializer().size(); i++) {
			list.add(visit(ctx.arrayInitializer().variableInitializerList().variableInitializer(i)));
		}
		return new ExprArrayInit(list);
	}

	@Override
	public SketchObject visitSingleStatement(simpleJavaParser.SingleStatementContext ctx) {
		return visit(ctx.statement());
	}

	@Override
	public SketchObject visitStatement(simpleJavaParser.StatementContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public SketchObject visitStatementWithoutTrailingSubstatement(
			simpleJavaParser.StatementWithoutTrailingSubstatementContext ctx) {
		return visit(ctx.getChild(0));
	}

	/** 'do' statement 'while' '(' expression ')' ';' **/
	@Override
	public SketchObject visitDoStatement(simpleJavaParser.DoStatementContext ctx) {
		return new StmtDoWhile((Statement) visit(ctx.statement()), (Expression) visit(ctx.expression()), ctx.start.getLine());
	}

	/** 'return' expression? ';' **/
	@Override
	public SketchObject visitReturnStatement(simpleJavaParser.ReturnStatementContext ctx) {
		return new StmtReturn((Expression) visit(ctx.expression()));
	}

	/** statementExpression (',' statementExpression)* **/
	@Override
	public Statement visitStatementExpressionList(simpleJavaParser.StatementExpressionListContext ctx) {
		List<Statement> list = new ArrayList<Statement>();
		for (int i = 0; i < ctx.statementExpression().size(); i++) {
			list.add(new StmtExpr((Expression) visit(ctx.statementExpression(i)), ctx.start.getLine()));
		}
		return new StmtBlock(list);
	}

	@Override
	public Statement visitExpressionStatement(simpleJavaParser.ExpressionStatementContext ctx) {
		// TODO convert expression and statement
		if (visit(ctx.statementExpression()).getClass().equals(StmtAssign.class))
			return (Statement) visit(ctx.statementExpression());
		return new StmtExpr((Expression) visit(ctx.statementExpression()), ctx.start.getLine());
	}

	@Override
	public SketchObject visitStatementExpression(simpleJavaParser.StatementExpressionContext ctx) {
		return visit(ctx.getChild(0));
	}

	/** '++' unaryExpression **/
	@Override
	public Expression visitPreIncrementExpression(simpleJavaParser.PreIncrementExpressionContext ctx) {
		return new ExprUnary(4, (Expression) visit(ctx.unaryExpression()));
	}

	/** '--' unaryExpression **/
	@Override
	public Expression visitPreDecrementExpression(simpleJavaParser.PreDecrementExpressionContext ctx) {
		return new ExprUnary(6, (Expression) visit(ctx.unaryExpression()));
	}

	/** unaryExpression '++' **/
	@Override
	public Expression visitPostIncrementExpression(simpleJavaParser.PostIncrementExpressionContext ctx) {
		return new ExprUnary(5, (Expression) visit(ctx.postfixExpression()));
	}

	/** unaryExpression '--' **/
	@Override
	public Expression visitPostDecrementExpression(simpleJavaParser.PostDecrementExpressionContext ctx) {
		return new ExprUnary(7, (Expression) visit(ctx.postfixExpression()));
	}

	@Override
	public SketchObject visitPreOp(simpleJavaParser.PreOpContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public SketchObject visitNotPlusMinus(simpleJavaParser.NotPlusMinusContext ctx) {
		return visit(ctx.unaryExpressionNotPlusMinus());
	}

	@Override
	public SketchObject visitExpandNotPlusMinus(simpleJavaParser.ExpandNotPlusMinusContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public SketchObject visitExpandNotPlusMinusBNot(simpleJavaParser.ExpandNotPlusMinusBNotContext ctx) {
		return new ExprUnary(2, (Expression) visit(ctx.unaryExpression()));
	}

	@Override
	public SketchObject visitExpandNotPlusMinusNot(simpleJavaParser.ExpandNotPlusMinusNotContext ctx) {
		return new ExprUnary(1, (Expression) visit(ctx.unaryExpression()));
	}

	/**
	 * ( primary | expressionName ) (
	 * postIncrementExpression_lf_postfixExpression |
	 * postDecrementExpression_lf_postfixExpression )*
	 **/
	@Override
	public SketchObject visitPostfixExpression(simpleJavaParser.PostfixExpressionContext ctx) {
		Expression name = null;
		if (ctx.getChild(0).getClass().equals(simpleJavaParser.PrimaryContext.class))
			name = (Expression) visit(ctx.primary());
		if (ctx.getChild(0).getClass().equals(simpleJavaParser.ExpressionNameContext.class))
			name = (Expression) visit(ctx.expressionName());
		// TODO what if double ++
		if (ctx.postIncrementExpression_lf_postfixExpression().size() != 0)
			return new ExprUnary(5, name);
		if (ctx.postDecrementExpression_lf_postfixExpression().size() != 0)
			return new ExprUnary(7, name);
		return name;
	}

	@Override
	public SketchObject visitExpressionName(simpleJavaParser.ExpressionNameContext ctx) {
		if (ctx.getChild(0).getClass().equals(simpleJavaParser.AmbiguousNameContext.class)) {
			return new ExprField((Expression) visit(ctx.ambiguousName()), ctx.Identifier().getText());
		}
		return new ExprVar(ctx.Identifier().getText());
	}

	@Override
	public SketchObject visitAmbiguousName(simpleJavaParser.AmbiguousNameContext ctx) {
		if (ctx.getChild(0).getClass().equals(simpleJavaParser.AmbiguousNameContext.class)) {
			return new ExprField((Expression) visit(ctx.ambiguousName()), ctx.Identifier().getText());
		}
		return new ExprVar(ctx.Identifier().getText());
	}

	/** leftHandSide assignmentOperator expression **/
	@Override
	public SketchObject visitAssignment(simpleJavaParser.AssignmentContext ctx) {
		int op = 0;
		String aop = ctx.assignmentOperator().getText();
		if (aop.equals("*="))
			op = ExprBinary.BINOP_MUL;
		if (aop.equals("/="))
			op = ExprBinary.BINOP_DIV;
		if (aop.equals("+="))
			op = ExprBinary.BINOP_ADD;
		if (aop.equals("-="))
			op = ExprBinary.BINOP_SUB;
		return new StmtAssign((Expression) visit(ctx.leftHandSide()), (Expression) visit(ctx.expression()), op, ctx.start.getLine());
	}

	@Override
	public SketchObject visitLeftHandSide(simpleJavaParser.LeftHandSideContext ctx) {
		return visit(ctx.getChild(0));
	}

	/**
	 * ( expressionName '[' expression ']' | primaryNoNewArray_lfno_arrayAccess
	 * '[' expression ']' ) ( primaryNoNewArray_lf_arrayAccess '[' expression
	 * ']' )*
	 **/
	@Override
	public SketchObject visitArrayAccess(simpleJavaParser.ArrayAccessContext ctx) {
		// TODO bad style NOW
		RangeLen r = new RangeLen((Expression) visit(ctx.expression(0)));
		return new ExprArrayRange((Expression) visit(ctx.expressionName()), r);
	}

	@Override
	public SketchObject visitPrimary(simpleJavaParser.PrimaryContext ctx) {
		// TODO bad style

		return visit(ctx.getChild(0));
	}

	@Override
	public SketchObject visitPrimaryLiteral(simpleJavaParser.PrimaryLiteralContext ctx) {
		return visit(ctx.literal());
	}

	@Override
	public SketchObject visitPrimaryNoNewArray_lfno_primary(
			simpleJavaParser.PrimaryNoNewArray_lfno_primaryContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public SketchObject visitArrayAccess_lfno_primary(simpleJavaParser.ArrayAccess_lfno_primaryContext ctx) {
		RangeLen r = new RangeLen((Expression) visit(ctx.expression(0)));
		return new ExprArrayRange((Expression) visit(ctx.expressionName()), r);
	}

	@Override
	public SketchObject visitLiteralInt(simpleJavaParser.LiteralIntContext ctx) {
		return new ExprConstInt(ctx.IntegerLiteral().getText());
	}

	// ---------- control flow ----------

	/** 'for' '(' forInit? ';' expression? ';' forUpdate? ')' statement **/
	@Override
	public Statement visitForStatement(simpleJavaParser.ForStatementContext ctx) {
		simpleJavaParser.BasicForStatementContext c = ctx.basicForStatement();
		return new StmtFor((Statement) visit(c.forInit()), (Expression) visit(c.expression()),
				(Statement) visit(c.forUpdate()), (Statement) visit(c.statement()), false, ctx.start.getLine());
	}

	@Override
	public Statement visitForInit(simpleJavaParser.ForInitContext ctx) {
		return (Statement) visit(ctx.getChild(0));
	}

	/** 'while' '(' expression ')' statement **/
	@Override
	public Statement visitWhileStatement(simpleJavaParser.WhileStatementContext ctx) {
		return new StmtWhile((Expression) visit(ctx.expression()), (Statement) visit(ctx.statement()), ctx.start.getLine());
	}

	/** 'if' '(' expression ')' statementNoShortIf 'else' statement **/
	@Override
	public Statement visitIfThenElseStatement(simpleJavaParser.IfThenElseStatementContext ctx) {
		return new StmtIfThen((Expression) visit(ctx.expression()), (Statement) visit(ctx.statementNoShortIf()),
				(Statement) visit(ctx.statementNoShortIf()), ctx.start.getLine());
	}

	/** 'if' '(' expression ')' statement **/
	@Override
	public Statement visitIfThenStatement(simpleJavaParser.IfThenStatementContext ctx) {
		return new StmtIfThen((Expression) visit(ctx.expression()), (Statement) visit(ctx.statement()), null, ctx.start.getLine());
	}

	@Override
	public Statement visitStatementNoShortIf(simpleJavaParser.StatementNoShortIfContext ctx) {
		return (Statement) visit(ctx.getChild(0));
	}

	// ---------- expression ----------
	@Override
	public Expression visitExpression(simpleJavaParser.ExpressionContext ctx) {
		return (Expression) visit(ctx.assignmentExpression());
	}

	/** conditionalOrExpression '||' conditionalAndExpression **/
	@Override
	public Expression visitExpandConditionalOrExpr(simpleJavaParser.ExpandConditionalOrExprContext ctx) {
		return new ExprBinary(ExprBinary.BINOP_OR, (Expression) visit(ctx.conditionalOrExpression()),
				(Expression) visit(ctx.conditionalAndExpression()));
	}

	/** conditionalAndExpression '&&' inclusiveOrExpression **/
	@Override
	public Expression visitExpandConditionalAndExpr(simpleJavaParser.ExpandConditionalAndExprContext ctx) {
		return new ExprBinary(ExprBinary.BINOP_AND, (Expression) visit(ctx.conditionalAndExpression()),
				(Expression) visit(ctx.inclusiveOrExpression()));
	}

	/** inclusiveOrExpression '|' exclusiveOrExpression **/
	@Override
	public Expression visitExpandInclusiveOrExpr(simpleJavaParser.ExpandInclusiveOrExprContext ctx) {
		return new ExprBinary(ExprBinary.BINOP_BOR, (Expression) visit(ctx.inclusiveOrExpression()),
				(Expression) visit(ctx.exclusiveOrExpression()));
	}

	/** exclusiveOrExpression '^' andExpression **/
	@Override
	public Expression visitExpandExclusiveOrExpr(simpleJavaParser.ExpandExclusiveOrExprContext ctx) {
		return new ExprBinary(ExprBinary.BINOP_BXOR, (Expression) visit(ctx.exclusiveOrExpression()),
				(Expression) visit(ctx.andExpression()));
	}

	/** andExpression '&' equalityExpression **/
	@Override
	public Expression visitExpandAndExpr(simpleJavaParser.ExpandAndExprContext ctx) {
		return new ExprBinary(ExprBinary.BINOP_BAND, (Expression) visit(ctx.andExpression()),
				(Expression) visit(ctx.equalityExpression()));
	}

	/** relationalExpression '<' shiftExpression **/
	@Override
	public Expression visitExpandRelationalExpr(simpleJavaParser.ExpandRelationalExprContext ctx) {
		return new ExprBinary((Expression) visit(ctx.getChild(0)), ctx.getChild(1).getText(),
				(Expression) visit(ctx.getChild(2)));
	}

	@Override
	public Expression visitExpandShiftLeft(simpleJavaParser.ExpandShiftLeftContext ctx) {
		return new ExprBinary(ExprBinary.BINOP_LSHIFT, (Expression) visit(ctx.shiftExpression()),
				(Expression) visit(ctx.additiveExpression()));
	}

	@Override
	public Expression visitExpandShiftRight(simpleJavaParser.ExpandShiftRightContext ctx) {
		return new ExprBinary(ExprBinary.BINOP_RSHIFT, (Expression) visit(ctx.shiftExpression()),
				(Expression) visit(ctx.additiveExpression()));
	}

	@Override
	public Expression visitExpandAdditiveExpr(simpleJavaParser.ExpandAdditiveExprContext ctx) {
		return new ExprBinary((Expression) visit(ctx.getChild(0)), ctx.getChild(1).getText(),
				(Expression) visit(ctx.getChild(2)));
	}

	@Override
	public Expression visitExpandMulExpr(simpleJavaParser.ExpandMulExprContext ctx) {
		return new ExprBinary((Expression) visit(ctx.getChild(0)), ctx.getChild(1).getText(),
				(Expression) visit(ctx.getChild(2)));
	}

	// //TODO :
	//
	// TODO expression
	// | switchStatement

	// NOT SUPPORT YET
	// lambdaExpression
	// | labeledStatementNoShortIf
	// | ifThenElseStatementNoShortIf
	// | whileStatementNoShortIf
	// | forStatementNoShortIf
	// | conditionalExpression

	// forUpdate no need to write?
	// | breakStatement not support
	// | continueStatement not support
	// | methodInvocation unused
	// | classInstanceCreationExpression unused
}
