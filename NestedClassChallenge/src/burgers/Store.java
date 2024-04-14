package burgers;

public class Store {
    public static void main(String[] args) {
        Meal reguralMeal = new Meal();
        reguralMeal.addTop("Mayo", "Pickles");
        System.out.println(reguralMeal);
        System.out.println();
        System.out.println(new Meal(0.68));
    }
}
