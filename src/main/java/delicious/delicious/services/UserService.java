package delicious.delicious.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import delicious.delicious.DTO.UserRequest;
import delicious.delicious.entities.RecipeEntity;
import delicious.delicious.entities.UserEntity;
import delicious.delicious.exceptions.RecipeException;
import delicious.delicious.exceptions.UserException;
import delicious.delicious.models.RecipeFavModel;
import delicious.delicious.models.RecipeModel;
import delicious.delicious.models.Recipe_StepsModel;
import delicious.delicious.models.UserFavModel;
import delicious.delicious.models.UserModel;
import delicious.delicious.repositories.RecipeRepo;
import delicious.delicious.repositories.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RecipeRepo recipeRepo;

    public UserModel registerUser(UserModel user) throws UserException {
        if (user.getEmail() != null && user.getPassword() != null && user.getuserName() != null) {
            if (userRepo.findByEmail(user.getEmail()).isEmpty()) {
                UserEntity entity = userRepo.save(UserModelToUserEntity(user));
                return user.id(entity.getId());
            } else {
                throw new UserException("this email is already exist");
            }
        } else {
            throw new UserException("required fields are null");

        }
    }

    public UserModel signIn(UserModel user) throws UserException {
        Optional<UserEntity> entity;
        if ((entity = userRepo.findByEmail(user.getEmail())).isEmpty()) {
            throw new UserException("no user with this email");
        } else {
            if (entity.get().getPassword().equals(user.getPassword())) {
                return UserEntityToUserModel(entity.get());
            } else {
                throw new UserException("wrong password");
            }

        }
    }

    public UserModel UserEntityToUserModel(UserEntity user) {
        UserModel model = new UserModel().email(user.getEmail()).userName(user.getUserName()).id(user.getId())
                .password(user.getPassword());

        return model;

    }

    public UserEntity UserModelToUserEntity(UserModel user) {
        UserEntity entity = new UserEntity().email(user.getEmail()).userName(user.getuserName()).id(user.getId())
                .password(user.getPassword());

        return entity;

    }

    public UserEntity logout(UserModel userModel) {
        UserEntity entity = new UserEntity();
        if (userModel.getId() != null)
            entity = userRepo.findById(userModel.getId()).orElseThrow(() -> new UserException("no user with this id"));
        userRepo.delete(entity);
        return entity;

    }
    // public void addFavorite(Integer userId, Integer recipeId) {
    //     UserEntity userEntity = userRepo.findById(userId)
    //             .orElseThrow(() -> new UserException("no user with this id"));
    
    //     RecipeEntity recipeEntity  = recipeRepo.findById(recipeId)
    //     .orElseThrow(() -> new RecipeException("no recipe with this id"));
    //    List <RecipeEntity> recipeEntities= new ArrayList<>(10);
    //    recipeEntities.add(recipeEntity);
    //    userEntity.favorites(recipeEntities);
    //    recipeRepo.save(recipeEntities.get(0));
    //    userRepo.save(userEntity);
    //     List <UserEntity> userEntities =new ArrayList<>();
    //     userEntities.add(userEntity);
    //     recipeEntity.users_added_to_favorite(userEntities);
    //     recipeRepo .save(recipeEntity);
    //    recipeEntities= new ArrayList<>(10);



// }
    public void addFavorite(Integer userId, RecipeModel recipe) {
      
        UserEntity userEntity = userRepo.findById(userId)
                .orElseThrow(() -> new UserException("no user with this id"));
    
        RecipeEntity recipeEntity  = recipeRepo.findById(recipe.getId())
        .orElseThrow(() -> new RecipeException("no recipe with this id"));
      //  List <RecipeEntity> recipeEntities= new ArrayList<>();
      //  recipeEntities.add(recipeEntity);
     //   userEntity.favorites(recipeEntities);
        // recipeEntity.users_added_to_favorite(userEntity.getFavorites());
     //   recipeRepo.save(recipeEntities.get(0));
       // userRepo.save(userEntity);
        List <UserEntity> userEntities =new ArrayList<>();
        userEntities.add(userEntity);
        recipeEntity.setUsers_added_to_favorite(userEntities );
        recipeRepo .save(recipeEntity);

    // mapDtoToEntity(userDTO, userEntity);
    // UserEntity savedUser = userRepo.save(userEntity);
}
    
    
    

    // @id for user and object for the meal
    // @Transactional
    // public UserModel addFavorite(Integer id, RecipeModel rModel) {

    // UserEntity entity = userRepo.findById(id).orElseThrow(() -> new
    // UserException("no user with this id"));
   
    // }

    // public UserModel addFavorite (Integer id , RecipeModel rModel)
    // {List<RecipeEntity>recipeEntities= new ArrayList();
    // userRepo.findById(id).stream().forEach((e)->{
    // // List <UserFavModel> userFavModels= new UserFavModel().recipe_favoriteModel(rModel.getUser_favorite());
    // // RecipeEntity recipeEntity= new RecipeEntity().users_added_to_favorite();
    // // recipeEntities.add(recipeEntity);

    // });

    // }
    // public UserModel addFavorite(Integer id, RecipeModel rModel) {
    //     RecipeEntity recipeEntity = new RecipeEntity();
    //     UserEntity entity = userRepo.findById(id).orElseThrow(() -> new UserException("no user with this id"));

    //     recipeEntity = recipeRepo.findById(rModel.getId());
    //     recipeRepo.save(recipeEntity);

    // }

    /*
     * 
     * public List<UserResponse> search(String value) { List<UserResponse> responses
     * = new ArrayList<UserResponse>(); userRepo.findByEmailLikeOrNameLike(value,
     * value).stream().forEach((e)->{ UserResponse userResponse = new UserResponse()
     * .withId(e.getId()) .withName(e.getName()) .withImg(e.getImg());
     * responses.add(userResponse); }); return responses; } }
     */
    public List<RecipeModel> getFavorite(Integer id) {

        UserEntity entity = userRepo.findById(id).orElseThrow(() -> new UserException("no user with this id"));
        return RecipeEntityToRecipeModelAsList(entity.getFavorites());

    }

    // public List getFavoriteForUser(Integer id) {

    // UserEntity entity = userRepo.findById(id).orElseThrow(() -> new
    // UserException("no user with this id"));
    // // UserFavModel userFavModel = new UserFavModel(entity.getId(),
    // entity.getFavorites());
    // // List<RecipeModel> recipeModel =
    // ListRecipeEntityToRecipeListModelFav(userFavModel.getRecipe_favoriteModel());
    // // RecipeFavModel recipeFavModel = new
    // RecipeFavModel(recipeModel.get(0).getId(), recipeModel.get(0).getName(),
    // // recipeModel.get(0).getImage(), recipeModel.get(0).getPrice(),
    // recipeModel.get(0).getType(),
    // // recipeModel.get(0).getImgrate(), recipeModel.get(0).getRecipe_steps());
    // // return recipeFavModel;
    // List list= entity.getFavorites();
    // RecipeFavModel recipeFavModel = new RecipeFavModel(recipeModel.getId(),
    // recipeModel.get(0).getName(),
    // return ;
    // }

    private List<RecipeModel> RecipeEntityToRecipeModelAsList(List<RecipeEntity> entity) {
        List<RecipeModel> recipeModels = new ArrayList<>();
        if (entity.size() > 0) {
           for (RecipeEntity recipeEntity :entity){
                RecipeEntity rModel = new RecipeEntity();
                rModel.id(recipeEntity.getId()).name(recipeEntity.getName()).image(recipeEntity.getImage())
                        .imgrate(recipeEntity.getImgrate()).price(recipeEntity.getPrice()).type(recipeEntity.getType())
                        .recipe_steps(recipeEntity.getSteps());
                        
                        

                        recipeModels.add(RecipeEntityToRecipeModel(rModel));

            }
            return recipeModels;
        } else
            return new ArrayList<RecipeModel>();


    }

    private RecipeModel RecipeEntityToRecipeModel(RecipeModel rModel) {
        RecipeModel recipe_steps =new RecipeModel();
        recipe_steps.id(rModel.getId())
        .name(rModel)
    
        return recipe_steps;
    }

    public UserModel UserEntityToUserModelwithfav(UserEntity user) {
        UserModel model = new UserModel().id(user.getId()).recipe_favoriteModel(user.getFavorites());

        return model;

    }

    public List<RecipeModel> ListRecipeEntityToRecipeListModelFav(List<RecipeEntity> recipeEntities) {
        List<RecipeModel> RecipeModels = new ArrayList<>();
        if (recipeEntities.size() != 0) {
            for (RecipeEntity recipeEntity : recipeEntities) {
                RecipeModel rModel = new RecipeModel();
                rModel.user_favorite(recipeEntity.getUsers_added_to_favorite());

                RecipeModels.add(rModel);

            }
            return RecipeModels;
        } else
            return new ArrayList<RecipeModel>();

    }

    public List<RecipeEntity> ListRecipeModelToListRecipeMEntities(List<RecipeModel> recipeModels) {
        List<RecipeEntity> entity = new ArrayList<>();
        if (recipeModels.size() > 0) {
            for (RecipeEntity recipeEntity : entity) {
                RecipeModel rModel = new RecipeModel();
                rModel.id(recipeEntity.getId()).name(recipeEntity.getName()).image(recipeEntity.getImage())
                        .imgrate(recipeEntity.getImgrate()).price(recipeEntity.getPrice()).type(recipeEntity.getType())
                        .recipe_steps(recipeEntity.getSteps()).user_favorite(recipeEntity.getUsers_added_to_favorite())
                        .user_clike(recipeEntity.getUser_clicks());

                entity.add(RecipeModelToRecipeEntity(rModel));

            }
            return entity;
        } else
            return new ArrayList<RecipeEntity>();

    }

    private RecipeEntity RecipeModelToRecipeEntity(RecipeModel rModel) {
        RecipeEntity rEntity = new RecipeEntity();
        rEntity.id(rModel.getId()).name(rModel.getName()).image(rModel.getImage()).type(rModel.getType())
                .price(rModel.getPrice()).imgrate(rModel.getImgrate())
                .users_added_to_favorite(rModel.getUser_favorite()).steps(rModel.getRecipe_steps());
        return rEntity;
    }

}
