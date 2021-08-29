package delicious.delicious.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import delicious.delicious.entities.RecipeEntity;

public interface RecipeRepo extends JpaRepository<RecipeEntity,Integer> {
    Optional <RecipeEntity>findBytype (String type);
}
