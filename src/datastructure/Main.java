package datastructure;

import arrays.Arrays;
import javax.swing.JOptionPane;
import stack.Stack;



public class Main {

    public static void main(String[] args) {
    
        Stack stack = new Stack();
        String ch;        
        boolean run = true;
        while(run){
            ch = JOptionPane.showInputDialog("""
                                             [1] Push.
                                             [2] pop.
                                             [3] Print Stack's Data.
                                             [4] Maximum Value.
                                             [5] Minimum Value.
                                             [6] Sum all Values.
                                             [7] Find Value.
                                             [E] Exit.""");
        
        
            switch(ch){
                case "1":
                    stack.push();
                    break;
                    
                case "2":
                    stack.pop();
                    break;
                    
                case "3":
                    stack.print();
                    break;
                    
                case "4":
                    stack.max();
                    break;
                    
                case "5":
                    stack.min();
                    break;
                    
                case "6":
                    stack.sum();
                    break;
                    
                case "7":
                    stack.find();
                    break;
                    
                case "E":
                case "e":
                    run = false;
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Not A Choice !!!");
            }
        }
    }

}



