package CS2400Project1;
import java.util.Arrays;

public class ResizeableArraySet<T> implements SetInterface<T> {
    private T[] arraySet;
    private int numOfEntries;
    private static final int defaultCap = 25;

    //creating an empty set with the default capacity
    public ResizeableArraySet() {
        this(defaultCap);
    }

    //initializing the Set according to the size provided
    public ResizeableArraySet(int capacity){
        numOfEntries = 0;

        @SuppressWarnings("unchecked")
        T[] tempSet = (T[])new Object[capacity];
        arraySet = tempSet;
    }


    private boolean isFull(){
        return numOfEntries >= arraySet.length;
    }

    private void doubleCapacity(){
       arraySet = Arrays.copyOf(arraySet, 2 * arraySet.length);
    }

    private int getIndexOf(T anEntry){
        int index = 0;

        while (index < numOfEntries){
            if (anEntry.equals(arraySet[index])){
                return index;
            }
            index++;
        }

        return -1;
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
            numOfEntries++;
            return true;
        }
        return false;
    }

    @Override
    public T remove() {
        T temp = arraySet[numOfEntries];
        arraySet[numOfEntries] = null;
        numOfEntries--;
        return temp;
    }

    @Override
    public boolean remove(T anEntry) {
        //FINISH
        int index = getIndexOf(anEntry);
        T result = null;
        if (!isEmpty() && (index >= 0)) {

            T temp = arraySet[numOfEntries];
            arraySet[index] = temp;
            numOfEntries--;
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public void clear() {
        while (isEmpty()) {
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

    //creates an array with all the entries in set,, returns an array w the entries
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numOfEntries];
        for (int i = 0; i < numOfEntries; i++){
            result[i] = arraySet[i];
        }
        return result;
    }

    @Override
    public SetInterface<T> difference(SetInterface<T> otherSet) {
        SetInterface<T> leftOver = new ResizeableArraySet<T>();
//      first traversal
        T[] firstArray = toArray();
        T[] secondArray = otherSet.toArray();
        for (int i = 0; i< firstArray.length; i++){
            if(!otherSet.contains(firstArray[i])){
                leftOver.add(firstArray[i]);
            }
        }
        for(int i = 0; i< secondArray.length; i++){
            if(!contains(secondArray[i])){
                leftOver.add(secondArray[i]);
            }
        }

        return leftOver;
    }

    @Override
    public SetInterface<T> intersection(SetInterface<T> otherSet) {
        SetInterface<T> intersectionSet = new ResizeableArraySet<T>();
        T[] firstArray = toArray();
        for(int i = 0; i <firstArray.length;i++){
            if(otherSet.contains(firstArray[i])){
                intersectionSet.add(firstArray[i]);
            }
        }
        return intersectionSet;
    }

    @Override
    public SetInterface<T> union(SetInterface<T> otherSet) {
        SetInterface<T> unionSet = new ResizeableArraySet<T>();
        T[] firstArray = toArray();
        T[] secondArray = otherSet.toArray();
        for (int i = 0; i < firstArray.length; i++){
            unionSet.add(firstArray[i]);
        }
        for (int i = 0; i < secondArray.length; i++){
            unionSet.add(secondArray[i]);
        }


        return unionSet;
    }
}
