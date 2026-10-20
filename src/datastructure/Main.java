package datastructure;

import arrays.Arrays;
import javax.swing.JOptionPane;



public class Main {

    public static void main(String[] args) {
    
        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter Array size:"));
        
        int array[] = new int[size];
    
        //// Add Data to Array
        for(int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter Value : "));
        
        
        
        ///// Print Data from Array
        String s = "";
        for(int i = 0; i < array.length; i++)
            s += array[i] + "  ";
        JOptionPane.showMessageDialog(null, s);
        
        
        
        ///// Print Data from Array in Reverse
        s += "\n";
        
        for(int i = array.length-1; i >= 0; i--)
            s += array[i] + "  ";
        JOptionPane.showMessageDialog(null, s);
        


        ///// Reverse Array's Data
        s += "\n";
        
        int t;
        for(int i = 0; i < array.length/2; i++){
            t = array[i];
            array[i] = array[ array.length - 1 - i ];
            array[ array.length - 1 - i ] = t;
        }
        
        for(int i = 0; i < array.length; i++)
            s += array[i] + "  ";
        JOptionPane.showMessageDialog(null, s);
        
        
        
        
        ///// Sort Data in Array Upwards
        s += "\n";
        for(int i = 0; i < array.length-1; i++)
            for(int j = i+1; j < array.length; j++)
                if(array[j] < array[i]){
                    array[i] += array[j];
                    array[j] = array[i] - array[j];
                    array[i] -= array[j];
                }
        
        for(int i = 0; i < array.length; i++)
            s += array[i] + "  ";
        JOptionPane.showMessageDialog(null, s);
        


        ///// Line Search in Array
        int v = Integer.parseInt(JOptionPane.showInputDialog("Enter Number to Find : "));
        int f = -1;
        int c = 0;
        for(int i = 0; i < array.length; i++){
            c++;
            if(array[i] == v ){
                f = i;
                break;
            }
        }
        
        if(f > -1)
            JOptionPane.showMessageDialog(null, "Found in Index " + f + " in " + c + " Times");
        else
            JOptionPane.showMessageDialog(null, "Not Found");
        



        ///// Binary Search in array
        //v = Integer.parseInt(JOptionPane.showInputDialog("Enter Number to Find : "));
        int r = 0, l = array.length - 1, m;
        f = -1;
        c = 0;
        while(r <= l){
            c++;
            m = (r + l) / 2;
            if(array[m] == v){
                f = m;
                break;
            }
            else if(m > v)
                l = m - 1;
            else
                r = m + 1;
        }
        if(f > -1)
            JOptionPane.showMessageDialog(null, "Found in Index " + f + " in " + c + " Times");
        else
            JOptionPane.showMessageDialog(null, "Not Found");
        
        

    
    }
    


}



