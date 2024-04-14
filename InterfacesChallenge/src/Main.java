import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ISaveable playerOne = new Player("Zuzka", 12);
        System.out.println(playerOne);
        savedObject(playerOne);
        ((Player) playerOne).setWeapon("axe");
        savedObject(playerOne);
        System.out.println(playerOne);
        loadObject(playerOne);
        System.out.println(playerOne);

        ISaveable monsterOne = new Monster("Bad", 12,3);
        savedObject(monsterOne);
        System.out.println(monsterOne);


    }

    public static ArrayList<String> readValues () {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void savedObject(ISaveable object){
        for(int i = 0; i<object.write().size(); i++){
            System.out.println("Zachowywane"+object.write().get(i));
        }
    }

    public static void loadObject(ISaveable object){
        ArrayList<String> values = readValues();
        object.read(values);

    }

}