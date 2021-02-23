// Generated from DiscretePL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DiscretePLParser}.
 */
public interface DiscretePLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DiscretePLParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(DiscretePLParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link DiscretePLParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(DiscretePLParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolVar}
	 * labeled alternative in {@link DiscretePLParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterBoolVar(DiscretePLParser.BoolVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolVar}
	 * labeled alternative in {@link DiscretePLParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitBoolVar(DiscretePLParser.BoolVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntVar}
	 * labeled alternative in {@link DiscretePLParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterIntVar(DiscretePLParser.IntVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntVar}
	 * labeled alternative in {@link DiscretePLParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitIntVar(DiscretePLParser.IntVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntData}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void enterIntData(DiscretePLParser.IntDataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntData}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void exitIntData(DiscretePLParser.IntDataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolData}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void enterBoolData(DiscretePLParser.BoolDataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolData}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void exitBoolData(DiscretePLParser.BoolDataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolRead}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void enterBoolRead(DiscretePLParser.BoolReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolRead}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void exitBoolRead(DiscretePLParser.BoolReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntRead}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void enterIntRead(DiscretePLParser.IntReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntRead}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void exitIntRead(DiscretePLParser.IntReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleRead}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void enterDoubleRead(DiscretePLParser.DoubleReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleRead}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void exitDoubleRead(DiscretePLParser.DoubleReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolArray}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void enterBoolArray(DiscretePLParser.BoolArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolArray}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void exitBoolArray(DiscretePLParser.BoolArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntArray}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void enterIntArray(DiscretePLParser.IntArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntArray}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void exitIntArray(DiscretePLParser.IntArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleArray}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void enterDoubleArray(DiscretePLParser.DoubleArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleArray}
	 * labeled alternative in {@link DiscretePLParser#data}.
	 * @param ctx the parse tree
	 */
	void exitDoubleArray(DiscretePLParser.DoubleArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterLoop(DiscretePLParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitLoop(DiscretePLParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeterAssg}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeterAssg(DiscretePLParser.DeterAssgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeterAssg}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeterAssg(DiscretePLParser.DeterAssgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DiscreteAssg}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDiscreteAssg(DiscretePLParser.DiscreteAssgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DiscreteAssg}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDiscreteAssg(DiscretePLParser.DiscreteAssgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InferExpectation}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterInferExpectation(DiscretePLParser.InferExpectationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InferExpectation}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitInferExpectation(DiscretePLParser.InferExpectationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sequential}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterSequential(DiscretePLParser.SequentialContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sequential}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitSequential(DiscretePLParser.SequentialContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BernoulliAssg}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBernoulliAssg(DiscretePLParser.BernoulliAssgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BernoulliAssg}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBernoulliAssg(DiscretePLParser.BernoulliAssgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Observe}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterObserve(DiscretePLParser.ObserveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Observe}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitObserve(DiscretePLParser.ObserveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterSkip(DiscretePLParser.SkipContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitSkip(DiscretePLParser.SkipContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterConditional(DiscretePLParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitConditional(DiscretePLParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Forfold}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterForfold(DiscretePLParser.ForfoldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Forfold}
	 * labeled alternative in {@link DiscretePLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitForfold(DiscretePLParser.ForfoldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarOrData}
	 * labeled alternative in {@link DiscretePLParser#r}.
	 * @param ctx the parse tree
	 */
	void enterVarOrData(DiscretePLParser.VarOrDataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarOrData}
	 * labeled alternative in {@link DiscretePLParser#r}.
	 * @param ctx the parse tree
	 */
	void exitVarOrData(DiscretePLParser.VarOrDataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntNumber}
	 * labeled alternative in {@link DiscretePLParser#r}.
	 * @param ctx the parse tree
	 */
	void enterIntNumber(DiscretePLParser.IntNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntNumber}
	 * labeled alternative in {@link DiscretePLParser#r}.
	 * @param ctx the parse tree
	 */
	void exitIntNumber(DiscretePLParser.IntNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleNumber}
	 * labeled alternative in {@link DiscretePLParser#r}.
	 * @param ctx the parse tree
	 */
	void enterDoubleNumber(DiscretePLParser.DoubleNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleNumber}
	 * labeled alternative in {@link DiscretePLParser#r}.
	 * @param ctx the parse tree
	 */
	void exitDoubleNumber(DiscretePLParser.DoubleNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link DiscretePLParser#ebranch}.
	 * @param ctx the parse tree
	 */
	void enterEbranch(DiscretePLParser.EbranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link DiscretePLParser#ebranch}.
	 * @param ctx the parse tree
	 */
	void exitEbranch(DiscretePLParser.EbranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link DiscretePLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(DiscretePLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DiscretePLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(DiscretePLParser.ExprContext ctx);
}