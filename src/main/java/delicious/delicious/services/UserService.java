package delicious.delicious.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import delicious.delicious.entities.RecipeEntity;
import delicious.delicious.entities.UserEntity;
import delicious.delicious.exceptions.UserException;
import delicious.delicious.models.RecipeFavModel;
import delicious.delicious.models.RecipeModel;
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
        if (user.getEmail() != null && user.getPassword() != null && user.getName() != null) {
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
        UserModel model = new UserModel().email(user.getEmail()).name(user.getName()).id(user.getId())
                .password(user.getPassword());

        return model;

    }

    public UserEntity UserModelToUserEntity(UserModel user) {
        UserEntity entity = new UserEntity().email(user.getEmail()).name(user.getName()).id(user.getId())
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

    // @id for user and object for the meal
    public UserModel addFavorite(Integer id, RecipeModel rModel) {

        UserEntity entity = userRepo.findById(id).orElseThrow(() -> new UserException("no user with this id"));
        entity.getFavorites().add(RecipeModelToRecipeEntity(rModel));
        userRepo.save(entity);

        return UserEntityToUserModelwithfav(entity);

    }

    /*
    public List<UserResponse> search(String value)
    {
        List<UserResponse> responses = new ArrayList<UserResponse>();
        userRepo.findByEmailLikeOrNameLike(value, value).stream().forEach((e)->{
            UserResponse userResponse = new UserResponse()
                .withId(e.getId())
                .withName(e.getName())
                .withImg(e.getImg());
            responses.add(userResponse);
        });
        return responses;
    }
}*/
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

    private List<RecipeModel> RecipeEntityToRecipeModelAsList(List<RecipeEntity> favorites) {
        return null;
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
