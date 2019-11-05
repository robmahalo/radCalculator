package calc;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Class that represents the Viewer for the MVC program
//This class holds the main frame and listen to the buttons as well
public class StackCalculatorView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Private fields-instances of the class
	private JButton[] buttons; //Array of buttons for all possible inputs for user
	private JTextField text; //Text field that shows the expression of the user
	private StackCalculatorModel model; //Model that will handle the expression
	private boolean equalClicked; //Boolean that helps us now if the equal button was clicked

	public StackCalculatorView()
	{
		//First, we set the main parameters for the frame
		setTitle("Stack Calculator");
		setSize(300,300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//The view can be represented by the the text field in the north and a panel with all buttons
		//in the center of the frame. Then, we need a subpanel for the buttons
		//To set the text field, we initialize it and make it not editable for the user
		text = new JTextField();
		Font f = new Font("Arial", Font.BOLD, 30); //Font for the text field
		text.setFont(f);
		text.setEditable(false);
		add(text,BorderLayout.NORTH);

		//Now, for the buttons, we use a subpanel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 5));
		buttons = new JButton[20];
		//As we actually have a grid of buttons, we can handle them by using an array an adding them to
		//the panel from left to right, from north to south. That's how the panel will store them on
		//a grid layout. So, our array will store all 20 buttons and we need to remember the order of them
		buttons[0] = new JButton("1");
		buttons[1] = new JButton("2");
		buttons[2] = new JButton("3");
		buttons[3] = new JButton("+");
		buttons[4] = new JButton("CE");
		buttons[5] = new JButton("4");
		buttons[6] = new JButton("5");
		buttons[7] = new JButton("6");
		buttons[8] = new JButton("-");
		buttons[9] = new JButton("");
		buttons[9].setEnabled(false);
		buttons[10] = new JButton("7");
		buttons[11] = new JButton("8");
		buttons[12] = new JButton("9");
		buttons[13] = new JButton("*");
		buttons[14] = new JButton("");
		buttons[14].setEnabled(false);
		buttons[15] = new JButton("0");
		buttons[16] = new JButton(".");
		buttons[17] = new JButton("");
		buttons[17].setEnabled(false);
		buttons[18] = new JButton("/");
		buttons[19] = new JButton("=");
		//Then, a loop to add the action listener for all, set the action command to know which button
		//was clicked and add them to the panel
		for(int i = 0; i < buttons.length; i++)
		{
			buttons[i].addActionListener(this);
			buttons[i].setActionCommand((i+1)+""); //We can use index+1 as the action command (1-20)
			panel.add(buttons[i]);
		}
		//Then, we add the panel to the center of the frame
		add(panel,BorderLayout.CENTER);

		//Finally, we set the frame visible, we initialize the model instance and we set equalClicked as false
		model = new StackCalculatorModel();
		equalClicked = false;
		setVisible(true);

	}

	//Method that will run when the buttons are clicked
	//Depending on the button pressed, we do the respective operation 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//We get first the command from the event
		String command = e.getActionCommand();
		//Now, we check for the button that was clicked
		//If the button pressed is the equal button, we show the final results by calling the controller
		//static method
		if(command.equals("20"))
		{
			//First, is equalClicked is already true, we just do nothing. So, we so something if it's false
			if(!equalClicked)
			{
				//Here, if any exception occurs, we show "Invalid Expression" and also clear the model expression
				try
				{
					String expression = model.getExpression();
					double result = StackCalculatorController.evaluate(expression);
					text.setText(result+"");
					model.clearExpression(); //Clear the expression for the next calculation
				} catch (Exception exc)
				{
					model.clearExpression();
					text.setText("Invalid Expression");
				}
				equalClicked = true; //We make this true, because, on the next button, the text field will reset
			}

		}
		//If the button is the clear, we clear the text and we set equalClicked to false again
		else if(command.equals("5"))
		{
			text.setText("");
			model.clearExpression();
			equalClicked = false;
		}
		//Else, one of the buttons with the operations, the digits or the dot was clicked, so we just
		//add it to the expression, the text they have
		else
		{
			//First, we convert the command into an integer
			int i = Integer.parseInt(command) - 1; //We subtract 1 because the commands are 1-20, and the indices 0-19
			//If is an operation, we add it as an operation
			if(command.equals("4") || command.equals("9") || command.equals("14") || command.equals("19"))
				model.addOperator(buttons[i].getText());
			//Else, we add it as a digit
			else
				model.addDigit(buttons[i].getText());

			//Then, we show it on the text field
			//If equalClicked is true, we just reset the text field and make equalClicked false again
			//This means we don't consider the previous text, which is the previous result
			if(equalClicked) {
				text.setText(buttons[i].getText());
				equalClicked = false;
			}
			//If not, we add it to the previous text
			else
			{
				String s = text.getText();
				s += buttons[i].getText();
				text.setText(s);
			}
		}
		//There's no need to consider the empty buttons because they're not enabled and they actually do nothing
	}

	//Main method to launch the main frame, View class
	public static void main(String[] args)
	{
		new StackCalculatorView();
	}

}
