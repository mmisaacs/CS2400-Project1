package CS2400Project1;
import java.util.Arrays;

public class LinkedSet<T> implements SetInterface<T>{
    private Node firstNode;
    private int numOfEntries;

    public LinkedSet(){
        firstNode = null;
        numOfEntries = 0;
    } //end linkedSet
    public int getCurrentSize(){
        return -1;
    }
    public boolean isEmpty(){
        return false;
    }

    public boolean add(T newEntry){
        return false;
    }

    public T remove(){
        return null;
    }
    public boolean remove(T anEntry){
        return false;
    }

    public void clear(){

    }
    public boolean contains(T anEntry){
        return false;
    }
    public T[] toArray(){
        return null;
    }

    public SetInterface<T> union(SetInterface<T> otherSet){
        return null;
    }
    public SetInterface<T> intersection(SetInterface<T> otherSet){
        return null;
    }
    public SetInterface<T> difference(SetInterface<T> otherSet){
        return null;
    }

    private class Node{
        private T entry; //entry in set
        private Node next; //link to next node
    }
}
