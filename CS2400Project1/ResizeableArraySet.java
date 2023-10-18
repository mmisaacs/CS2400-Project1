package CS2400Project1;
import java.util.Arrays;

public class ResizeableArraySet<T> implements SetInterface<T> {
    private int numOfEntries = 0;
    private T[] arraySet = (T[]) new Object[10];

    private void doubleCapacity(){
        int newLength = 2 * arraySet.length;
        arraySet = Arrays.copyOf(arraySet, newLength);
    }

    public int getCurrentSize() {
        return numOfEntries;
    }

    public boolean isEmpty() {
        return numOfEntries == 0;
    }
    
    public boolean add(T newEntry) {
        if(!contains(newEntry)) {
            arraySet[numOfEntries] = newEntry;
            ++numOfEntries;
            return true;
        }
        return false;
    }

    @Override
    public T remove() {
        T temp = arraySet[numOfEntries];
        arraySet[numOfEntries] = null;
        --numOfEntries;
        return temp;
    }

    @Override
    public boolean remove(T anEntry) {
        if(contains(anEntry)) {

        }

        return false;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    public boolean contains(T anEntry) {
        for(int i = 0; i < numOfEntries; ++i) {
            if (arraySet[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        return new Object[0];
    }

    @Override
    public SetInterface difference(SetInterface otherSet) {
        return null;
    }

    @Override
    public SetInterface intersection(SetInterface otherSet) {
        return null;
    }

    @Override
    public SetInterface union(SetInterface otherSet) {
        return null;
    }
}
