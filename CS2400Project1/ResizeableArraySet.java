package CS2400Project1;
import java.util.Arrays;

public class ResizeableArraySet<T> implements SetInterface<T> {
    private int numOfEntries = 0;
    private T[] arraySet = (T[]) new Object[10];

    private boolean isFull(){
        return numOfEntries == arraySet.length;
    }

    private void doubleCapacity(){
        int newLength = 2 * arraySet.length;
        arraySet = Arrays.copyOf(arraySet, newLength);
    }

    private int getIndexOf(T anEntry){
        int location = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < numOfEntries)){
            if (anEntry.equals(arraySet[index])){
                found = true;
                location = index;
            }
            index++;
        }

        return location;
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
        //FINISH
        int index = getIndexOf(anEntry);
        T result = null;
        if (!isEmpty() && (index >= 0)) {
            result = arraySet[index];
            T temp = arraySet[index];
            arraySet[index] = null;
            numOfEntries--;
        }
        return anEntry.equals(result);
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
        T[] result = (T[]) new Object[numOfEntries];
        for (int i = 0; i < numOfEntries; i++){
            result[i] = arraySet[i];
        }
        return result;
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
