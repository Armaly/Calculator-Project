//Armaly Albert
///4/8/14
  
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.event.*;

public class Calculator extends JFrame
{
private JButton add,subtract,mult,divide,copyToF1,copyToF2,quit;
private JTextField f1,f2;
private JLabel answer;
private JLabel error;//creates specified variables
public Calculator()
{
  super("Armaly's Calculator");//names it
setBounds(300,400,500,150);
setBackground(Color.ORANGE);
JLabel y =new JLabel("F1:");
JLabel z =new JLabel("F2:");
f1=new JTextField(8);
f2=new JTextField(8);//creates tet field of 8 character

JPanel base = new JPanel();//creates base panel
base.add(y);
base.add(f1,BorderLayout.NORTH);
base.add(z);
base.add(f2,BorderLayout.SOUTH);//adds labels and textfields to base

add=new JButton("+");
subtract= new JButton("-");
mult=new JButton("*");
divide=new JButton("/");
copyToF1=new JButton("Copy F1");
copyToF2=new JButton("Copy F2");
quit=new JButton("Quit");//sets visible button characters
base.add(add,BorderLayout.EAST);
base.add(subtract,BorderLayout.EAST);
base.add(mult,BorderLayout.EAST);
base.add(divide,BorderLayout.EAST);
base.add(copyToF1,BorderLayout.EAST);
base.add(copyToF2,BorderLayout.EAST);
base.setBackground(Color.ORANGE);
base.add(quit,BorderLayout.WEST);//places buttons
base.setBounds(300,400,500,150);//sets base bounds
answer = new JLabel("0");//sets the equals label, basically the 0 you see when you start a calculator
error=new JLabel();//sets error message
base.add(error,BorderLayout.WEST);//places empty error message on frame
base.add(answer);//places answer
add(base);//base is added to frame
setVisible(true);//sets visibility
add.addActionListener(new ButtonHandler());
subtract.addActionListener(new ButtonHandler());
mult.addActionListener(new ButtonHandler());
divide.addActionListener(new ButtonHandler());
copyToF1.addActionListener(new ButtonHandler());
copyToF2.addActionListener(new ButtonHandler());
quit.addActionListener(new QuitHandler());//sets handler

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
private class QuitHandler implements ActionListener
{
  public void actionPerformed(ActionEvent e)//separate quit handler had to be created due to multiple errors(program would count every button as quit for some reason
  {
    if(e.getSource()==quit);
  {
    System.exit(0);
  }
  }
}
private class ButtonHandler implements ActionListener
{
public void actionPerformed(ActionEvent e)
    {
  try
  {
  String number1=(String)f1.getText();
  String number2=(String)f2.getText();//sets the text fields to strings
  int numb1=Integer.parseInt(number1);
  int numb2=Integer.parseInt(number2);//parses strings and throws error to catch if there is one 
 int sum=Integer.parseInt(answer.getText());//parses sum just in case user wants to copy to f1 or f2
  
  StringBuilder temporary;
 
  if(e.getSource()==add)
  {
    sum=numb1+numb2;//adds
  }
  else if(e.getSource()==subtract)
  {
    sum=numb1-numb2;//subtracts
  }
  else if(e.getSource()==mult)
  {
    sum=numb1*numb2;//multiplies
  }
  else if(e.getSource()==divide)
  {
    sum=numb1/numb2;//divides
  }

  if(e.getSource()==copyToF1)
  {
  f1.setText(sum+"");//copies sum to the f1 text field
  }
  if(e.getSource()==copyToF2)
  {
  f2.setText(sum+"");//copies sum to the f2 text field
  }
  answer.setText(sum+"");//sets answer label to sum 
  }
  catch(IllegalArgumentException g)//catch block
  {
  String t="Error! "+g.getMessage();//if there is an error, sets t to error+ the message
 error.setText(t);//sets error message to label
  add(error,BorderLayout.SOUTH);//label is added to frame and displayed ot user
  
  }
}
}
public static void main (String[] args)
{
Calculator a = new Calculator();//creates calculator object and sets visibility to true
a.setVisible(true);
}
}
  