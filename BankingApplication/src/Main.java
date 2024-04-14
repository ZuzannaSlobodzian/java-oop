import java.util.Scanner;

public class Main {
    static Bank bank = new Bank("Get out");

    public static void main(String[] args) {
        bank.addNewBranch("Individual");
        bank.addNewBranch("Business");
        bank.addCustomerToBranch("Individual", "Tim", 567.90);
        bank.printCustomers("Individual", true);
        bank.addCustomerToBranch("Individual", "Joline", 53.67);
        bank.addNewTransactionToCustomer("Individual", "Joline", 678);
        bank.printCustomers("Individual", true);
        bank.addNewTransactionToCustomer("Individual", "Tim", 2234.76);
        bank.printCustomers("Individual", true);
    }

//    static private Scanner scanner = new Scanner(System.in);
//    static Bank bank = new Bank("Get out");
//    public static void main(String[] args) {
//        System.out.println("Witaj w centrum kontrolowania swiata");
//        boolean quit = false;
//        while(!quit){
//            System.out.println("Co chcesz zrobic");
//            String quest = scanner.nextLine();
//            switch(quest){
//                case "add branch":
//                    addBranch();
//                    break;
//                case "add customer":
//                    addCustomer();
//                    break;
//                case "add transaction":
//                    addTransaction();
//                    break;
//                case "print customers":
//                    print();
//                    break;
//                case "quit":
//                    quit = true;
//                    System.out.println("Wychodzimy z banku");
//                default:
//                    System.out.println("Zle wprowadzona komeda");
//            }
//        }
//        scanner.close();
//    }
//    private static void addBranch(){
//        System.out.println("Podaj nazwę nowej galezi:");
//        String name = scanner.nextLine();
//        if(!bank.addNewBranch(name))
//            System.out.println("Ta galaz juz istnieje");
//    }
//
//    private static void addCustomer(){
//        System.out.println("Podaj nazwe galezi");
//        String branchName = scanner.nextLine();
//        System.out.println("Podaj nazwe klienta");
//        String customerName = scanner.nextLine();
//        System.out.println("Podaj wartosc transcakcji poczatkowej");
//        double transaction = scanner.nextDouble();
//
//        if(!bank.addCustomerToBranch(branchName, customerName, transaction))
//            System.out.println("Ten klient juz istnieje");
//    }
//
//    private static void addTransaction(){
//        System.out.println("Podaj nazwe galezi");
//        String branchName = scanner.nextLine();
//        System.out.println("Podaj nazwe klienta");
//        String customerName = scanner.nextLine();
//        System.out.println("Podaj wartosc transcakcji");
//        double transaction = scanner.nextDouble();
//
//        if(!bank.addNewTransactionToCustomer(branchName, customerName, transaction))
//            System.out.println("Ten klient lub galaz nie istnieje");
//    }
//
//    private static void print(){
//        System.out.println("Podaj nazwe galezi");
//        String branchName = scanner.nextLine();
//        System.out.println("Czy chcesz wyswitlic transakcje?");
//        boolean printTransactions = scanner.nextBoolean();
//        bank.printCustomers(branchName, printTransactions);
//    }


}