import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Employee(String firstName, String lastName, String hireDate){
    @Override
    public String toString() {
        return firstName + "   " + lastName + "   " + hireDate;
    }
};
public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(new Employee("Tim", "Buchalka", "23/05/2023"),
                new Employee("Zoe", "Jaa", "20/09/2015"),
                new Employee("Sandra", "Sai", "11/12/2017"),
                new Employee("Zaryk", "Sande", "05/08/2020")));

        doEmployee(employees, "year");
        doEmployee(employees, "adfg");


    }

    public static void doEmployee(List<Employee> list, String sortedType){

        int currentYear = LocalDate.now().getYear();

        class Locally{
            private String fullName;
            private int yearsWorked;
            private Employee myEmployee;

            @Override
            public String toString() {
                return "%d %14s %15s".formatted(yearsWorked, fullName, myEmployee.hireDate());
            }

            public Locally(Employee myEmployee) {
                this.myEmployee = myEmployee;
                this.yearsWorked = currentYear - Integer.valueOf(myEmployee.hireDate().split("/")[2]);
                // = String.join(" ", myEmployee.firstName(), myEmployee.lastName());
                this.fullName = myEmployee.firstName() + " " + myEmployee.lastName();

            }
        }

        List<Locally> betterEmployees = new ArrayList<>();
        for(Employee e : list){
            betterEmployees.add(new Locally(e));
        }

        var comparator = new Comparator<Locally>(){

            @Override
            public int compare(Locally o1, Locally o2) {
                if(sortedType.equalsIgnoreCase("year")){
                    return Integer.valueOf(o1.yearsWorked).compareTo(o2.yearsWorked);
                }
                return o1.fullName.compareTo(o2.fullName);
            }
        };

        betterEmployees.sort(comparator);

        if(sortedType.equalsIgnoreCase("year"))
            System.out.println("Sorted by worked years");
        else
            System.out.println("Sorted by name");

        for (Locally e : betterEmployees){
            System.out.println(e);
        }
    }

}