package CS2400Project1;

public class ArraySetTest {
    public static void main (String[] args){
        //create the set
        SetInterface<Integer> set1 = new ResizeableArraySet<>();

        //check that the set is empty
        System.out.println("Creating a Resizable Set, Set1");
        System.out.println("Testing isEmpty(), Is the Set1 empty? " + set1.isEmpty());

        //attempt to fill the set, fillSet is the given entries
        int[] fillSet = {1, 2, 3, 1, 4, 2, 5, 4, 2, 3, 1, 2, 5};
        testAdd(set1, fillSet); //expected output "1 2 3 4", no repeat numbers

        //check again if set is still empty (added entries successfully if false)
        System.out.println("Is Set1 empty? " + set1.isEmpty());
        System.out.println("Current Set1 Size: " + set1.getCurrentSize());
        System.out.println();

        //check for 1 (true) and 7(false) in set
        System.out.println("Testing contains() method.");
        System.out.println("Is 1 in the Set1? " + set1.contains(1));
        System.out.println("Is 7 in the Set1? " + set1.contains(7));
        System.out.println();

        //remove last entry (4) and print updated set (should look like: 1 2 3 4)
        System.out.println("Testing remove(), it removes entry: " + set1.remove());
        displaySet(set1);
        System.out.println();

        //remove the second entry and print updated set (should look like: 1 4 3)
        System.out.println("testing remove(), did it remove entry 2? " + set1.remove(2));
        displaySet(set1);
        System.out.println();

        //create the second set
        System.out.println("Creating Set 2.");
        SetInterface<Integer> set2 = new ResizeableArraySet<>();
        int[] secondSet = {2, 4, 2, 5, 6, 4, 2, 3, 5, 6, 2, 4, 6, 2, 5};
        testAdd(set2, secondSet);
        System.out.println();

        //creating new set that combines set1 and set2
        System.out.println("Creating the union set of Set1 and Set2.");
        SetInterface<Integer> everything = set1.union(set2);
        displaySet(everything);
        System.out.println();

        //finding entries that are in set1 and set2
        System.out.println("Creating the intersection set of Set1 and Set2.");
        SetInterface<Integer> commonItems = set1.intersection(set2);
        displaySet(commonItems);
        System.out.println();

        //finding entries that are in set1 but not set2
        System.out.println("difference() of Set1 and Set2 (Set1 - Set2):");
        SetInterface<Integer> leftOver1 = set1.difference(set2);
        displaySet(leftOver1);
        //finding entries that are in set2 but not set1
        System.out.println("difference() of Set2 and Set1 (Set2 - Set1):");
        SetInterface<Integer> leftOver2 = set2.difference(set1);
        displaySet(leftOver2);
        System.out.println();

        //clear the set
        System.out.println("Testing clear() for all entries...");
        set1.clear();
        set2.clear();
        System.out.println("Is the set 1 empty? " + set1.isEmpty());
        System.out.println("Is the set 2 empty? " + set2.isEmpty());
    }

    //print provided entries, add to set without repeats
    public static void testAdd(SetInterface<Integer> set, int[] content){
        System.out.println("Populating the set...");
        for(int i = 0; i < content.length; i++){
            //implements the add method
            set.add((content[i]));
            System.out.print(content[i] + " ");
        } //end for loop

        System.out.println();
        displaySet(set); //print the current set
    }

    //method to print current set
    public static void displaySet(SetInterface<Integer> set){
        System.out.println("This set contains the number(s): ");
        Object[] setArray = set.toArray();
        for(int i = 0; i < setArray.length; i++){
            System.out.print(setArray[i] + " ");
        } //end for loop
        System.out.println();
    } //end displaySet
} //end ArraySetTest