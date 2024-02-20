import java.util.Iterator;

// Iterator for the GenericList
public class GLLIterator<E> implements Iterator<E> {

    // Current node in the iteration
    private GenericList<E>.Node<E> head;

    // Constructor: initializes the iterator starting at the provided node
    public GLLIterator(GenericList<E>.Node<E> head) {
        this.head = head;
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

        GenericList<E>.Node<E> nextNode = this.head;
        this.head = this.head.next;

        return nextNode.data;
    }
}
