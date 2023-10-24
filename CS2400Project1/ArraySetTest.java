package CS2400Project1;

public class ArraySetTest {
    public static void main (String[] args){
        //create the set
        SetInterface<Integer> intSet = new ResizeableArraySet<>();

        //check that the set is empty
        System.out.println("Is the set empty? " + intSet.isEmpty());

        //attempt to fill the set, fillSet is the given entries
        int[] fillSet = {1, 2, 3, 1, 4, 2, 4, 2, 3, 1, 2};
        testAdd(intSet, fillSet); //expected output "1 2 3 4", no repeat numbers

        //check again if set is still empty (added entries successfully if false)
        System.out.println("Is set empty? " + intSet.isEmpty());


    }

    public static void testAdd(SetInterface<Integer> set, int[] content){
        System.out.println("Populating the set...");
        for(int i = 0; i < content.length; i++){
            //implements the add method
            set.add((content[i]));
            System.out.print(content[i] + " ");
        }
        System.out.println();

        displaySet(set);
    }

    public static void displaySet(SetInterface<Integer> set){
        System.out.println("The set contains these number(s): ");
        Object[] setArray = set.toArray();
        for(int i = 0; i < setArray.length; i++){
            System.out.print(setArray[i] + " ");
        } //end for loop
        System.out.println();
    } //end displaySet
} //end ArraySetTest
