package queue;

public class Queue {
    
    private int size, data[], front = 0, rear = -1;

    public Queue(int size) {
        this.size = size;
        data = new int[size];        
    }
    
    /**
     * Method Checks Queue if it's Empty or not,
     * Return true if Empty, false if not Empty
     * @return boolean
     */
    public boolean isEmpty(){
        if(rear < front)
            return true;
        return false;
    }
    
    /**
     * Method Checks Queue if it's Full or not,
     * Return true if Full, false if not Full.
     * @return boolean
     */
    public boolean isFull(){
        if(rear == size-1)
            return true;
        return false;
    }
    
    
    /**
     * Method to Clear add Data in Queue.
     */
    public void clear(){
        this.front = 0;
        this.rear = -1;
    }
    
    /**
     * This Method add Value into Queue, 
     * Return true if Value Added,
     * or false if Queue is Full.
     * @param value
     * @return boolean
     */
    public boolean add(int value){
        if(!isFull()){
            data[++rear] = value;
            return true;
        }
        else
            return false;            
    }
    
    /**
     * This Method Remove Element from Queue and return it,
     * it Returns null if Queue is Empty.
     * @return Integer
     */
    public Integer remove(){
        if(!isEmpty()){
            int temp = data[front];
            if(front == rear)
                this.clear();
            else
                this.front++;
            return temp;
        }
        else
            return null;
    }
    
    /**
     * Method Returns Value of the front
     * @return int
     */
    public int getFront(){
        return this.front;
    }
    
    /**
     * Method Returns Value of the rear
     * @return int
     */
    public int getRear(){
        return this.rear;
    }
    
    
    /**
     * Method Returns Value of the size of Queue
     * @return int
     */
    public int getSize(){
        return this.size;
    }
    
    /**
     * Method Returns Data in the Queue
     * @return int[]
     */
    public int[] getData(){
        return data;
    }
    
    /**
     * Method Returns all Data in the Queue As String Value
     * @return String
     */
    public String getDataAsString(){
        int frontTemp = this.front;
        int rearTemp = this.rear;
        String s = "";
        Integer temp;
        while(true){
            temp = remove();
            if(temp == null){
                front = frontTemp;
                rear = rearTemp;
                return s; 
            }
            
            s += temp.toString() + " ";
        }
        
    }
    
    
    
    
    
}
