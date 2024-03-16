package Assignment4.Q2.factories;

import Assignment4.Q2.enums.*;
import java.util.List;

public interface MacronutrientFactory {
    List<Carbs> createCarbs();
    List<Protein> createProtein();
    List<Fats> createFats();
}
