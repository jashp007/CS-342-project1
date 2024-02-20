import java.util.Iterator;

// Iterator for GenericList in reverse order
public class ReverseGLLIterator<E> implements Iterator<E>{

    private GenericList<E>.Node<E> head;  // Current node in the iteration

    // Constructor: initializes the iterator starting at the provided node and reverses the list
    public ReverseGLLIterator(GenericList<E>.Node<E> head) {

        GenericList<E>.Node<E> previousNode = null;
        GenericList<E>.Node<E> currentNode = head;
        GenericList<E>.Node<E> nextNode = null;

        // Reverse the linked list
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        this.head = previousNode;
    }

    // Check if there's another element in the list to iterate over
    @Override
    public boolean hasNext() {
        return this.head != null;
    }

    // Return the next element in the list and move the iterator forward
    @Override
    public E next() {
        if (!hasNext()) {
            return null;
        }

        E nextNode = this.head.data;
        this.head = this.head.next;

        return nextNode;
    }
}
