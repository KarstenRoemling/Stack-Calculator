import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Beschreiben Sie hier die Klasse Calculator.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Calculator
{
    
    public static String[] getListNotation(String term) {
        return Calculator.getParsedString(term).split(",");
    }
    
    public static String getParsedString(String term) {
        boolean selecting = false;
        String selection = "";
        String left = "";
        String right = "";
        String operator = "";
        int level = 0;
        
        for(int i = 0; i < term.length(); i++) {
            
            String charString = term.substring(i, i+1);
            
            if(charString.equals(" ")) {
                continue;
            }
            
            if(charString.equals("(")) {
                level++;
                if(level == 1) {
                    selecting = true;
                    continue;
                }
            }
            
            if(charString.equals(")")) {
                level--;
                if(level == 0) {
                    if(operator == "") {
                        left += Calculator.getParsedString(selection);
                    } else {
                        right += Calculator.getParsedString(selection);
                    }
                    selecting = false;
                    selection = "";
                    continue;
                }
            }
            
            if(selecting) {
                selection += charString;
                continue;
            }
            
            if(Calculator.isNumber(charString)) {
                if(operator == "") {
                    left += charString;
                } else {
                    right += charString;
                }
                continue;
            }
            
            if(Calculator.isOperator(charString)) {
                operator = charString;
            }
            
        }
        
        return operator + "," + left + "," + right;
    }
    
    public static int calculate(String term) {
        String[] listNotation = Calculator.getListNotation(term);
        
        Stack<String> firstStack = new Stack<String>();
        Stack<String> secondStack = new Stack<String>();
        
        for(int i = 0; i < listNotation.length; i++) {
            firstStack.push(listNotation[i]);
        }
        
        while(true) {
            String termElement = firstStack.pop();
            
            if(Calculator.isOperator(termElement)) {
                
                int num1 = Calculator.getInt(secondStack.pop());
                int num2 = Calculator.getInt(secondStack.pop());
                boolean leave = firstStack.isEmpty();
                
                switch(termElement) {
                    case "+":
                        secondStack.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        secondStack.push(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        secondStack.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        secondStack.push(String.valueOf(num1 / num2));
                        break;
                }
                
                if(leave) {
                    return Calculator.getInt(secondStack.top());
                }
                
            } else {
                secondStack.push(termElement);
            }
        }
    }
    
    public static boolean isOperator(String pString) {
        return "+-*/".contains(pString);
    }
    
    public static boolean isNumber(String pString) {
        return "0123456789".contains(pString);
    }
    
    public static int getInt(String pString) {
        return Integer.parseInt(pString);
    }
}
