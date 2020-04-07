import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame{
    JButton add , subtract , multiply , divide;
    JTextField num1 , num2;
    JLabel result , enter1 , enter2;
public Calculator() {

    setLayout(new GridBagLayout());
    GridBagConstraints gc = new GridBagConstraints();

    enter1 = new JLabel("1st :");
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.gridx = 0;
    gc.gridy = 0;
    add(enter1 , gc);

    num1 = new JTextField(10);
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.gridx = 1;
    gc.gridy = 0;
    add(num1 , gc);

    enter2 = new JLabel("2nd :");
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.gridx =0;
    gc.gridy = 1;
    add(enter2 , gc);

    num2 = new JTextField(10);
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.gridx = 1 ;
    gc.gridy =  1 ;
    add(num2 , gc);

    add = new JButton("+");
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.gridx = 0;
    gc.gridy = 2;
    add(add , gc);

    subtract = new JButton("-");
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.gridx = 1;
    gc.gridy = 2;
    add(subtract , gc);

    multiply = new JButton("*");
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.gridx = 2;
    gc.gridy = 2;
    add(multiply , gc);

    divide = new JButton("/");
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.gridx = 3;
    gc.gridy = 2;
    add(divide , gc);

    result = new JLabel("");
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.gridx = 1;
    gc.gridy = 3;
    add(result , gc);


    event e = new event();
    add.addActionListener(e);
    subtract.addActionListener(e);
    multiply.addActionListener(e);
    divide.addActionListener(e);

   }
   public  class event implements ActionListener{
    public  void actionPerformed(ActionEvent e){
        double number1 , number2;

        try{
            number1 = Double.parseDouble(num1.getText());

        }catch (NumberFormatException ex){

            result.setText("Illegal data 1st field");
            result.setForeground(Color.RED);
            return;
        }
        try{
            number2 = Double.parseDouble(num2.getText());

        }catch (NumberFormatException ex){

            result.setText("Illegal data 2nd field");
            result.setForeground(Color.RED);
            return;
        }

        String op = e.getActionCommand();

        if (op.equals("+")){
            double sum = number1 + number2;
            result.setText(number1 + "+" + number2 + "=" + sum);
            result.setForeground(Color.blue);
        }else if (op.equals("-")){
            double diff = number1 - number2;
            result.setText(number1 + "-" + number2 + "=" + diff);
            result.setForeground(Color.blue);
        }else if (op.equals("*")){
            double pro = number1 * number2;
            result.setText(number1 + "*"+number2 +"="+pro);
            result.setForeground(Color.blue);
        }else if (op.equals("/")){
            double quo = number1 / number2;
            if (number2 == 0){
                result.setText("Cant divide by zero");
                result.setForeground(Color.red);
            }else {
                result.setText(number1 + "/" + number2 + "=" + quo);
                result.setForeground(Color.blue);
            }
        }
    }
}
    public static void main(String[] args) {
    Calculator c = new Calculator();

    c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    c.setVisible(true);
    c.setTitle("Calculator");
    c.setSize(250 , 250);
    c.setLocation(500 , 250);
    }
}
