
import java.util.Queue;

public class IntQueue implements IntQueueInterface{

    int[] queue;
    int tail, head;

    /**
    * Constructor of the class, create an empty tail with length n.
    */
    public IntQueue(int n){
        queue = new int[n];
        tail = head = 0;
    }

    /**
    * insert element in the queue.
    * pre-condition: el is an integer value.
    * post-condition: added el into the queue.
    * throws: aaaaException if the queue is full.
    */
    public void enqueue(int el) throws QueueException{
        if (tail == size()-1){
            throw new QueueException("the queue is full");
        }

        tail += 1;
        queue[tail] = el;
    }

    /**
    * remove element from the queue.
    * pre-condition: the list is not empty.
    * post-condition: return the element removed.
    * throws: aaaException if the list is empty.
    */ 
    public int dequeue() throws QueueException{
        if(head == tail){
            throw new QueueException("the queue is empty");
        }
        
        int el = queue[tail];
        tail -=1;

        return el;
    }

    /**
    * return the maximum size of the queue.
    * pre-condition: queue is not null.
    * post-condition: return the maximum size of the queue.
    */
    public int size(){
        return queue.length;
    }


    @Override
    public String toString(){
        String str = "Elements of the queue: ";
        
        if (tail == head){
            return str + "the queue is empty.";
        }

        for(int i = 0; i < tail+1; i++ ){
            str += " " + i;
        }

        return str;
    }

    /**
    * Invariant of representation.
    */
    public boolean repOK(){
        return tail < size()
            && queue != null
            && head >= 0
            && tail >= 0;
    }
}