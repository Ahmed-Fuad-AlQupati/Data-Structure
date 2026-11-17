package datastructure;
import circularQueue.*;
import javax.swing.JOptionPane;
public class CircularQueueMain {
        
    public static void main(String[] args) {
        
        String ch;
        boolean run = true;
        
        while(run){
            ch = JOptionPane.showInputDialog("""
                                             [1] Using GUI.
                                             [2] Using JOptionPane.
                                             [E] Exit.""");

            switch (ch) {
                case "1":
                    new CircularQueueGUI().setVisible(true);
                    return;                
                case "2":  
                    run = false;
                    break;
                case "E","e":
                    return;                           
            }
        }
        
        
        run = true;
        CircularQueue cq = new CircularQueue();
        while(run){
            ch = JOptionPane.showInputDialog("""
                                             [1] Add Data to Circular Queue.
                                             [2] Remove Data from Circular Queue.
                                             [3] Print Data of Circular Queue.
                                             [4] Clear Data of Circular Queue.
                                             [E] Exit.""");
            switch (ch) {
                case "1":
                    cq.add();
                    break;
                    
                case "2":
                    Integer v = cq.remove();
                    if(v != null)
                        JOptionPane.showMessageDialog(null, "Value " + v + " Removed.");
                    else
                        JOptionPane.showMessageDialog(null, "Can't Remove .. Circular Queue is Empty !!");
                    break;
                    
                case "3":
                    cq.print();
                    break;
                    
                case "4":
                    cq.clear();
                    JOptionPane.showMessageDialog(null, "Circular Queue Cleared");
                    break;
                    
                case "E","e":
                    run = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not A Choice !!!");
            }
        }
    }
}
