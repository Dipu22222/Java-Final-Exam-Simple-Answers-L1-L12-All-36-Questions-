import java.util.ArrayList;
import java.util.TreeSet;

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Rakib");
        nameList.add("Karim");
        nameList.add("Anika");
        nameList.add("Zayan");
        nameList.add("Bithi");

        System.out.print("ArrayList (insertion order): ");
        for (String name : nameList) {
            System.out.print(name + " ");
        }
        System.out.println();

        TreeSet<String> nameSet = new TreeSet<>(nameList);
        System.out.print("TreeSet (sorted order): ");
        for (String name : nameSet) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}
