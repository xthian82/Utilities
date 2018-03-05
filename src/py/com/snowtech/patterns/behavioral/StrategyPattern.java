package py.com.snowtech.patterns.behavioral;


/**
 * In Strategy pattern, a class behavior or its algorithm can be 
 * changed at run time. This type of design pattern comes under 
 * behavior pattern. In Strategy pattern, we create objects which 
 * represent various strategies and a context object whose behavior 
 * varies as per its strategy object. The strategy object changes 
 * the executing algorithm of the context object.
 * 
 * IMPLEMENTATION
 * ==============
 * We are going to create a Strategy interface defining an action 
 * and concrete strategy classes implementing the Strategy interface. 
 * Context is a class which uses a Strategy.
 * 
 * StrategyPattern, our demo class, will use Context and strategy objects 
 * to demonstrate change in Context behaviour based on strategy it deploys or uses.
 * 
 * @author cristhian
 *
 */

interface Strategy {
	int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 + num2;
	}
}

class OperationSubstract implements Strategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 - num2;
	}
}

class OperationMultiply implements Strategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}
}

class CContext {
	private Strategy strategy;

	public CContext(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}
}

public class StrategyPattern {
	public static void main(String[] args) {
		CContext context = new CContext(new OperationAdd());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new CContext(new OperationSubstract());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new CContext(new OperationMultiply());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}
}
