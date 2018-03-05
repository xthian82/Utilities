package py.com.snowtech.patterns.behavioral;

/**
 * Interpreter pattern provides a way to evaluate language 
 * grammar or expression. This type of pattern comes under behavioral pattern.
 * 
 * This pattern involves implementing an expression interface which tells 
 * to interpret a particular context. This pattern is used in SQL parsing, 
 * symbol processing engine etc.
 * 
 * IMPLEMENTATION
 * ==============
 * 
 * We are going to create an interface Expression and concrete classes implementing 
 * the Expression interface. A class TerminalExpression is defined which acts as a 
 * main interpreter of context in question. Other classes OrExpression, AndExpression 
 * are used to create combinational expressions.
 * 
 * Interpreter, our demo class, will use Expression class to create rules and 
 * demonstrate parsing of expressions.
 * 
 * @author cristhian
 *
 */
interface Expression {
	boolean interpret(String context);
}

class TerminalExpression implements Expression {
	private String data;

	public TerminalExpression(String data) {
		this.data = data;
	}

	@Override
	public boolean interpret(String context) {

		if (context.contains(data)) {
			return true;
		}
		return false;
	}
}

class OrExpression implements Expression {
	private Expression expr1;
	private Expression expr2;

	public OrExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean interpret(String context) {
		return expr1.interpret(context) || expr2.interpret(context);
	}
}

class AndExpression implements Expression {
	private Expression expr1;
	private Expression expr2;

	public AndExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean interpret(String context) {
		return expr1.interpret(context) && expr2.interpret(context);
	}
}

public class Interpreter {
	// Rule: Robert and John are male
	public static Expression getMaleExpression() {
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}

	// Rule: Julie is a married women
	public static Expression getMarriedWomanExpression() {
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie, married);
	}
	
	public static void main(String[] args) {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();

		System.out.println("John is male? " + isMale.interpret("John"));
		System.out.println("Julie is a married women? "
				+ isMarriedWoman.interpret("Married Julie"));
	}
}
