import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static MobilePhone phone = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        while (!quit) {
            System.out.println("Co chcesz osiagnac?");
            String quest = scanner.nextLine();

            switch (quest) {
                case "print":
                    phone.printContact();
                    break;
                case "add":
                    add();
                    break;
                case "modify":
                    modify();
                    break;
                case "remove":
                    remove();
                    break;
                case "query":
                    query();
                    break;
                case "end":
                    quit = true;
                    System.out.println("Zamykam processshihi");
                    break;
                default:
                    System.out.println("Zle wprowadzone zadanie");
            }
        }
        scanner.close();
    }
    private static void startPhone(){
        System.out.println("Otwarte, zapraszamy do zmiany");
    }

    private static void add(){
        System.out.println("Podaj nazwę: ");
        String name = scanner.nextLine();
        System.out.println("Podaj numer: ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if(!phone.addNewContact(newContact)){
            System.out.println("Ten kontakt juz istnieje");
        }
    }

    private static void modify(){
        System.out.println("Podaj konntakt do zmiany: ");
        String oldContactName = scanner.nextLine();
        Contact oldContact = phone.queryContact(oldContactName);
        if(oldContact==null){
            System.out.println("Nie ma tego kontaktu");
            return;
        }
        System.out.println("Podaj nowy kontakt: ");
        String newContactName = scanner.nextLine();
        if(phone.isRepeated(newContactName)) {
            System.out.println("Ten kontakt juz istnieje");
            return;
        }
        System.out.println("Podaj nowy numer: ");
        String newContactNumber = scanner.nextLine();
        if(phone.isRepeated(newContactNumber)) {
            System.out.println("Ta nazwa juz istnieje");
            return;
        }

        Contact newContact = Contact.createContact(newContactName, newContactNumber);
        phone.modifyContact(oldContact, newContact);
    }

    private static void remove(){
        System.out.println("Podaj kontakt ktory chcesz usunac: ");
        String badName = scanner.nextLine();
        Contact badContact = phone.queryContact(badName);
        if(badContact==null){
            System.out.println("Nie ma tego kontaktu");
            return;
        }
        phone.removeContact(badContact);
    }

    private static void query(){
        System.out.println("Podaj nazwę kontaktu: ");
        String name = scanner.nextLine();
        Contact contact = phone.queryContact(name);
        if(contact==null){
            System.out.println("Nie ma tego kontaktu");
            return;
        }
        System.out.println("Kontakt: " + contact.getName() + " numer: " + contact.getNumber());
    }
}
