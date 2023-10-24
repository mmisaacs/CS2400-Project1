package CS2400Project1;

public class ArraySetTest {
    public static void main (String[] args){
        //create the set
        SetInterface<Integer> intSet = new ResizeableArraySet<>();

        //check that the set is empty
        System.out.println("Is set empty? " + intSet.isEmpty());

        //signify that the set is being filled
        System.out.println("Populating the set...");
        int[] fillSet = {1, 2, 3, 1, 4, 2, 4, 2, 3, 1, 2};
        testAdd(intSet, fillSet);

        //check again if set is full now
        System.out.println("Is set empty? " + intSet.isEmpty());


    }

    public static void testAdd(SetInterface<Integer> set, int[] content){
        System.out.println("Populating the set...");
        for(int i : content){
            set.add((content[i]));
            System.out.print(content[i] + " ");
        }
        System.out.println();

        displaySet(set);
    }

    public static void displaySet(SetInterface<Integer> set){
        System.out.println("The set contains these number(s): ");
        Object[] setArray = set.toArray();
        for (int i = 0; i < setArray.length; i++){
            System.out.print(setArray[i] + " ");
        } //end for loop
        System.out.println();
    } //end displaySet
} //end ArraySetTest
