package sia.taco_cloud.repository;

import java.util.Optional;

import sia.taco_cloud.domain.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findOne(String id);

    Ingredient save(Ingredient ingredient);
}
