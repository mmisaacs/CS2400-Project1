package CS2400Project1;
import java.util.Arrays;

public class LinkedSet<T> implements SetInterface<T>{
    private Node firstNode;
    private int numOfEntries;

    private Node getReferenceTo(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }
        return currentNode;
    }

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
        if(!contains(newEntry)) {
            Node newNode = new Node(newEntry);
            newNode.next = firstNode; //connect to rest of chain
            firstNode = newNode; //add to beginning
            numOfEntries++;
            return true;
        }
        return false;
    }

    //will remove most recent added entry (aka, the first entry)
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
        boolean result = false;
        Node locate = getReferenceTo(anEntry);
        if(locate != null){
            locate.data = firstNode.data;
            firstNode = firstNode.next;
            numOfEntries--;
            result = true;
        }
        return result;
    }

    public void clear(){
        while(!isEmpty()){
            remove();
        }
    }

    public boolean contains(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.getData())) //locate node
                found = true; //return true if found
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
            result[i] = currentNode.getData();
            i++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }

    public SetInterface<T> union(SetInterface<T> otherSet){
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
    public SetInterface<T> intersection(SetInterface<T> otherSet){
        SetInterface<T> intersectionSet = new LinkedSet<T>();
        T[] firstArray = toArray();
        for(int i = 0; i <firstArray.length;i++){
            if(otherSet.contains(firstArray[i])){
                intersectionSet.add(firstArray[i]);
            }
        }
        return intersectionSet;
    }
    public SetInterface<T> difference(SetInterface<T> otherSet){
        SetInterface<T> leftOver = new ResizeableArraySet<T>();
        T[] firstArray = toArray();
        for (int i = 0; i< firstArray.length; i++){
            if(!otherSet.contains(firstArray[i])){
                leftOver.add(firstArray[i]);
            } //end if
        } //end for
        return leftOver;
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
