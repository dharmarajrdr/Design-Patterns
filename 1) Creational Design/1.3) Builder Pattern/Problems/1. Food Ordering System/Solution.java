
class Meal {

    private String mainCourse;
    private String sideDish;
    private String drink;
    private String dessert;

    // Private constructor to enforce usage of Builder
    private Meal(Builder builder) {
        this.mainCourse = builder.mainCourse;
        this.sideDish = builder.sideDish;
        this.drink = builder.drink;
        this.dessert = builder.dessert;
    }

    @Override
    public String toString() {
        return "MainCourse: " + mainCourse + ", SideDish: " + sideDish + ", Drink: " + drink + ", Dessert: " + dessert;
    }

    // Static inner Builder class
    public static class Builder {

        private String mainCourse;
        private String sideDish;
        private String drink;
        private String dessert;

        public Builder setMainCourse(String mainCourse) {
            this.mainCourse = mainCourse;
            return this;
        }

        public Builder setSideDish(String sideDish) {
            this.sideDish = sideDish;
            return this;
        }

        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Builder setDessert(String dessert) {
            this.dessert = dessert;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }
    }
}

public class Solution {

    public static void main(String[] args) {

        Meal meal = new Meal.Builder() // new OuterClass.InnerClass()
                .setMainCourse("Briyani")
                .setDrink("Elaneer Payasam")
                .setDessert("Ice cream")
                .build();

        System.out.println(meal);
    }
}
