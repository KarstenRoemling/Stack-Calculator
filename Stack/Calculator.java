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
    
    /**
     * Converts a term into the list notation (but still as a string) and returns it.
     */
    public static String getParsedString(String term) {
        boolean selecting = false;
        String selection = "";
        String left = "";
        String right = "";
        String operator = "";
        int level = 0;
        
        for(int i = 0; i < term.length(); i++) {
            
            String charString = term.substring(i, i+1);
            
            if(charString.equals(",")) {
                charString = ".";
            }
            
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
            
            if(Calculator.isNumber(charString) || charString.equals(".")) {
                if(operator == "") {
                    left += charString;
                } else {
                    right += charString;
                }
                continue;
            }
            
            if(Calculator.isOperator(charString)) {
                if(operator != "" && right != "") {
                    right += charString;
                }
                if(left != "") {
                    operator = charString;
                    continue;
                }
                left += charString;
                continue;
            }
            
        }
        
        return Calculator.getTermString(operator, left, right);
    }
    
    /**
     * Calculates a result of a term in list notation (given as parameter), returns double (result of calculation)
     */
    public static double calculate(String term) {
        String[] listNotation = Calculator.getListNotation(term);
        
        if(listNotation.length == 0) {
            return 0;
        }
        
        if(listNotation.length == 1 && Calculator.isNumber(listNotation[0])) {
            return Calculator.getDouble(listNotation[0]);
        }
        
        Stack<String> firstStack = new Stack<String>();
        Stack<String> secondStack = new Stack<String>();
        
        for(int i = 0; i < listNotation.length; i++) {
            firstStack.push(listNotation[i]);
        }
        
        while(!firstStack.isEmpty()) {
            String termElement = firstStack.pop();
            
            if(Calculator.isOperator(termElement)) {
                
                double num1 = Calculator.getDouble(secondStack.pop());
                double num2 = Calculator.getDouble(secondStack.pop());
                
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
                
            } else {
                secondStack.push(termElement);
            }
            
        }
        
        return Calculator.getDouble(secondStack.top());
    }
    
    public static String getTermString(String operator, String left, String right) {
        if(operator != "" && left != "" && right != "") {
            return operator + "," + left + "," + right;
        } else {
            if(right != "") {
                return right;
            }
            if(left != "") {
                return left;
            }
            return "";
        }
    }
    
    public static boolean isOperator(String pString) {
        return "+-*/".contains(pString);
    }
    
    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    
    public static double getDouble(String pString) {
        return Double.parseDouble(pString);
    }
}
