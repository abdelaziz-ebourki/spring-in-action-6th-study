package sia.taco_cloud.domain;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    List<Ingredient> ingredients;
}
