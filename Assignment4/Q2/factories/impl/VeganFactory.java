package Assignment4.Q2.factories.impl;
import Assignment4.Q2.enums.*;
import Assignment4.Q2.factories.MacronutrientFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VeganFactory implements MacronutrientFactory {
    private static final VeganFactory instance = new VeganFactory();

    private VeganFactory() {}

    public static VeganFactory getInstance() {
        return instance;
    }

    @Override
    public List<Carbs> createCarbs() {
        // Vegan diet all carbs except cheese
        List<Carbs> allowedCarbs = new ArrayList<>(Arrays.asList(Carbs.values()));
        allowedCarbs.remove(Carbs.CHEESE);
        return Collections.unmodifiableList(allowedCarbs);
    }

    @Override
    public List<Protein> createProtein() {
        // Vegan diet excludes Fish, Chicken, Beef, and Tuna
        List<Protein> allowedProteins = new ArrayList<>(Arrays.asList(Protein.values()));
        allowedProteins.removeAll(Arrays.asList(Protein.FISH, Protein.CHICKEN));
        return Collections.unmodifiableList(allowedProteins);
    }

    @Override
    public List<Fats> createFats() {
        // Vegan diet excludes Sour cream and Tuna
        List<Fats> allowedFats = new ArrayList<>(Arrays.asList(Fats.values()));
        allowedFats.removeAll(Arrays.asList(Fats.SOUR_CREAM, Fats.TUNA));
        return Collections.unmodifiableList(allowedFats);
    }
}
