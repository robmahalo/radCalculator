package testcases;
import calc.StackCalculatorModel;
import calc.StackCalculatorController;

public class TestCases {
	private static StackCalculatorModel model = new StackCalculatorModel();

	//Test: Test the result for an empty model
	public static void test1()
	{
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: Runtime Exception. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("Runtime Exception")));
		System.out.println();
	}

	//Test: Test the result for a model with just one digit
	public static void test2()
	{
		model.addDigit("3");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: 3.0. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("3.0")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result for a model with one number with decimal places
	public static void test3()
	{
		model.addDigit("3");
		model.addDigit(".");
		model.addDigit("4");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: 3.4. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("3.4")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result for a model with one number with decimal places and an operation
	public static void test4()
	{
		model.addDigit("3");
		model.addDigit(".");
		model.addDigit("4");
		model.addOperator("+");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: Runtime Exception. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("Runtime Exception")));
		System.out.println();
		model.clearExpression();
	}

	//Test:Test: Test the result for a model with one number, one operation and another number
	public static void test5()
	{
		model.addDigit("3");
		model.addOperator("*");
		model.addDigit("7");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: 21.0. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("21.0")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result for a model with one number, one operation and another number with decimal places
	public static void test6()
	{
		model.addDigit("3");
		model.addOperator("-");
		model.addDigit("7");
		model.addDigit(".");
		model.addDigit("4");
		model.addDigit("9");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: -4.49. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("-4.49")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result for a model with one number with decimal places, one operation and another number with decimal places
	public static void test7()
	{
		model.addDigit("3");
		model.addDigit(".");
		model.addDigit("1");
		model.addDigit("5");
		model.addOperator("/");
		model.addDigit("7");
		model.addDigit(".");
		model.addDigit("5");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: 0.42. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("0.42")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result for a model with a number starting with dot (decimal symbol),
	//one operation and another number with decimal places
	public static void test8()
	{
		model.addDigit(".");
		model.addDigit("1");
		model.addDigit("5");
		model.addOperator("/");
		model.addDigit("7");
		model.addDigit(".");
		model.addDigit("5");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: 0.02. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("0.02")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result for a model with a number starting with dot (decimal symbol),
	//one operation and another number starting with dot
	public static void test9()
	{
		model.addDigit(".");
		model.addDigit("1");
		model.addDigit("5");
		model.addOperator("/");
		model.addDigit(".");
		model.addDigit("1");
		model.addDigit("5");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: 1.0. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("1.0")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result for a model with more than 1 operation
	public static void test10()
	{
		model.addDigit("5");
		model.addOperator("*");
		model.addDigit(".");
		model.addDigit("1");
		model.addDigit("5");
		model.addOperator("+");
		model.addDigit("4");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: 4.75. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("4.75")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result for a model starting with an operation
	public static void test11()
	{
		model.addOperator("*");
		model.addDigit(".");
		model.addDigit("1");
		model.addDigit("5");
		model.addOperator("+");
		model.addDigit("4");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: Runtime Exception. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("Runtime Exception")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result for a model starting with a negative number
	public static void test12()
	{
		model.addOperator("-");
		model.addDigit("1");
		model.addOperator("+");
		model.addDigit("4");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: 3.0. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("3.0")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result like two dots on the same number
	public static void test13()
	{
		model.addDigit(".");
		model.addDigit(".");
		model.addDigit("3");
		model.addDigit("4");
		model.addOperator("+");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: Runtime Exception. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("Runtime Exception")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result with two operators
	public static void test14()
	{
		model.addDigit("3");
		model.addOperator("+");
		model.addOperator("+");
		model.addDigit("4");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: Runtime Exception. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("Runtime Exception")));
		System.out.println();
		model.clearExpression();
	}

	//Test: Test the result with no operator
	public static void test15()
	{
		model.addDigit("3");
		model.addDigit(".");
		model.addDigit("4");
		System.out.println("Expression: "+model.getExpression());
		System.out.print("Expected result: Runtime Exception. Actual result: ");
		String res = "";
		try {
			double val = StackCalculatorController.evaluate(model.getExpression());
			res = val + "";
		} catch (Exception e) {
			res = "Runtime Exception";
		}
		System.out.print(res+"\n");
		System.out.println("TEST PASSED: "+(res.equals("Runtime Exception")));
		System.out.println();
		model.clearExpression();
	}
	
	public static void main(String[] args)
	{
		//Method that runs all tests
		System.out.println("---- RUNNING ALL TESTS ----\n");
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
		test11();
		test12(); 
		test13();
		test14();
		test15();
	}

}
