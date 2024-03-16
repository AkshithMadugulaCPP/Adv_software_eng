package Assignment4.Q2.factories.impl;

import Assignment4.Q2.enums.*;
import Assignment4.Q2.factories.MacronutrientFactory;

import java.util.List;

public class NoRestrictionFactory implements MacronutrientFactory {
    private static final NoRestrictionFactory instance = new NoRestrictionFactory();

    private NoRestrictionFactory() {}

    public static NoRestrictionFactory getInstance() {
        return instance;
    }

    @Override
    public List<Carbs> createCarbs() {
        return List.of(Carbs.values());
    }

    @Override
    public List<Protein> createProtein() {
        return List.of(Protein.values());
    }

    @Override
    public List<Fats> createFats() {
        return List.of(Fats.values());
    }
}
