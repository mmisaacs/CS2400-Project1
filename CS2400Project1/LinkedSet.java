package CS2400Project1;
import java.util.Arrays;

public class LinkedSet<T> implements SetInterface<T>{
    private Node firstNode;
    private int numOfEntries;

    //default constructor
    public LinkedSet(){
        firstNode = null;
        numOfEntries = 0;
    } //end linkedSet

    public int getCurrentSize(){
        return numOfEntries;
    }
    public boolean isEmpty(){
        return numOfEntries == 0;
    }

    public boolean add(T newEntry){
        //add to beginning
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; //connect to rest of chain
        firstNode = newNode; //add to beginning
        numOfEntries++;
        return true;
    }

    public T remove(){
        T result = null; //make value blank
        if (firstNode != null){
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numOfEntries--;
        }
        return result;
    }
    public boolean remove(T anEntry){
        return false;
    }

    public void clear(){
        while(!isEmpty()){
            remove();
        }
    }

    public boolean contains(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        while(!false && (currentNode != null)){
            if(anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return found;
    }

    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numOfEntries];

        int i = 0;
        Node currentNode = firstNode;
        while((i < numOfEntries) && (currentNode != null)){
            result[i] = currentNode.data;
            i++;
            currentNode = currentNode.next;
        }
        return result;
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
        private T data; //entry in set
        private Node next; //link to next node

        //standard constructor
        private Node(T dataPortion){
            this(dataPortion, null);
        }
        //constructor with two data fields
        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }

        private T getData(){
            return data;
        }
        private void setData(T newData){
            data = newData;
        }

        private Node getNextNode(){
            return next;
        }

        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }
}
