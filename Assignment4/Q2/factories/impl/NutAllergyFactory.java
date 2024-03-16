package Assignment4.Q2.factories.impl;
import Assignment4.Q2.enums.*;
import Assignment4.Q2.factories.MacronutrientFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NutAllergyFactory implements MacronutrientFactory {
    private static final NutAllergyFactory instance = new NutAllergyFactory();

    private NutAllergyFactory() {}

    public static NutAllergyFactory getInstance() {
        return instance;
    }

    @Override
    public List<Carbs> createCarbs() {
        // Exclude nuts (Pistachio) from carbs
        List<Carbs> allowedCarbs = new ArrayList<>(Arrays.asList(Carbs.values()));
        allowedCarbs.remove(Carbs.PISTACHIO);
        return Collections.unmodifiableList(allowedCarbs);
    }

    @Override
    public List<Protein> createProtein() {
        // Protein choices are unaffected by nut allergies in this context
        return new ArrayList<>(Arrays.asList(Protein.values()));
    }

    @Override
    public List<Fats> createFats() {
        // Exclude nuts (Peanuts) from fats
        List<Fats> allowedFats = new ArrayList<>(Arrays.asList(Fats.values()));
        allowedFats.remove(Fats.PEANUTS);
        return Collections.unmodifiableList(allowedFats);
    }
}
