package delicious.delicious.services;

    

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import delicious.delicious.entities.RecipeEntity;
import delicious.delicious.entities.UserEntity;
import delicious.delicious.exceptions.RecipeException;
import delicious.delicious.exceptions.UserException;
import delicious.delicious.models.RecipeModel;
import delicious.delicious.models.UserModel;
import delicious.delicious.repositories.RecipeRepo;
import delicious.delicious.repositories.UserRepo;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;
    @Autowired
    RecipeRepo recipeRepo;
    private List<RecipeEntity> favorites;
    
  
  
    public UserModel registerUser(UserModel user) throws UserException 
    {
        if(user.getEmail() != null && user.getPassword() != null && user.getName()!= null)
        {
            if(userRepo.findByEmail(user.getEmail()).isEmpty())
            {
                UserEntity entity = userRepo.save(UserModelToUserEntity(user));
                return user.id(entity.getId());
            }else{
                throw new UserException("this email is already exist");
            }
        }else{
            throw new UserException("required fields are null");

        }
    }


  
    
    public UserModel signIn(UserModel user) throws UserException
    {
        Optional<UserEntity> entity;
        if((entity = userRepo.findByEmail(user.getEmail())).isEmpty())
        {
            throw new UserException("no user with this email");
        }else{
            if(entity.get().getPassword().equals(user.getPassword()))
            {
                return UserEntityToUserModel(entity.get());
            }else{
                throw new UserException("wrong password");
            }

        }
    }
    
    public  UserModel  UserEntityToUserModel(UserEntity user)
    {
        UserModel model = new UserModel()
        .email(user.getEmail())
        .name(user.getName())
        .id(user.getId())
        .password(user.getPassword());

        return model;


    }

    public  UserEntity  UserModelToUserEntity(UserModel user)
    {
        UserEntity entity = new UserEntity()
        .email(user.getEmail())
        .name(user.getName())
        .id(user.getId())
        .password(user.getPassword());

        return entity;


    }


    public  UserEntity logout (UserModel userModel)
    {
        UserEntity entity;
        if(userModel.getId()!= null)
        entity = userRepo.findById(userModel.getId()).orElseThrow(()-> new UserException("no user with this id"));
        entity = new UserEntity();
        userRepo.save(entity);
        return entity;


        

    }

    public UserModel updateUser(UserModel user ,RecipeModel rModel ){
        if(user.getId() == null&&rModel.getId() == null)
            throw new UserException("can't  user  or recipe with this id");

        UserEntity entity = userRepo.findById(user.getId()).orElseThrow(()-> new UserException("no user with this id"));
        
        RecipeEntity  rEntity = userRepo.findById(rModel.getId()).orElseThrow(()-> new UserException("no recipe with this id"));
     
       // rEntity.getUsers_added_to_favorite();
        userRepo.save(entity);
        
        return UserEntityToUserModel(entity); 


        //   entity.name(user.getUserName()).password(user.getPassword()).email(user.getEmail());
           // if(rModel.getId() == null)
           // throw new UserException("can't update user without id");
           // RecipeEntity  rEntity = RecipeRepo.findById(rModel.getId()).orElseThrow(()-> new RecipeException("no user with this id"));
           //     favorites = entity.getFavorites();
               
   
          // UserEntityToUserModel(entity) .user_favorite(entity.getFavorites());
           //entity.favorites(favorites);
           
    }


   

}
