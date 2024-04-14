import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> ourBranches;

    public Bank(String name){
        this.name = name;
        this.ourBranches = new ArrayList<>();
    }

    public boolean addNewBranch(String branchName){
        if(findBranch(branchName) == null){
            ourBranches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public boolean addCustomerToBranch(String branchName, String newCustomerName, double initialTransaction){
        Branch branch = findBranch(branchName);
        if(branch!=null)
            return branch.addNewCustomer(newCustomerName, initialTransaction);

        return false;
    }

    public boolean addNewTransactionToCustomer(String branchName, String customerName, double transaction){
        Branch existingBranch = findBranch(branchName);
        if(existingBranch!=null)
            return existingBranch.addTransactionAmount(customerName, transaction);

        return false;
    }

    private Branch findBranch(String name){
        for (Branch branch : ourBranches) {
            if (branch.getName().equals(name))
                return branch;
        }
        return null;
    }

    public void printCustomers(String branchname, boolean printTransaction){
        Branch branch = findBranch(branchname);
        if(branch!=null) {
            System.out.println("Branch " + branch.getName() + ":");
            ArrayList<Customer> customers = branch.getOurCustomers();
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.println(customer.getName());
                if (printTransaction) {
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println(transactions.get(j));
                    }
                }
            }
        }
        else System.out.println("Ta galaz juz istnieje");
    }
}

