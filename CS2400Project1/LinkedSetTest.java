package CS2400Project1;

public class LinkedSetTest {
    public static void main(String[] args){
        //create Set1 and check for empty (should return true)
        System.out.println("Creating an empty Linked Set...");
        SetInterface<Integer> set1 = new LinkedSet<>();
        System.out.println("Is Set1 empty? " + set1.isEmpty());

        //populate Set1 with fillSet entries (should return set without duplicates)
        int[] fillSet = {1, 2, 3, 4, 5, 2, 3, 1};
        testAdd(set1, fillSet);

        //check if set is empty (should return false) and check current size (should be 4)
        System.out.println("Is Set1 empty? " + set1.isEmpty());
        System.out.println("Current Set Size: " + set1.getCurrentSize());
        System.out.println();

        //check for 1 (true) and 7(false) in set
        System.out.println("Is 1 in the Set1? " + set1.contains(1));
        System.out.println("Is 7 in the Set1? " + set1.contains(7));
        System.out.println();

        //remove an entry
        System.out.println("Removing first entry...");
        set1.remove();
        displaySet(set1);
        //check if numOfEntries is decreased
        System.out.println("Current Set Size: " + set1.getCurrentSize());
        System.out.println();

        System.out.println("Removing 2 from Set1...");
        set1.remove(2);
        displaySet(set1);
        System.out.println();

        System.out.println("Creating Set 2.");
        SetInterface<Integer> set2 = new LinkedSet<>();
        int[] secondSet = {2, 4, 2, 5, 6, 4, 2, 7, 3, 5, 6, 2, 4, 6, 2, 5};
        testAdd(set2, secondSet);
        System.out.println();

        System.out.println("Creating the union set...");
        SetInterface<Integer> everything = set1.union(set2);
        displaySet(everything);
        System.out.println();

        //finding entries that are in set1 and set2
        System.out.println("Creating the intersection set...");
        SetInterface<Integer> commonItems = set1.intersection(set2);
        displaySet(commonItems);
        System.out.println();

        //finding entries that are in set1 but not set2
        System.out.println("Unique entries in Set 1 (Set1 - Set2):");
        SetInterface<Integer> leftOver1 = set1.difference(set2);
        displaySet(leftOver1);

        //finding entries that are in set2 but not set1
        System.out.println("Unique entries in Set 2 (Set2 - Set1):");
        SetInterface<Integer> leftOver2 = set2.difference(set1);
        displaySet(leftOver2);
        System.out.println();
    }

    public static void testAdd(SetInterface<Integer> set, int[] content){
        System.out.println("Populating the set...");
        for(int i = 0; i < content.length; i++){
            //implements the add method
            System.out.print(content[i] + " ");
            set.add((content[i]));
        } //end for loop

        System.out.println();
        displaySet(set); //print the current set
    }//end testAdd

    public static void displaySet(SetInterface<Integer> set){
        System.out.println("This set contains the items(s): ");
        Object[] setArray = set.toArray();
        for(int i = 0; i < setArray.length; i++){
            System.out.print(setArray[i] + " ");
        } //end for loop
        System.out.println();
    } //end displaySet
}
