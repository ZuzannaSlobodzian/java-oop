import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static  void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Corole", 2021),
                new Employee(10022, "Jim", 2020)));
        var comparator = new Employee.EmployeeComparator<>("yearStarted");
        employees.sort(comparator);

//        for (Employee e : employees) {
//            System.out.println(e);
//        }

        List<StoreEmployee> store = new ArrayList<>(List.of(
                new StoreEmployee(10067, "Meg", 2019, "Target"),
                new StoreEmployee(10089, "Zoe", 2015, "Target"),
                new StoreEmployee(10099, "Alan", 2020, "Walmart"),
                new StoreEmployee(10087, "Caroline", 2017, "Target")));

        StoreEmployee objectStore = new StoreEmployee();
        var comparatorStore = objectStore.new StoreComparator<>();
        // var comparatorStore = new StoreEmployee().new StoreComparator<>();
        store.sort(comparatorStore);

//        for (StoreEmployee e : store) {
//            System.out.println(e);
//        }

        addPigName(store);
    }

        public static void addPigName(List<? extends StoreEmployee> list){

            String lastName = "Piggy";
            class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>{
                private String pigLatinName;
                private Employee originalInstance;

                public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                    this.pigLatinName = pigLatinName;
                    this.originalInstance = originalInstance;
                }

                 @Override
                public String toString(){
                    return originalInstance.toString() + " %13s ".formatted(pigLatinName) + "  " + lastName;
                 }

                @Override
                public int compareTo(DecoratedEmployee o) {
                    return this.pigLatinName.compareTo(o.pigLatinName);
                }

            }

            List<DecoratedEmployee> newList = new ArrayList<>(list.size());

            for(var employee : list){
                String name = employee.getName();
                String pigLatin = name.substring(1) + name.charAt(0) + "ay";
                newList.add(new DecoratedEmployee(pigLatin, employee));
            }

            //null or Comparator.naturalOrder()
            newList.sort(null);

            for(var dEmployee : newList){
                System.out.println(dEmployee.originalInstance.getName() + " " + dEmployee.pigLatinName);
            }

        }
    }