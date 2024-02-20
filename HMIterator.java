import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

// Iterator for a hashmap using an ArrayList of GenericQueue
public class HMIterator<T> implements Iterator<T> {

    private ArrayList<GenericQueue<T>> map;  // The underlying map being iterated over
    private int currentBucketIndex;  // The current bucket's index in the map
    private GenericList<T>.Node<T> currentNode;  // The current node being processed within a bucket

    // Constructor: initializes the iterator with the provided map
    public HMIterator(ArrayList<GenericQueue<T>> map) {
        this.map = map;
        this.currentBucketIndex = 0;
        this.currentNode = null;

        // Move to the first non-empty bucket's head node
        while (currentBucketIndex < map.size() && (map.get(currentBucketIndex) == null || map.get(currentBucketIndex).getHead() == null)) {
            currentBucketIndex++;
        }
        if (currentBucketIndex < map.size() && map.get(currentBucketIndex) != null) {
            currentNode = map.get(currentBucketIndex).getHead();
        }
    }

    // Check if there are more elements left to iterate over
    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    // Return the next element and advance the iterator
    @Override
    public T next() {
        if (currentNode == null) {
            throw new NoSuchElementException("No more elements in the hashmap.");
        }

        T data = currentNode.data;
        currentNode = currentNode.next;

        // If end of current bucket is reached, move to the next non-empty bucket
        while (currentNode == null && currentBucketIndex < map.size() - 1) {
            currentBucketIndex++;
            if (map.get(currentBucketIndex) != null) {
                currentNode = map.get(currentBucketIndex).getHead();
            }
        }

        return data;
    }
}
