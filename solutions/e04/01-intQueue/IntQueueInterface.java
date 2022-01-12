
public interface IntQueueInterface{

    // insert element in the queue
    void enqueue(int el) throws QueueException;

    // remove element from the queue
    int dequeue() throws QueueException;
}