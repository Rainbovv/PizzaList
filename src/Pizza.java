import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private List<String> ingredients;

    public Pizza() {

        this.ingredients = new ArrayList<>();
        ingredients.add("dough");
        ingredients.add("salt");
        ingredients.add("oil");
    }

    public Pizza(String dough, String salt, String oil) {

        this();
        setDough(dough);
        setSalt(salt);
        setOil(oil);
    }

    public Boolean isComplete() {

        return (ingredients.size() > 3 && checkDoughType(ingredients.get(0)) &&
                checkSaltType(ingredients.get(1)) && checkOilType(ingredients.get(2)));
    }

    // CHAINING METHODS
    public Pizza with(String ingredient) {

        if (!checkIfContains(ingredient)) {
            ingredients.add(ingredient);
        }
        else
            System.err.println("Pizza already contains this ingredient: " + ingredient);

        return this;
    }

    public Pizza without(String ingredient) {

        if (ingredients.indexOf(ingredient) < 3 && ingredients.indexOf(ingredient) >= 0)
            System.err.println("We can not remove default ingredients.");

        else if (!checkIfContains(ingredient))
            System.err.println("Pizza does not contain this ingredient: " + ingredient);

        else
            ingredients.remove(ingredient);

        return this;
    }

    public String toString() {

        if (isComplete())
            return String.format("%nPizza with %s dough, %s salt and %s oil.%nToppings " +
                                 ingredients.subList(3,ingredients.size()),
                                 ingredients.get(0), ingredients.get(1), ingredients.get(2));

        return "Pizza is not complete!";
    }

    private void setDough(String dough) {

        if (checkDoughType(dough)) {
            ingredients.set(0, dough);
        }
        else
            System.err.println("Unfortunately, we do not have such dough!");
    }

    private void setSalt(String salt) {

        if (checkSaltType(salt))
            ingredients.set(1,salt);

        else
            System.err.println("Unfortunately, we do not have such salt!");
    }

    private void setOil(String oil) {

        if (checkOilType(oil))
            ingredients.set(2,oil);

        else
            System.err.println("Unfortunately, we do not have such oil!");
    }

    private boolean checkIfContains(String ingredient) {

        return ingredients.contains(ingredient);
    }

    private boolean checkDoughType(String dough) {
        return "thick".equals(dough) || "thin".equals(dough);
    }

    private boolean checkSaltType(String salt) {
        return "iodized".equals(salt) || "halite".equals(salt);
    }

    private boolean checkOilType(String oil) {
        return "sunflower".equals(oil) || "olive".equals(oil);
    }
}
