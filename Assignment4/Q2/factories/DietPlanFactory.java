package Assignment4.Q2.factories;
import Assignment4.Q2.enums.DietPlan;
import Assignment4.Q2.factories.impl.*;

public class DietPlanFactory {
    private static final DietPlanFactory instance = new DietPlanFactory();

    private DietPlanFactory() {}

    public static DietPlanFactory getInstance() {
        return instance;
    }

    public MacronutrientFactory getFactory(DietPlan dietPlan) {
        switch (dietPlan) {
            case NO_RESTRICTION:
                return NoRestrictionFactory.getInstance();
            case PALEO:
                return PaleoFactory.getInstance();
            case VEGAN:
                return VeganFactory.getInstance();
            case NUT_ALLERGY:
                return NutAllergyFactory.getInstance();
            default:
                throw new IllegalArgumentException("Invalid diet plan: " + dietPlan);
        }
    }
}
