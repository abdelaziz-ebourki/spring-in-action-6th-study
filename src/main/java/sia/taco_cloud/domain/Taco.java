package sia.taco_cloud.domain;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {
    private Long id;

    @NotNull
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, max = 50, message = "Name must be at least 5 characters long and less than 50")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<IngredientRef> ingredients;
}
