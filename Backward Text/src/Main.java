//Main.java


public class Main {
    //required static method. can be placed in any class you wish, including List class itself.
    public static <E> List<E> reverseCopy(List<E> list) {
        //create a list to store reversed contents
        List<E> reversedList = new List<E>();
        //create a stack to store a backup of original list
        List<E> backupList = new List<E>();
        //loop until original list is empty
        while (!list.isEmpty()) {
            //remove front element from list
            E element = list.removeFromFront();
            //add to front of reversedList
            reversedList.insertAtFront(element);
            //and add to back of backupList
            backupList.insertAtBack(element);
        }
        //now we have reversedList with reversed contents, but the original list is destroyed in the
        //process. to restore it, we need to copy contents of backupList back to original list.

        //for that, loop as long as backupList is not empty
        while (!backupList.isEmpty()) {
            //remove front element from backupList and add to back of original list
            list.insertAtBack(backupList.removeFromFront());
        }

        //return reversed list
        return reversedList;
    }

    //code for testing
    public static void main(String[] args) {
        //create an integer list
        List<Integer> list = new List<Integer>();
        //add 10 RANDOM integers between 0 and 100 to the list
        for (int i = 0; i < 10; i++) {
            list.insertAtBack((int) Math.round(Math.random() * 100));
        }
        //display list, display reverse of the list and display original list again
        System.out.println("Original list:");
        list.print();
        System.out.println("Reversed list:");
        reverseCopy(list).print();
        System.out.println("Original list:");
        list.print();
    }
}