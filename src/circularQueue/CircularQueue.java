package circularQueue;

import javax.swing.JOptionPane;

public class CircularQueue {
    
    private int size, front, rear, data[];
    
    /**
     * Constructor Create Object .. the size Entered By JOptionPane in it
     */
    public CircularQueue() {
        this.size = Integer.parseInt(JOptionPane.showInputDialog("Enter Circular Queue Size : "));
        front = 0;
        rear = -1;
        data = new int[size];
    }
    /**
     * Constructor Create Object .. the size send as Parameter
     * @param size 
     */
    public CircularQueue(int size) {
        this.size = size;
        front = 0;
        rear = -1;
        data = new int[size];
    }
    
    /**
     * Method to Clear all Data of Circular Queue
     */
    public void clear(){
        front = 0;
        rear = -1;        
    }
    
    /**
     * Method to Check if the Circular Queue is Empty ro not
     * Return true if Empty, false if not
     * @return boolean
     */
    public boolean isEmpty(){
        if(rear == -1)
            return true;
        return false;
    }
    
    /**
     * Method to Check if the Circular Queue is Full ro not
     * Return true if Full, false if not
     * @return boolean 
     */
    public boolean isFull(){
        if((rear + 1) % size == front && rear != -1 )
            return true;
        return false;
    }
    
    /**
     * Method to Add Data into Circular Queue
     * Value Entered in Method by JOptionPane
     */
    public void add(){
        if(!isFull()){
            int value = Integer.parseInt( JOptionPane.showInputDialog("Enter Value to Add : ") );
            rear = (rear + 1) % size;
            data[rear] = value;
            JOptionPane.showMessageDialog(null, "Value " + value + " Added.");
        }
        else
            JOptionPane.showMessageDialog(null, "Can't Add Value .. Circular Queue is Full !!");            
    }
    
    /**
     * Method to Add Data into Circular Queue
     * Value send as Parameter
     * Returns true if value added, false if Circular Queue Full
     * @param value
     * @return boolean
     */
    public boolean add(int value){
        if(!isFull()){            
            rear = (rear + 1) % size;
            data[rear] = value;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Method to Remove Data from Circular Queue and Returns it
     * @return Integer
     */
    public Integer remove(){
        if(!isEmpty()){
            int temp = data[front];
            if(front == rear)
                clear();
            else
                front = (front + 1) % size;
            return temp;
        }
        else
            return null;
    }
    
    /**
     * Method to Print all Data of Circular Queue
     */
    public void print(){
        if(!isEmpty()){
            int f = front;
            int r = rear;
            String s = "";
            while(!isEmpty()){
                s += remove() + "  ";
            }
            JOptionPane.showMessageDialog(null, "Circular Queue Data:\n" + s);
            front = f;
            rear = r;
        }
        else
            JOptionPane.showMessageDialog(null, "Can't Print Data .. Circular Queue is Empty !!");
    }
    
    
    public int getSize(){
        return size;
    }
    
    public int getFront(){
        return front;
    }
    
    public int getRear(){
        return rear;
    }
    
    public String getDataAsString(){
        int f = front;
        int r = rear;
        String s = "";
        while(!isEmpty()){
            s += remove() + "  ";
        }        
        front = f;
        rear = r;
        return s;
    }
    
}
