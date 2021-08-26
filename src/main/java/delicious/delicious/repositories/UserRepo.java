package delicious.delicious.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import delicious.delicious.entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer>{
    

    Optional<UserEntity> findByEmail(String email);



}
