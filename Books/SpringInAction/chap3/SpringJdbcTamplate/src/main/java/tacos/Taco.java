package tacos;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private Long id;

    private Date createdAt = new Date();

    private String name;

    private List<IngredientRef> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient taco) {
        this.ingredients.add(new IngredientRef(taco.getId()));
    }


}
