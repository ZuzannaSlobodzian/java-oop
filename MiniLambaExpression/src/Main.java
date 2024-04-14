import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Consumer<String> lambdaTrial = sentence -> {
           String[] parts = sentence.split(" ");
           for (String part : parts){
               System.out.println(part);
           }
        };
        lambdaTrial.accept("ala ma kota");

        Consumer<String> lambdaTrialLambda = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };
        lambdaTrialLambda.accept("ala ma kota");

        Consumer<String> lambdaTrialConcise = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };
        lambdaTrialConcise.accept("ala ma kota");

        Function<String, String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("1234567890"));

        System.out.println(everySecondCharacter(everySecondChar, "1234567890"));

        Supplier<String> iLoveJava = () -> "I love Java";


        String supplierResults = iLoveJava.get();
        System.out.println(supplierResults);

    }
    public static String everySecondCharacter( Function<String, String> func, String source){
        return func.apply(source);
    }

}