// Generated from simpleJava.g4 by ANTLR 4.5.3
package javaparser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link simpleJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface simpleJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(simpleJavaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(simpleJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(simpleJavaParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericIntegeralType}
	 * labeled alternative in {@link simpleJavaParser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericIntegeralType(simpleJavaParser.NumericIntegeralTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericFloatingPointType}
	 * labeled alternative in {@link simpleJavaParser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericFloatingPointType(simpleJavaParser.NumericFloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#integralType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegralType(simpleJavaParser.IntegralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#floatingPointType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointType(simpleJavaParser.FloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(simpleJavaParser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(simpleJavaParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(simpleJavaParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType_lf_classOrInterfaceType(simpleJavaParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType_lfno_classOrInterfaceType(simpleJavaParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(simpleJavaParser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType_lf_classOrInterfaceType(simpleJavaParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType_lfno_classOrInterfaceType(simpleJavaParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(simpleJavaParser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(simpleJavaParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(simpleJavaParser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(simpleJavaParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(simpleJavaParser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(simpleJavaParser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#additionalBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalBound(simpleJavaParser.AdditionalBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(simpleJavaParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(simpleJavaParser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(simpleJavaParser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(simpleJavaParser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#wildcardBounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardBounds(simpleJavaParser.WildcardBoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(simpleJavaParser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(simpleJavaParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageOrTypeName(simpleJavaParser.PackageOrTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#expressionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionName(simpleJavaParser.ExpressionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(simpleJavaParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#ambiguousName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmbiguousName(simpleJavaParser.AmbiguousNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(simpleJavaParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(simpleJavaParser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#packageModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageModifier(simpleJavaParser.PackageModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(simpleJavaParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeImportDeclaration(simpleJavaParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeImportOnDemandDeclaration(simpleJavaParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStaticImportDeclaration(simpleJavaParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticImportOnDemandDeclaration(simpleJavaParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(simpleJavaParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(simpleJavaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalClassDeclaration(simpleJavaParser.NormalClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(simpleJavaParser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(simpleJavaParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(simpleJavaParser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#superclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclass(simpleJavaParser.SuperclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#superinterfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperinterfaces(simpleJavaParser.SuperinterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeList(simpleJavaParser.InterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(simpleJavaParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(simpleJavaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration(simpleJavaParser.ClassMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(simpleJavaParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier(simpleJavaParser.FieldModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(simpleJavaParser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(simpleJavaParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(simpleJavaParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(simpleJavaParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unannTypePri}
	 * labeled alternative in {@link simpleJavaParser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypePri(simpleJavaParser.UnannTypePriContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unannTypeRef}
	 * labeled alternative in {@link simpleJavaParser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypeRef(simpleJavaParser.UnannTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numType}
	 * labeled alternative in {@link simpleJavaParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumType(simpleJavaParser.NumTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link simpleJavaParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(simpleJavaParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classType_unused}
	 * labeled alternative in {@link simpleJavaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType_unused(simpleJavaParser.ClassType_unusedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeVar_unused}
	 * labeled alternative in {@link simpleJavaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVar_unused(simpleJavaParser.TypeVar_unusedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uarrayType}
	 * labeled alternative in {@link simpleJavaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUarrayType(simpleJavaParser.UarrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassOrInterfaceType(simpleJavaParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#unannClassType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType(simpleJavaParser.UnannClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType_lf_unannClassOrInterfaceType(simpleJavaParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType_lfno_unannClassOrInterfaceType(simpleJavaParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType(simpleJavaParser.UnannInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType_lf_unannClassOrInterfaceType(simpleJavaParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType_lfno_unannClassOrInterfaceType(simpleJavaParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypeVariable(simpleJavaParser.UnannTypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unannArrayTypePri}
	 * labeled alternative in {@link simpleJavaParser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannArrayTypePri(simpleJavaParser.UnannArrayTypePriContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expandClassType_unused}
	 * labeled alternative in {@link simpleJavaParser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpandClassType_unused(simpleJavaParser.ExpandClassType_unusedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expandtypeVar_unused}
	 * labeled alternative in {@link simpleJavaParser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpandtypeVar_unused(simpleJavaParser.ExpandtypeVar_unusedContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(simpleJavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodModifier(simpleJavaParser.MethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expandHeader}
	 * labeled alternative in {@link simpleJavaParser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpandHeader(simpleJavaParser.ExpandHeaderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expandHeader_unused}
	 * labeled alternative in {@link simpleJavaParser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpandHeader_unused(simpleJavaParser.ExpandHeader_unusedContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(simpleJavaParser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(simpleJavaParser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expandParaList}
	 * labeled alternative in {@link simpleJavaParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpandParaList(simpleJavaParser.ExpandParaListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onlyOnePara}
	 * labeled alternative in {@link simpleJavaParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnlyOnePara(simpleJavaParser.OnlyOneParaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formalPara}
	 * labeled alternative in {@link simpleJavaParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalPara(simpleJavaParser.FormalParaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formalPara_unused}
	 * labeled alternative in {@link simpleJavaParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalPara_unused(simpleJavaParser.FormalPara_unusedContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(simpleJavaParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(simpleJavaParser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expandLastPara_unused}
	 * labeled alternative in {@link simpleJavaParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpandLastPara_unused(simpleJavaParser.ExpandLastPara_unusedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expandLastPara}
	 * labeled alternative in {@link simpleJavaParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpandLastPara(simpleJavaParser.ExpandLastParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#receiverParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverParameter(simpleJavaParser.ReceiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#throws_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrows_(simpleJavaParser.Throws_Context ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionTypeList(simpleJavaParser.ExceptionTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#exceptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionType(simpleJavaParser.ExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(simpleJavaParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#instanceInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceInitializer(simpleJavaParser.InstanceInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#staticInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticInitializer(simpleJavaParser.StaticInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(simpleJavaParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#constructorModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorModifier(simpleJavaParser.ConstructorModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclarator(simpleJavaParser.ConstructorDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#simpleTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeName(simpleJavaParser.SimpleTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(simpleJavaParser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitConstructorInvocation(simpleJavaParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(simpleJavaParser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(simpleJavaParser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#enumConstantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantList(simpleJavaParser.EnumConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(simpleJavaParser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantModifier(simpleJavaParser.EnumConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(simpleJavaParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(simpleJavaParser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalInterfaceDeclaration(simpleJavaParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(simpleJavaParser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendsInterfaces(simpleJavaParser.ExtendsInterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(simpleJavaParser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(simpleJavaParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(simpleJavaParser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#constantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantModifier(simpleJavaParser.ConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(simpleJavaParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodModifier(simpleJavaParser.InterfaceMethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeDeclaration(simpleJavaParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeBody(simpleJavaParser.AnnotationTypeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeMemberDeclaration(simpleJavaParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementDeclaration(simpleJavaParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementModifier(simpleJavaParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(simpleJavaParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(simpleJavaParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#normalAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalAnnotation(simpleJavaParser.NormalAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#elementValuePairList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairList(simpleJavaParser.ElementValuePairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(simpleJavaParser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(simpleJavaParser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(simpleJavaParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#elementValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueList(simpleJavaParser.ElementValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#markerAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkerAnnotation(simpleJavaParser.MarkerAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleElementAnnotation(simpleJavaParser.SingleElementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(simpleJavaParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#variableInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializerList(simpleJavaParser.VariableInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(simpleJavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#blockStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatements(simpleJavaParser.BlockStatementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code localVarDecl}
	 * labeled alternative in {@link simpleJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDecl(simpleJavaParser.LocalVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDecl}
	 * labeled alternative in {@link simpleJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(simpleJavaParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleStatement}
	 * labeled alternative in {@link simpleJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStatement(simpleJavaParser.SingleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(simpleJavaParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(simpleJavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withoutTrailingSubstatement}
	 * labeled alternative in {@link simpleJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithoutTrailingSubstatement(simpleJavaParser.WithoutTrailingSubstatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code labledStat}
	 * labeled alternative in {@link simpleJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabledStat(simpleJavaParser.LabledStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementIfThen}
	 * labeled alternative in {@link simpleJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIfThen(simpleJavaParser.StatementIfThenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementIfThenIfThenElse}
	 * labeled alternative in {@link simpleJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIfThenIfThenElse(simpleJavaParser.StatementIfThenIfThenElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementIfThenWhile}
	 * labeled alternative in {@link simpleJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIfThenWhile(simpleJavaParser.StatementIfThenWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementFor}
	 * labeled alternative in {@link simpleJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementFor(simpleJavaParser.StatementForContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNoShortIf(simpleJavaParser.StatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement(simpleJavaParser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(simpleJavaParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(simpleJavaParser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatementNoShortIf(simpleJavaParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(simpleJavaParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(simpleJavaParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#ifThenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenStatement(simpleJavaParser.IfThenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatement(simpleJavaParser.IfThenElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatementNoShortIf(simpleJavaParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(simpleJavaParser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(simpleJavaParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlock(simpleJavaParser.SwitchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(simpleJavaParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#switchLabels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabels(simpleJavaParser.SwitchLabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(simpleJavaParser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#enumConstantName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantName(simpleJavaParser.EnumConstantNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(simpleJavaParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementNoShortIf(simpleJavaParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(simpleJavaParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(simpleJavaParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementNoShortIf(simpleJavaParser.ForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#basicForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatement(simpleJavaParser.BasicForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatementNoShortIf(simpleJavaParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(simpleJavaParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(simpleJavaParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#statementExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionList(simpleJavaParser.StatementExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatement(simpleJavaParser.EnhancedForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatementNoShortIf(simpleJavaParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(simpleJavaParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(simpleJavaParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(simpleJavaParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(simpleJavaParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynchronizedStatement(simpleJavaParser.SynchronizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(simpleJavaParser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#catches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatches(simpleJavaParser.CatchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(simpleJavaParser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchFormalParameter(simpleJavaParser.CatchFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(simpleJavaParser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#finally_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinally_(simpleJavaParser.Finally_Context ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryWithResourcesStatement(simpleJavaParser.TryWithResourcesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(simpleJavaParser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#resourceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceList(simpleJavaParser.ResourceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(simpleJavaParser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(simpleJavaParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray(simpleJavaParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_arrayAccess(simpleJavaParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess(simpleJavaParser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary(simpleJavaParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(simpleJavaParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(simpleJavaParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary(simpleJavaParser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(simpleJavaParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(simpleJavaParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression(simpleJavaParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression_lf_primary(simpleJavaParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression_lfno_primary(simpleJavaParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(simpleJavaParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(simpleJavaParser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess_lf_primary(simpleJavaParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess_lfno_primary(simpleJavaParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(simpleJavaParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess_lf_primary(simpleJavaParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess_lfno_primary(simpleJavaParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(simpleJavaParser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lf_primary(simpleJavaParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lfno_primary(simpleJavaParser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(simpleJavaParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference(simpleJavaParser.MethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference_lf_primary(simpleJavaParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference_lfno_primary(simpleJavaParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpression(simpleJavaParser.ArrayCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#dimExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExprs(simpleJavaParser.DimExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#dimExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExpr(simpleJavaParser.DimExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(simpleJavaParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(simpleJavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(simpleJavaParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(simpleJavaParser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInferredFormalParameterList(simpleJavaParser.InferredFormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(simpleJavaParser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(simpleJavaParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(simpleJavaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(simpleJavaParser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(simpleJavaParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(simpleJavaParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(simpleJavaParser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(simpleJavaParser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression(simpleJavaParser.InclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression(simpleJavaParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(simpleJavaParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(simpleJavaParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(simpleJavaParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(simpleJavaParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(simpleJavaParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(simpleJavaParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(simpleJavaParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(simpleJavaParser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementExpression(simpleJavaParser.PreDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus(simpleJavaParser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(simpleJavaParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(simpleJavaParser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression_lf_postfixExpression(simpleJavaParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression(simpleJavaParser.PostDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression_lf_postfixExpression(simpleJavaParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleJavaParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(simpleJavaParser.CastExpressionContext ctx);
}