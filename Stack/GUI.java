import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Beschreiben Sie hier die Klasse GUI.
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
        f = new JFrame();
        heading = new JLabel("Rechenterme");
        result = new JLabel();
        input = new JTextField();
        submit = new JButton("Berechnen");
        
        heading.setBounds(30,40,400,40);
        heading.setFont(new Font("Arial", Font.PLAIN, 50));
        f.add(heading);
        
        result.setBounds(30,240,200,40);
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
                result.setText(String.valueOf(Calculator.calculate(input.getText())));
                input.setText("");
            }
        });
        
        input.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent k){
                if(k.getKeyCode() == KeyEvent.VK_ENTER){
                    result.setText(String.valueOf(Calculator.calculate(input.getText())));
                    input.setText("");
                }
            }
        });
        
        f.setSize(800, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}
