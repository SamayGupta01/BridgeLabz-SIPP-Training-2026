package oops.Generic;

interface MealPlan {
    String getPlanName();

    int getCalories();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Vegetarian Meal";
    }

    @Override
    public int getCalories() {
        return 1800;
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Vegan Meal";
    }

    @Override
    public int getCalories() {
        return 1700;
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Keto Meal";
    }

    @Override
    public int getCalories() {
        return 2100;
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "High-Protein Meal";
    }

    @Override
    public int getCalories() {
        return 2300;
    }
}

class Meal<T extends MealPlan> {
    private final T mealPlan;

    Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

public class PersonalizedMealPlanGenerator {
    public static <T extends MealPlan> void generatePlan(Meal<T> meal) {
        T plan = meal.getMealPlan();
        if (plan.getCalories() <= 0) {
            throw new IllegalArgumentException("Meal calories must be positive");
        }
        System.out.println("Generated plan: " + plan.getPlanName() + " | Calories: " + plan.getCalories());
    }

    public static void main(String[] args) {
        generatePlan(new Meal<>(new VegetarianMeal()));
        generatePlan(new Meal<>(new VeganMeal()));
        generatePlan(new Meal<>(new KetoMeal()));
        generatePlan(new Meal<>(new HighProteinMeal()));
    }
}
