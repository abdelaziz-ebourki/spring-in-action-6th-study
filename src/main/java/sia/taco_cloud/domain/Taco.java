package sia.taco_cloud.domain;

import java.util.List;

import lombok.Data;

@Data
public class Taco {
    String name;
    List<Ingredient> ingredients;
}
