package CS2400Project1;

public class LinkedSetTest {
    public static void main(String[] args){
        //create Set1 and check for empty (should return true)
        System.out.println("Creating an empty Linked Set, Set1");
        SetInterface<String> set1 = new LinkedSet<>();
        System.out.println("Testing isEmpty(), Is Set1 empty? " + set1.isEmpty());

        //populate Set1 with fillSet entries (should return set without duplicates)
        String[] fillSet = {"A", "B", "C", "D", "E", "B", "C", "A"};
        testAdd(set1, fillSet);

        //check if set is empty (should return false) and check current size (should be 4)
        System.out.println("Is Set1 empty? " + set1.isEmpty());
        System.out.println("Testing getCurrentSize(), Current Set Size: " + set1.getCurrentSize());
        System.out.println();

        //check for 1 (true) and 7(false) in set
        System.out.println("Testing contains()");
        System.out.println("Is A in the Set1? " + set1.contains("A"));
        System.out.println("Is M in the Set1? " + set1.contains("M"));
        System.out.println();

        //remove an entry
        System.out.println("remove() removes: " + set1.remove());
        displaySet(set1);
        System.out.println();

        //find 2 and remove from Set1
        System.out.println("Testing remove(B), was B removed? " + set1.remove("B"));
        displaySet(set1);
        System.out.println();

        //create the comparison set and fill it
        System.out.println("Creating Set 2.");
        SetInterface<String> set2 = new LinkedSet<>();
        String[] secondSet = {"B", "D", "B", "E", "F", "D", "B", "F", "C", "E", "F", "B", "D", "F", "B", "E"};
        testAdd(set2, secondSet);
        System.out.println();

        //create another set that combines the nodes in set1 and set2
        System.out.println("Creating the union set of Set1 and Set2.");
        SetInterface<String> everything = set1.union(set2);
        displaySet(everything);
        System.out.println();

        //finding entries that are in set1 and set2
        System.out.println("Creating the intersection set of Set1 and Set2.");
        SetInterface<String> commonItems = set1.intersection(set2);
        displaySet(commonItems);
        System.out.println();

        //finding entries that are in set1 but not set2
        System.out.println("difference() of Set1 and Set2 (Set1 - Set2):");
        SetInterface<String> leftOver1 = set1.difference(set2);
        displaySet(leftOver1);

        //finding entries that are in set2 but not set1
        System.out.println("difference() of Set2 and Set1 (Set2 - Set1):");
        SetInterface<String> leftOver2 = set2.difference(set1);
        displaySet(leftOver2);
        System.out.println();

        //clear the set
        System.out.println("Testing clear() for all entries...");
        set1.clear();
        set2.clear();
        System.out.println("Is the Set1 empty? " + set1.isEmpty());
        System.out.println("Is the Set2 empty? " + set2.isEmpty());
    }//end main

    public static void testAdd(SetInterface<String> set, String[] content){
        System.out.println("Populating the set...");
        for(int i = 0; i < content.length; i++){
            //implements the add method
            System.out.print(content[i] + " ");
            set.add((content[i]));
        } //end for loop

        System.out.println();
        displaySet(set); //print the current set
    }//end testAdd

    public static void displaySet(SetInterface<String> set){
        System.out.println("This set contains the letter(s): ");
        Object[] setArray = set.toArray();
        for(int i = 0; i < setArray.length; i++){
            System.out.print(setArray[i] + " ");
        } //end for loop
        System.out.println();
    } //end displaySet
}
