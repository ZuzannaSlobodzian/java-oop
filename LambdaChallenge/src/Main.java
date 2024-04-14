import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static Random random = new Random();
    public static void main(String[] args) {

        String[] names = {"Anna", "Chloe", "amanda", "Bob", "thomas", "lidia"};
        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println(Arrays.asList(names));

        List<String> names2 = Arrays.asList(names);
        names2.forEach( i -> System.out.println(i));

        Arrays.setAll(names, i -> names[i] + " " + reverseIt(names[i]));
        //Tim's version
        // i -> i += ReverseIt(i.split(" ").[0])

        Arrays.asList(names).forEach(i -> System.out.println(i));

        List<String> lastList = new ArrayList<>(List.of(names));

        lastList.removeIf(i -> {
            String[] firstNotLast = i.split(" ");
            return firstNotLast[0].equalsIgnoreCase(firstNotLast[1]);
        }
        );
        Arrays.asList(names).forEach(i -> System.out.println(i));

    }

    public static char getRandomChar(char setChar, char endChar){
        return (char) random.nextInt((int)setChar, (int)endChar + 1);
    }

    public static String reverseIt(String name){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < name.length(); i++){
            builder.append(name.charAt(name.length() - i - 1));
        }
        return builder.toString();
        //Tim's version
        //return new StringBuilder(name).reverse().toString();
    }

}