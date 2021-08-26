package delicious.delicious.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import delicious.delicious.entities.RecipeEntity;

public interface RecipeRepo extends JpaRepository<RecipeEntity,Integer> {
    
}
