package CS2400Project1;
import java.util.Arrays;

public class ResizeableArraySet<T> implements SetInterface<T> {
    private T[] arraySet;
    private int numOfEntries;
    private static final int defaultCap = 5;

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
        if(isFull()){
            doubleCapacity();
        }
        if(!contains(newEntry)) {
            arraySet[numOfEntries] = newEntry;
            numOfEntries++;
            return true;
        }
        return false;
    }

    @Override
    public T remove() {
        T temp = null;
        if (numOfEntries > 0) {
            temp = arraySet[numOfEntries - 1];
            arraySet[numOfEntries - 1] = null;
            numOfEntries--;
        }
        return temp;
    }

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        T temp = null;

        if (!isEmpty() && (index >= 0)) {
            temp = arraySet[numOfEntries - 1];
            arraySet[index] = temp;
            numOfEntries--;
            //return true;
        }
        return anEntry.equals(temp);
    }


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

    //creates an array with all the entries in set, returns an array w the entries
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
        T[] firstArray = toArray();
        for (int i = 0; i< firstArray.length; i++){
            if(!otherSet.contains(firstArray[i])){
                leftOver.add(firstArray[i]);
            } //end if
        } //end for
        return leftOver;
    } //end difference method

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
