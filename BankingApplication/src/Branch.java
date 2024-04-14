import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> ourCustomers;

    public Branch(String name){
        this.name = name;
        this.ourCustomers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getOurCustomers() {
        return ourCustomers;
    }

    public boolean addNewCustomer(String newCustomerName, double initialTransaction){
        if(findCustomer(newCustomerName) == null){
            ourCustomers.add(new Customer(newCustomerName, initialTransaction));
            return true;
        }
        return false;
    }

    public boolean addTransactionAmount(String name, double amount){
        Customer existingCustomer = findCustomer(name);
        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String name){
        for (Customer customer : ourCustomers) {
            if (customer.getName().equals(name))
                return customer;
        }
        return null;
    }
}
