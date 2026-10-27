package arrays;

import javax.swing.JOptionPane;

public class Arrays {
    
    private final int size;
    private int data[];
    private int count = 0;
    
    public Arrays(int size){
        this.size = size;
        this.data = new int[size];
    }
    
    public Arrays(){
        this.size = Integer.parseInt(JOptionPane.showInputDialog("Enter Array Size :"));
        this.data = new int[size];
    }
    
    
    ///////////////////////////////////
    
    public void print(){
        if(count > 0){
            String s = "";
            for(int i = 0; i < count; i++)
                s += data[i] + "  ";
            
            JOptionPane.showMessageDialog(null, "Array Data :\n" + s);
        }
        else
            JOptionPane.showMessageDialog(null, "Array is Empty !!");
    }
    
    
    ///////////////////////////////
    
    public void insert(){
        if(count < size){
            int value = Integer.parseInt( JOptionPane.showInputDialog("Enter Value :") );
            int index = Integer.parseInt( JOptionPane.showInputDialog("Enter Index :") );
            
            if(index <= count && index >= 0){
                for(int i = count; i > index; i--)
                    data[i] = data[i-1];
                
                data[index] = value;
                count++;
                JOptionPane.showMessageDialog(null, "Value " + value + " Inserted Sucessfully.");
            }
            else if(index > 0 && index < size){
                data[count] = value;
                count++;
                JOptionPane.showMessageDialog(null, "Value " + value + " Inserted Sucessfully.");                
            }
            else
                JOptionPane.showMessageDialog(null, "Error in Index !!");
            
            
        }
        else
            JOptionPane.showMessageDialog(null, "Array is Full !!!");
    }
    
    //////////////////////////////////
    
    public void remove(){
    
        if(count > 0){
            int value = Integer.parseInt(JOptionPane.showInputDialog("Enter Value to Remove : "));
            boolean removed = false;
            for(int i = 0; i < count; i++){
                if(data[i] == value){
                    for(int j = i; j < count-1; j++)
                        data[j] = data[j+1];
                    
                    removed = true;
                    count--;                    
                    JOptionPane.showMessageDialog(null, "Value " + value + " Removed Sucessfully.");
                }
            }
            if(!removed)
                JOptionPane.showMessageDialog(null, "No Remove!!!\nValue " + value + " Not Found in Array.");
                
        }
        else
            JOptionPane.showMessageDialog(null, "Array is Empty !!");
        
    }
    
    ///////////////////////////////////
    
    public void clear(){
        if(count > 0){
            count = 0;
            JOptionPane.showMessageDialog(null, "Array Cleared.");
        }
        else
            JOptionPane.showMessageDialog(null, "Array is Clear !!");
            
    }
    
    /////////////////////////////////////
    
    public void sort(boolean ascending){
        for(int i = 0; i < count-1; i++){
            for(int j = i+1; j < count; j++){
                if(ascending)
                    if(data[i] > data[j]){
                        data[i] += data[j];
                        data[j] = data[i] - data[j];
                        data[i] -= data[j];
                    }
                
                else
                    if(data[i] > data[j]){
                        data[i] += data[j];
                        data[j] = data[i] - data[j];
                        data[i] -= data[j];
                    }
            }
            JOptionPane.showMessageDialog(null, "Array Sorted.");
        }
    }
    
    /////////////////////////////////////
    
    
}
