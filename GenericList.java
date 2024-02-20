import java.util.*;

// Abstract class for a generic list
public abstract class GenericList<T> implements Iterable<T> {

    // First node in the list
    private Node<T> head;

    // Total number of items in the list
    private int length;

    // Inner class for a node in the list
    public class Node<T>{
        T data;          // Data of the node
        int code;        // Extra attribute (purpose unclear)
        Node<T> next;    // Next node in the list
    }

    // Print the list
    public void print() {
        if (this.head != null) {

            System.out.println("Empty List");
        } else {
            Node<T> currentNode = head;
            while (currentNode != null) {
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }
    }

    // Abstract method to add an item to the list
    public abstract void add(T data);

    // Abstract method to delete an item from the list
    public abstract T delete();

    // Convert list to an ArrayList
    public ArrayList<T> dumpList() {
        if (this.head == null) {
            return null;
        } else {
            ArrayList<T> list = new ArrayList<>();
            Node<T> currentNode = head;
            while (currentNode != null) {
                list.add(currentNode.data);
                currentNode = currentNode.next;
            }
            return list;
        }
    }

    // Get item at a specific index
    public T get(int index) {
        if (index < 0 || index >= length || this.head == null) {
            return null;
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    // Set item at a specific index
    public T set(int index, T element) {
        if (index < 0 || index > length || this.head == null) {
            return null;
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        T previousNode = get(index);
        currentNode.data = element;
        return previousNode;
    }

    // Get total number of items
    public int getLength() {
        return length;
    }

    // Set total number of items
    public void setLength(int length) {
        this.length = length;
    }

    // Get the first node
    public Node<T> getHead() {
        return head;
    }

    // Set the first node
    public void setHead(Node<T> head) {
        this.head = head;
    }

    // Return an iterator for the list
    @Override
    public Iterator<T> iterator() {
        GLLIterator<T> iterator = new GLLIterator<T>(head);
        return iterator;
    }

    // Return an iterator for the list in reverse
    public Iterator<T> descendingIterator() {
        if (this.head == null) {
            return null;
        }

        return new ReverseGLLIterator<>(this.head);
    }
}
