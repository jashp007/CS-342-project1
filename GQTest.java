import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GQTest {

    @Test
    public void testConstructor() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        assertEquals(1, queue.dequeue());
    }

    @Test
    public void testEnqueueAndDequeue() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    public void testAdd() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.add(2);
        queue.add(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    public void testAddWithCode() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.add(2, 100);
        queue.add(3, 200);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    public void testDelete() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.delete());
        assertEquals(2, queue.delete());
    }
}
