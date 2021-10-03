package delicious.delicious.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import delicious.delicious.entities.RecipeEntity;
import delicious.delicious.entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer>{
    

    Optional<UserEntity> findByEmail(String email);
    // List<RecipeEntity> findByIdwithFavRecipeEntities(Integer id);
    // @Query(value = "select u.name as name,c.college_name as college_name from users u inner join college c ON u.college_id = c.id GROUP BY name", nativeQuery = true)
    // List<List<String>> usersWithCollege();
    @Query(value = "SELECT * FROM `user_favorites` where id = ?",nativeQuery = true)
    List<RecipeEntity> userWithFavorite(Integer id);


}
