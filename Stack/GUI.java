import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
* Gryphical User Interface (GUI) of the Calculator
* 
* @author (Ihr Name) 
* @version (eine Versionsnummer oder ein Datum)
*/
public class GUI
{
    private JFrame f;
    private JLabel heading;
    private JLabel result;
    private JTextField input;
    private JButton submit;
    
    public GUI() {
        f = new JFrame("Rechenterme berechnen by Karsten Römling");
        heading = new JLabel("Rechenterme");
        result = new JLabel();
        input = new JTextField();
        submit = new JButton("Berechnen");
        
        heading.setBounds(30,40,400,40);
        heading.setFont(new Font("Arial", Font.PLAIN, 50));
        f.add(heading);
        
        result.setBounds(30,240,400,40);
        result.setFont(new Font("Arial", Font.PLAIN, 30));
        f.add(result);
        
        input.setBounds(30,140,300,40);
        input.setFont(new Font("Arial", Font.PLAIN, 30));
        f.add(input);
        
        submit.setBounds(360,140,300,40);
        submit.setFont(new Font("Arial", Font.PLAIN, 30));
        f.add(submit);
        
        submit.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                doCalculation();
            }
        });
        
        input.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent k){
                if(k.getKeyCode() == KeyEvent.VK_ENTER){
                    doCalculation();
                }
            }
        });
        
        f.setSize(800, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    /**
     * Calculates term and displays result of the calculation (or "SYNTAX ERROR", if there is an error)
     */
    public void doCalculation() {
        String term = input.getText().length() > 0 ? input.getText() : "0";
        String calculationResult;
        try {
            calculationResult = String.valueOf(Calculator.calculate(term));
            if(calculationResult.substring(calculationResult.length() - 2, calculationResult.length()).equals(".0")) {
                calculationResult = calculationResult.substring(0, calculationResult.length() - 2);
            }
        } catch (Exception e) {
            calculationResult = "SYNTAX ERROR!";
        }
        result.setText(calculationResult);
        input.setText("");
    }
    
}
