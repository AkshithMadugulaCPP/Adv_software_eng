package Assignment4.Q2.factories.impl;

import Assignment4.Q2.enums.*;
import Assignment4.Q2.factories.MacronutrientFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PaleoFactory implements MacronutrientFactory {
    private static final PaleoFactory instance = new PaleoFactory();

    private PaleoFactory() {}

    public static PaleoFactory getInstance() {
        return instance;
    }

    @Override
    public List<Carbs> createCarbs() {
        // Paleo diet restricts carbs to only Pistachio
        return Collections.singletonList(Carbs.PISTACHIO);
    }

    @Override
    public List<Protein> createProtein() {
        // Paleo diet allows all protein sources except Tofu
        List<Protein> allowedProteins = new ArrayList<>(Arrays.asList(Protein.values()));
        allowedProteins.remove(Protein.TOFU);
        return Collections.unmodifiableList(allowedProteins);
    }

    @Override
    public List<Fats> createFats() {
        // Paleo diet allow all fats except Sour Cream
        List<Fats> allowedFats = new ArrayList<>(Arrays.asList(Fats.values()));
        allowedFats.remove(Fats.SOUR_CREAM);
        return Collections.unmodifiableList(allowedFats);
    }
}
