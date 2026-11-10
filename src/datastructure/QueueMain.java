package datastructure;

import javax.swing.JOptionPane;
import queue.*;

public class QueueMain {

    public static void main(String[] args) {
        
        String ch;
        ch = JOptionPane.showInputDialog("""                                         
                                         [1] Using GUI Frame.
                                         [2] Using JOptionPane.""");
        if(ch.equals("1")){
            new QueueGUI().setVisible(true);
            return;
        }
        
        
        int size = Integer.parseInt( JOptionPane.showInputDialog("Enter Queue Size") );
        Queue queue = new Queue(size);
        
        boolean run = true;
        Integer value;      // Used Later in switch.
        while(run){
            ch = JOptionPane.showInputDialog( """
                                                [1] Add Data to Queue.
                                                [2] Remove Data from Queue.
                                                [3] Print Data of Queue.
                                                [4] Clear Data of Queue.
                                                [E] Exit.""");
            
            switch (ch) {
                case "1":
                    if(queue.isFull()){
                        JOptionPane.showMessageDialog(null, "Can't Add, Queue is Full !!");
                        continue;                    
                    }                    
                    value = Integer.valueOf(JOptionPane.showInputDialog("Enter Value to Add") );
                    queue.add(value);
                    JOptionPane.showMessageDialog(null, "Value " + value + " Added.");                    
                    break;
                    
                case "2":
                    value = queue.remove();
                    if(value != null)
                        JOptionPane.showMessageDialog(null, "Value " + value + " Removed.");
                    else
                        JOptionPane.showMessageDialog(null, "No Data to Remove !!!.");                        
                    break;
                    
                case "3":
                    if(queue.isEmpty())
                        JOptionPane.showMessageDialog(null, "No Data To Print !!!.");
                    else
                        JOptionPane.showMessageDialog(null, "Queue Data\n" + queue.getDataAsString());                        
                    break;
                    
                case "4":
                    queue.clear();
                    JOptionPane.showMessageDialog(null, "Queue Cleared.");                        
                    
                    break;
                    
                case "e":
                case "E":
                    run = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null , "Not A Choice !!!");
            }
        }
    }
    
}
