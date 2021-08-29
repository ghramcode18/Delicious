package delicious.delicious.services;

    

import java.util.ArrayList;
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
        .password(user.getPassword())
        .recipe_favoriteModel(user.getFavorites())
        .recipes_clicksModel(user.getClicks());

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
        UserEntity entity = new UserEntity();
        if(userModel.getId()!= null)
        entity = userRepo.findById(userModel.getId()).orElseThrow(()-> new UserException("no user with this id"));
        userRepo.delete(entity);
        //entity = new UserEntity();
      //  userRepo.save(entity);
        return entity;


        

    }

    public UserModel updateUser(UserModel user , List< RecipeModel> rModel ){
        if(user.getId() == null)
            throw new UserException("can't  user  or recipe with this id");

        UserEntity entity = userRepo.findById(user.getId()).orElseThrow(()-> new UserException("no user with this id"));
        
        // RecipeEntity  rEntity = recipeRepo.findAllById(rModel.).orElseThrow(()-> new UserException("no recipe with this id"));
        entity.getFavorites().add(RecipeModelToRecipeEntity(rModel));
        userRepo.save(entity);
        return UserEntityToUserModel(entity); 

      
    }

        public List <RecipeEntity> ListRecipeModelToRecipeEntity  (  List <RecipeModel> recipeModels)
        {//TODO IN ARRAYLIST
         List <RecipeEntity >entity  = new ArrayList<>();
         if (entity.size()>0) {
         for (RecipeEntity recipeEntity : entity) {
            RecipeModel rModel = new RecipeModel();
            rModel.id(recipeEntity.getId())
            .name(recipeEntity.getName())
            .image(recipeEntity.getImage())
            .imgrate(recipeEntity.getImgrate())
            .price(recipeEntity.getPrice())
            .type(recipeEntity.getType())
            .recipe_steps(recipeEntity.getSteps())
            .user_favorite(recipeEntity.getUsers_added_to_favorite())
            .user_clike(recipeEntity.getUser_clicks());
            

              entity.add(RecipeModelToRecipeEntity(rModel));
              
            }
            return entity;
        }
            else return new ArrayList<RecipeEntity>();
    
         }
        



        private RecipeEntity RecipeModelToRecipeEntity(RecipeModel rModel) {
        RecipeEntity rEntity = new RecipeEntity();
        rEntity.id(rModel.getId())
        .name(rModel.getName())
        .image(rModel.getImage())
        .type(rModel.getType())
        .price(rModel.getPrice())
        .user_clicks(rModel.getUser_clike())
        .imgrate(rModel.getImgrate())
        .users_added_to_favorite(rModel.getUser_favorite())
        .steps(rModel.getRecipe_steps());
            return rEntity;
        }

      

        //   entity.name(user.getUserName()).password(user.getPassword()).email(user.getEmail());
           // if(rModel.getId() == null)
           // throw new UserException("can't update user without id");
           // RecipeEntity  rEntity = RecipeRepo.findById(rModel.getId()).orElseThrow(()-> new RecipeException("no user with this id"));
           //     favorites = entity.getFavorites();
               
   
          // UserEntityToUserModel(entity) .user_favorite(entity.getFavorites());
           //entity.favorites(favorites);
 
}
