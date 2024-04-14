
import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    public static Random random = new Random();
    public static void main(String[] args) {

        String[] names = {"Anna", "Chloe", "Amanda", "Bob", "Thomas", "Lidia"};

        List<UnaryOperator<String>> interfaces = new ArrayList<>(List.of(String::toUpperCase, Main::getRandomChar, Main::reverseIt));
        //applyIt(names, interfaces);

        UnaryOperator<String> case1 = String::toUpperCase;

        UnaryOperator<String> case2 = name -> {
            char letter = (char) random.nextInt((int)'A', (int)'Z' + 1);
            return  name + " " + letter + ".";
        };

        UnaryOperator<String> case3 = name -> {
            String lastname = new StringBuilder(name.substring(0, name.length() - 3)).reverse().toString();
            return name + " " + lastname;
        };

        //Function<String, String> mergeAll = case1.andThen(case2).andThen(case3);
        //Arrays.asList(names).forEach(s -> System.out.println(mergeAll.apply(s)));

        Arrays.asList(names).forEach(s -> System.out.println(case1.andThen(case2).andThen(case3).apply(s)));

    }

    public static String getRandomChar(String name){
        char letter = (char) random.nextInt((int)'A', (int)'Z' + 1);
        return  name + " " + letter + ".";
    }

    public static String reverseIt(String name){
        //name.substring(0, name.indexOf(" ")))
        String lastname = new StringBuilder(name.substring(0, name.length()-3)).reverse().toString();
        return name + " " + lastname;
    }

    public static void applyIt(String[] names, List<UnaryOperator<String>> methodList){

        List<String> list = Arrays.asList(names);
        for (var function : methodList){
            list.replaceAll(s -> s.transform(function));
        }

        System.out.println(list);
    }
}