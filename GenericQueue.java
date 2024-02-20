import java.util.*;

// Queue implementation extending GenericList
public class GenericQueue<T> extends GenericList<T> {

    private Node<T> tail;  // Last node in the queue

    // Constructor: initializes the queue with a single item
    public GenericQueue(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;
        setHead(newNode);
        tail = getHead();
        setLength(1);
    }

    // Add an item to the end of the queue
    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;
        if (getHead() == null) {
            setHead(newNode);
            tail = getHead();
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        setLength(getLength() + 1);
    }

    // Remove and return the item from the front of the queue
    @Override
    public T delete() {
        if (getHead() == null) {
            throw new NoSuchElementException("Queue is empty.");
        }

        Node<T> nodeToRemove = getHead();
        setHead(nodeToRemove.next);
        if (getHead() == null) {
            tail = null;
        }
        setLength(getLength() - 1);
        return nodeToRemove.data;
    }

    // Add an item to the end of the queue with a specific code
    public void add(T data, int code) {
        Node<T> newNode = new Node<>();
        newNode.data = data;
        newNode.code = code;

        if (getHead() == null) {
            setHead(newNode);
            tail = getHead();
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        setLength(getLength() + 1);
    }

    // Alias for add - adds an item to the end of the queue
    public void enqueue(T data) {
        add(data);
    }

    // Alias for delete - removes and returns the item from the front of the queue
    public T dequeue() {
        return delete();
    }

    // Returns an iterator for the queue in reverse order
    public Iterator<T> descendingIterator() {
        return new ReverseGLLIterator<>(getHead());
    }
}
