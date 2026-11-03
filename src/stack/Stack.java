package stack;

import javax.swing.JOptionPane;

public class Stack {
    
    private int size, data[], top = -1;
    
    public Stack() {
        this.size = Integer.parseInt(JOptionPane.showInputDialog("Enter Stack Size : "));
        this.data = new int[size];
    }
    
    public boolean isEmpty(){
        if(top == -1)
            return true;
        else
            return false;
            
    }
    
    public boolean isFull(){
        if(top == size - 1)
            return true;
        else
            return false;
    }
    
    public void push(){
        if(!isFull()){
            int value = Integer.parseInt(JOptionPane.showInputDialog("Enter Value : "));
            data[++top] = value;
            JOptionPane.showMessageDialog(null, "Value " + value + " Pushed into Stack.");
        }
        else
            JOptionPane.showMessageDialog(null, "Can't Push .. Stack is Full!!");            
    }
    
    public void pop(){
        if(!isEmpty()){
            JOptionPane.showMessageDialog(null, "Value " + data[top--] + " Popped.");                        
        }
        else
            JOptionPane.showMessageDialog(null, "Can't Pop .. Stack is Empty!!");
    }
    
    public void print(){
        if(!isEmpty()){
            int temp = top;
            String s = "";
            while(!isEmpty())
                s += data[top--] + "\n";

            JOptionPane.showMessageDialog(null, s);
            top = temp;
        }
        else
            JOptionPane.showMessageDialog(null, "Can't Print .. Stack is Empty!!");
    }
        
    public void max(){
        if(!isEmpty()){
            int temp = top;
            int max = data[top--];
            while(!isEmpty()){
                if(data[top] > max)
                    max = data[top];
                top--;
            }            
            JOptionPane.showMessageDialog(null, "The Maximum Value is " + max);
            top = temp;
        }
        else
            JOptionPane.showMessageDialog(null, "Can't Print Maximun .. Stack is Empty!!");
    }
        
    public void min(){
        if(!isEmpty()){
            int temp = top;
            int min = data[top--];
            while(!isEmpty()){
                if(data[top] < min)
                    min = data[top];
                top--;
            }            
            JOptionPane.showMessageDialog(null, "The Maximum Value is " + min);
            top = temp;
        }
        else
            JOptionPane.showMessageDialog(null, "Can't Print Minimun .. Stack is Empty!!");
    }
    
    public void sum(){
        if(!isEmpty()){
            int temp = top;
            int sum = 0;
            while(!isEmpty())
                sum += data[top--];            
            JOptionPane.showMessageDialog(null, "The Sum of Values are " + sum);
            top = temp;
        }
        else
            JOptionPane.showMessageDialog(null, "Can't Print Sum .. Stack is Empty!!");
    }
    
    public void find(){
        if(!isEmpty()){
            int value = Integer.parseInt(JOptionPane.showInputDialog("Enter Value to Find : "));
            int temp = top;
            boolean found = false;
            int count = 0;
            while(!isEmpty()){
                if(value == data[top--]){                    
                    found = true;
                    break;
                }
                count++;    
            }
            top = temp;
            if(found)
                JOptionPane.showMessageDialog(null, "Value " + value + " Found after " + count + " Elements");
            else
                JOptionPane.showMessageDialog(null, "Value " + value + "Not Found");
                
        }
        else
            JOptionPane.showMessageDialog(null, "Can't Find .. Stack is Empty!!");
            
    }
}
