package burgers;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;
    private double conversionRate;

    public Meal(){
        this(1);
    }

    public Meal(double conversionRate){
        this.conversionRate = conversionRate;
        burger = new Burger("regural");
        drink = new Item("coke", "drink", 1.5);
        side = new Item("fires", "side", 2.0 );
    }

    public double getTotal(){
        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%19s$%.2f".formatted(burger, drink, side, "Total Due ", getTotal());
    }

    public void addTop(String... selectedToppings){
        burger.addToppings(selectedToppings);
    }
    private class Item {
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%8s%10s $%.2f".formatted(type, name, getPrice(price, conversionRate));
        }

        private static double getPrice(double price, double rate){
            return price * rate;
        }
    }

    private class Burger extends Item{

        private enum Extra {AVOKADO, CHEESE, MAYO, MUSTARD, PICKLES;

            private double getPrice(){
                return switch(this){
                    case AVOKADO -> 1.5;
                    case CHEESE -> 2.0;
                    case PICKLES -> 1.0;
                    default -> 0.0;
                };
            }}
        private List<Item> toppings = new ArrayList<>();

        Burger(String name) {
            super(name, "Burger", 5.0);
        }

        public double getPrice(){
            double total = super.price;
            for(Item topping : toppings){
                total += topping.price;
            }
            return total;
        }

        private void addToppings(String... listOFToppings){
            for (String top : listOFToppings) {
                try{
                Extra toppings = Extra.valueOf(top.toUpperCase());
                this.toppings.add(new Item(toppings.name(), "TOPPINGS", toppings.getPrice()));
            } catch (IllegalArgumentException ie){
                    System.out.println("No toppings found for " + top);
                }
            }

        }

        @Override
        public String toString() {
          StringBuilder itemized = new StringBuilder(super.toString());
          for(Item topping : toppings){
              itemized.append("\n");
              itemized.append(topping);
          }
          return itemized.toString().toLowerCase();
        }
    }
}
