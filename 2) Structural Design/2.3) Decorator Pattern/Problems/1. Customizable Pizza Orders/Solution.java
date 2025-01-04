
interface Pizza {

    double getPrice();

    String getDescription();
}

interface Toppings extends Pizza {
    // Can have any other new methods
}

class MargheritaPizza implements Pizza {

    @Override
    public double getPrice() {
        return 120.8;
    }

    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

}

class PepperoniPizza implements Pizza {

    @Override
    public double getPrice() {
        return 98.3;
    }

    @Override
    public String getDescription() {
        return "Pepperoni Pizza";
    }
}

class VeggiePizza implements Pizza {

    @Override
    public double getPrice() {
        return 67.5;
    }

    @Override
    public String getDescription() {
        return "Veggie Pizza";
    }
}

class Cheese implements Toppings {

    private Pizza pizza;

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return 25.25 + this.pizza.getPrice();
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + ", Cheese";
    }
}

class Olives implements Toppings {

    private Pizza pizza;

    public Olives(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return 11.3 + this.pizza.getPrice();
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + ", Olives";
    }
}

class Mushrooms implements Toppings {

    private Pizza pizza;

    public Mushrooms(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return 39.1 + this.pizza.getPrice();
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + ", Mushrooms";
    }
}

class ExtraSauce implements Toppings {

    private Pizza pizza;

    public ExtraSauce(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return 5.5 + this.pizza.getPrice();
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + ", Extra Sauce";
    }
}

public class Solution {

    private static void printBill(Pizza pizza) {
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: Rs." + String.format("%.2f", pizza.getPrice()));
    }

    public static void main(String[] args) {

        Pizza margheritaPizza = new MargheritaPizza();
        margheritaPizza = new Cheese(margheritaPizza);
        margheritaPizza = new Olives(margheritaPizza);
        printBill(margheritaPizza);

        Pizza pepperoniPizza = new PepperoniPizza();
        pepperoniPizza = new Mushrooms(pepperoniPizza);
        pepperoniPizza = new ExtraSauce(pepperoniPizza);
        printBill(pepperoniPizza);
    }
}
