import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HMTest {

    @Test
    public void testConstructor() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        assertEquals(1, map.get("key1"));
    }

    @Test
    public void testPutAndGet() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        map.put("key2", 2);
        assertEquals(1, map.get("key1"));
        assertEquals(2, map.get("key2"));
    }

    @Test
    public void testContains() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        assertTrue(map.contains("key1"));
        assertFalse(map.contains("key2"));
    }

    @Test
    public void testSizeAndIsEmpty() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
    }

    @Test
    public void testReplace() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        Integer prevValue = map.replace("key1", 2);
        assertEquals(1, prevValue);
        assertEquals(2, map.get("key1"));
    }

    @Test
    public void testIterator() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 1);
        map.put("key2", 2);
        int sum = 0;
        for(int val : map) {
            sum += val;
        }
        assertEquals(3, sum);
    }
}
