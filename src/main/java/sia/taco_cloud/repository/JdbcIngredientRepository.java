package sia.taco_cloud.repository;

import java.lang.foreign.Linker.Option;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sia.taco_cloud.domain.Ingredient;
import sia.taco_cloud.domain.IngredientType;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        String query = "select id, name, type from Ingredient";
        return jdbcTemplate.query(query, this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findOne(String id) {
        String query = "select id, name, type from Ingredient where id = ?";
        return jdbcTemplate.query(query, this::mapRowToIngredient, id)
                .stream()
                .findFirst();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        String query = "insert into Ingredient (id, name, type) values (?, ?, ?)";
        jdbcTemplate.update(query, ingredient.getId(), ingredient.getName(), ingredient.getType());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum)
            throws SQLException {
        return new Ingredient(rs.getString("id"),
                rs.getString("name"),
                IngredientType.valueOf(rs.getString("type")));
    }
}
