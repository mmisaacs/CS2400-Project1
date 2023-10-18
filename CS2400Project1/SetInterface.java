package CS2400Project1;
public interface SetInterface<T> {
    public int getCurrentSize();
    public boolean isEmpty();
    /* adds NEW item to set, will return true if added successfully
    returns false if item is already in set, no duplicates*/

    public boolean add(T newEntry);

    public T remove();
    public boolean remove(T anEntry);

    public void clear();
    public boolean contains(T anEntry);
    public T[] toArray();

    public SetInterface<T> union(SetInterface<T> otherSet);
    public SetInterface<T> intersection(SetInterface<T> otherSet);
    public SetInterface<T> difference(SetInterface<T> otherSet);
}
