import java.security.Provider;

public class Main {
    public static void main(String[] args) {
        SearchTree list = new SearchTree(null);
        list.traverse(list.getRoot());
        String veryLongString = "2 5 3 6 7 9 8";
        String[] strings = veryLongString.split(" ");
        for (String s : strings) {
            list.addValue(new Node(s));
        }
        list.traverse(list.getRoot());
        list.removeValue(new Node("6"));
        list.traverse(list.getRoot());

    }
}