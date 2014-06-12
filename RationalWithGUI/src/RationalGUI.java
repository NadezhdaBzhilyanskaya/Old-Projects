import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class RationalGUI extends JFrame implements  ActionListener  {
	JLabel title;                                                  //Parts of The GUI
    JLabel subtitle1;
    JLabel subtitle2;
    JTextField input1N;
    JTextField input2N;                                   
    JLabel answerLabel;
    JTextField answerFeild;
    JButton divideButton;
    JButton multipleButton;
    JLabel errorFeild;
    JButton subtractButton;
    JButton addButton;
    JLabel diviser1;
    JLabel diviser2;
    JTextField input1D;
    JTextField input2D;

    public RationalGUI() {
        RationalGUILayout customLayout = new RationalGUILayout();

        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);

        title = new JLabel("Rational Calculator");
        add(title);

        subtitle1 = new JLabel("Rational 1:");
        add(subtitle1);

        subtitle2 = new JLabel("Rational 2:");
        add(subtitle2);
        
        answerLabel = new JLabel("Answer:");
        add(answerLabel);

        input1N = new JTextField("");
        add(input1N);

        input2N = new JTextField("");
        add(input2N);

        
        answerFeild = new JTextField("");
        answerFeild.setEditable(false);
        answerFeild.setBackground(Color.white);
        getContentPane().add(answerFeild);

        divideButton = new JButton("/");
        divideButton.addActionListener(this);
        add(divideButton);

        multipleButton = new JButton("*");
        multipleButton.addActionListener(this);
        add(multipleButton);

        errorFeild = new JLabel("");
        errorFeild.setForeground(Color.RED);
        add(errorFeild);

        subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        add(subtractButton);

        addButton = new JButton("+");
        addButton.addActionListener(this);
        add(addButton);

        diviser1 = new JLabel("    /");
        add(diviser1);

        diviser2 = new JLabel("    /");
        add(diviser2);

        input1D = new JTextField("");
        add(input1D);

        input2D = new JTextField("");
        add(input2D);


        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static boolean isNumber(String s)
	{
		for(int x = 0; x < s.length(); x++)
		{	
			int charnum = (int)(s.charAt(x));
			if(x==0 && charnum==45){}
			else if(charnum < 48 || charnum > 57){return false;}
		}
		return true;
	}
    
    public static boolean isTooBig(String s)
   	{
    	if(s.startsWith("-")&&s.length()>10){return true;}
        else if(s.length()>9){return true;}
   		return false;
   	}
    

    public static void main(String args[]) {
        RationalGUI window = new RationalGUI();        
        window.setTitle("Rational Calculator");
        window.pack();
        window.show();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String n1=input1N.getText().trim();                               //Turns input into usable Strings
		String n2=input2N.getText().trim();
		String d1=input1D.getText().trim();
		String d2=input2D.getText().trim();
		
		if(n1.equals("")||d1.equals("")||n2.equals("")||d2.equals(""))         //Checks if all fields have been used 
		{
			errorFeild.setText("Missing information, please complete");
		}
		else if(!(isNumber(n1) && isNumber(d1) && isNumber(n2) && isNumber(d2)))  //Checks if all inputs are numbers
		{
			errorFeild.setText("All inputs must be integers");	
		}
		else if(d1.equals("0")||d2.equals("0"))                         //Makes sure denominator is not 0
		{
			errorFeild.setText("Denominator can not be 0");
		}
		else if(isTooBig(n1) || isTooBig(d1) || isTooBig(n2) || isTooBig(d2))        //checks to make sure numbers are small enough to be processed
		{
			errorFeild.setText("All numbers must be less than 1000000000");
		}
		else
		{
			errorFeild.setText("");
			Rational r1 = new Rational(n1,d1);
			Rational r2 = new Rational(n2,d2);
			Rational rAnswer=null;
			if (e.getSource() == divideButton){rAnswer = r1.divide(r2);}
			else if (e.getSource() == multipleButton){rAnswer = r1.multiply(r2);}                   //Performs operations
			else if (e.getSource() == subtractButton){rAnswer = r1.subtract(r2);}
			else if (e.getSource() == addButton){rAnswer = r1.add(r2);}
			
			answerFeild.setText(rAnswer.toString());                                          //prints answer
			
		}
		
		
	}
}

