package Assignment4.Q2;
import Assignment4.Q2.enums.*;
import Assignment4.Q2.factories.impl.*;
import Assignment4.Q2.factories.MacronutrientFactory;
import Assignment4.Q2.model.Customer;
import Assignment4.Q2.model.Meal;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class MealPlanner {

    private final Random random;

    public MealPlanner() {
        this.random = new Random();
    }
    public Meal generateMealForCustomer(Customer customer) {
        DietPlan dietPlan = customer.getDietPlan();
        MacronutrientFactory factory = getFactoryForDiet(dietPlan);

        if (factory == null) {
            System.out.println("No suitable diet plan factory found for " + customer.getName());
            return null;
        }

        List<?> carbs = factory.createCarbs();
        List<?> protein = factory.createProtein();
        List<?> fats = factory.createFats();

        List<Carbs> selectedCarbList = Collections.singletonList((Carbs) getRandomItem(carbs));
        List<Protein> selectedProteinList = Collections.singletonList((Protein) getRandomItem(protein));
        List<Fats> selectedFatList = Collections.singletonList((Fats) getRandomItem(fats));

        return new Meal(selectedCarbList, selectedProteinList, selectedFatList);
    }

    private MacronutrientFactory getFactoryForDiet(DietPlan dietPlan) {
        switch (dietPlan) {
            case NO_RESTRICTION -> {
                return NoRestrictionFactory.getInstance();
            }
            case PALEO -> {
                return PaleoFactory.getInstance();
            }
            case VEGAN -> {
                return VeganFactory.getInstance();
            }
            case NUT_ALLERGY -> {
                return NutAllergyFactory.getInstance();
            }
            default -> {
                return null;
            }
        }
    }

    private Object getRandomItem(List<?> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }
    private void displayMeal(Customer customer, Meal meal) {
        if (meal != null) {
            System.out.println("Meal for " + customer.getName() + ":");
            System.out.println("    Meal type: "+ customer.getDietPlan());
            System.out.println("        Carbs: " + meal.getCarbs().getFirst());
            System.out.println("        Protein: " + meal.getProtein().getFirst());
            System.out.println("        Fats: " + meal.getFats().getFirst());
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Unable to generate a meal for " + customer.getName());
        }
        System.out.println();
    }

    public void generateAndDisplayMeal(Customer customer) {
        // Generate a meal for the customer
        Meal meal = this.generateMealForCustomer(customer);

        // Display the generated meal
        this.displayMeal(customer, meal);
    }
}