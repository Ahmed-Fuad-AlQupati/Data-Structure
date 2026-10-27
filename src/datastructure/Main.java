package datastructure;

import arrays.Arrays;
import javax.swing.JOptionPane;



public class Main {

    public static void main(String[] args) {
    
        Arrays array = new Arrays();
        String ch;
        boolean run = true;
        while(run){
            ch = JOptionPane.showInputDialog("""
                                             [1] Insert into Array.
                                             [2] Remove from Array.
                                             [3] Print Array's Data.
                                             [4] Clear Data in Array.
                                             [5] Ascending Sort Array's Data.
                                             [6] Descending Sort Array's Data.
                                             [E] Exit.""");
        
        
            switch(ch){
                case "1":
                    array.insert();
                    break;
                    
                case "2":
                    array.remove();
                    break;
                    
                case "3":
                    array.print();
                    break;
                    
                case "4":
                    array.clear();
                    break;
                    
                case "5":
                    array.sort(true);
                    break;
                    
                case "6":
                    array.sort(false);
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



