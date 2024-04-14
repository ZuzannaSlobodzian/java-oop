import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class RunMethods {

    public static void main(String[] args) {
        List<StoreEmployee> store = new ArrayList<>(List.of(
                new StoreEmployee(10067, "Meg", 2019, "Target"),
                new StoreEmployee(10089, "Zoe", 2015, "Target"),
                new StoreEmployee(10099, "Alan", 2020, "Walmart"),
                new StoreEmployee(10087, "Caroline", 2017, "Target")));

        class NameSort<T> implements Comparator<StoreEmployee>{

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>();
        var c3 = new NameSort<StoreEmployee>();
        var c4 = new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortIt(store, c1);
        sortIt(store, c2);
        sortIt(store, c3);
        sortIt(store, c4);
        sortIt(store, new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
        );


    }

    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator){
        System.out.println("Comparator:" + comparator.toString());
        list.sort(comparator);
        for (var employee : list){
            System.out.println(employee);
        }
    }

}
