import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

//zrobić odwrotnie nie statyczne metody
public class Main {
    public static void main(String[] args) {
        LinkedList<String> townsToVisit = new LinkedList<>();

        addTown(townsToVisit,"Krakow");
        addTown(townsToVisit,"Poznan");
        addTown(townsToVisit,"Warszawa");
        addTown(townsToVisit,"Gdansk");
        addTown(townsToVisit,"Wroclaw");
        addTown(townsToVisit,"Lodz");
        printTowns(townsToVisit);
        visitTown(townsToVisit);
    }

    public static boolean addTown( LinkedList<String> places,String newPlace){
        ListIterator<String> i = places.listIterator();

        while(i.hasNext()){
            int comprasion = i.next().compareTo(newPlace);
            if(comprasion == 0){
                System.out.println("Element juz istnieje");
                return false;
            }
            else if (comprasion>0) {
                i.previous();
                i.add(newPlace);
                return true;
            }
            else{
                continue;
            }
        }

        i.add(newPlace);
        return true;
    }

    public static void visitTown(LinkedList<String> places){
        ListIterator<String> i = places.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        if(places.isEmpty())
            System.out.println("nie ma zadnych miast");

        while (!quit){
            int option = scanner.nextInt();
            switch(option){
                case 1:
                    if(!goingForward) {
                        if (i.hasNext())
                            i.next();
                        goingForward = true;
                    }
                    if(i.hasNext())
                        System.out.println(i.next());
                    else {
                        System.out.println("Koniec listy");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if (i.hasPrevious())
                            i.previous();
                        goingForward = false;
                    }
                    if(i.hasPrevious())
                        System.out.println(i.previous());
                    else {
                        System.out.println("Koniec listy");
                        goingForward = true;
                    }
                    break;
                case 0:
                    quit = true;
                    break;
            }
        }
    }

    public static void printTowns(LinkedList<String> places){
        Iterator<String> i = places.listIterator();

        while(i.hasNext()){
            System.out.println(i.next());
        }

    }
}