import java.util.Iterator;
import java.util.ArrayList;

public class MyHashMap<T> implements Iterable<T>{
    private ArrayList<GenericQueue<T>> map;

    // initializing arraylist map to 10
    public MyHashMap(String key, T value){
        map = new ArrayList<GenericQueue<T>>(10);
        for(int i = 0; i < 10; i++){
            map.add(null);  // clearing queue
        }
        this.put(key, value); // adding the first key/value pair into the map
    }

    // Creating a hash code and hash value using the key passed into the method
    public void put(String key, T value){
        int hashCode = key.hashCode();
        int hashVal = hashCode & 9;
        if(map.get(hashVal) == null){
            map.set(hashVal, new GenericQueue<>(value));
            map.get(hashVal).getHead().code = hashCode;
        }else{
            map.get(hashVal).add(value,hashCode);
        }
    }


    // Checking if key exists in HashMap

    public boolean contains(String key){
        int hashCode = key.hashCode();
        int hashVal = hashCode & 9;
        if(map.get(hashVal) != null){
            GenericList<T>.Node<T> currentData = map.get(hashVal).getHead();

            while(currentData != null) {
                if (currentData.code == hashCode) {
                    return true;
                }
                currentData = currentData.next;
            }
        }
        return false;
    }

    // returns the value at the given key


    public T get(String key){
        int hashCode = key.hashCode();
        int hashVal = hashCode & 9;

        if(map.get(hashVal) != null){
            GenericList<T>.Node<T> currentData = map.get(hashVal).getHead();

            while(currentData != null) {
                if (currentData.code == hashCode) {
                    return currentData.data;
                }
                currentData = currentData.next;
            }
        }
        return null;
    }

    //returns the number of key-value mappings in the map.


    public int size(){
        int result = 0;
        for (int i = 0; i < 10; i++){
            if(map.get(i) != null){
                result += map.get(i).getLength();
            }
        }
        return result;
    }

    //returns true if this map contains no key-value mappings

    public boolean isEmpty(){
        if(size() != 0){
            return false;
        }

        return true;
    }

    //updates the entry for the given key only if it is already mapped to a value

    public T replace(String key, T value){
        int hashCode = key.hashCode();
        int hashVal = hashCode & 9;

        if(map.get(hashVal) != null){
            GenericList<T>.Node<T> currentData = map.get(hashVal).getHead();

            while(currentData != null) {
                if (currentData.code == hashCode) {
                    T updatedData = currentData.data;
                    currentData.data = value;
                    return updatedData;
                }
                currentData = currentData.next;
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new HMIterator<T>(this.map);
    }
}