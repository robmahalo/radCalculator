package calc;

//this class forms the Model part of MVC. It is used for modeling the input
//from the user
public class StackCalculatorModel {

	private String expression;

	public StackCalculatorModel() {
		expression = "";
	}

	// returns the expression built so fat
	public String getExpression() {
		return expression;
	}

	// adds a digit to the expression
	public void addDigit(String digit) {
		if ("0123456789.".contains(digit)) {
			expression += digit;
		}
	}

	// adds an operator to the expression
	public void addOperator(String operator) {
		if ("+-/*".contains(operator)) {
			expression += " " + operator + " ";
		}
	}

	// clears the expression
	public void clearExpression() {
		expression = "";
	}

	// set the expression to the passed expression
	public void setExpression(String expression) {
		this.expression = expression;
	}
}
