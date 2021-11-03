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

    public void addFavorite(Integer userId, RecipeModel recipe) {

        UserEntity userEntity = userRepo.findById(userId).orElseThrow(() -> new UserException("no user with this id"));

        RecipeEntity recipeEntity = recipeRepo.findById(recipe.getId())
                .orElseThrow(() -> new RecipeException("no recipe with this id"));
        List<UserEntity> userEntities = recipeEntity.getUsers_added_to_favorite();
        int i = userEntities.stream().filter((user)->user.getId().equals(userId)).toList().size();
        if(i == 0)
        userEntities.add(userEntity);
        recipeEntity.setUsers_added_to_favorite(userEntities);
        recipeRepo.save(recipeEntity);
       
    }

    // public UserModel addFavorite (Integer id , RecipeModel rModel)
    // {List<RecipeEntity>recipeEntities= new ArrayList();
    // userRepo.findById(id).stream().forEach((e)->{
    // // List <UserFavModel> userFavModels= new
    // UserFavModel().recipe_favoriteModel(rModel.getUser_favorite());
    // // RecipeEntity recipeEntity= new RecipeEntity().users_added_to_favorite();
    // // recipeEntities.add(recipeEntity);

    // });

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

    private List<RecipeModel> RecipeEntityToRecipeModelAsList(List<RecipeEntity> recipeEntities) {
        List<RecipeModel> recipeModels = new ArrayList<>();
        if (recipeEntities.size() > 0) {
            for (RecipeEntity recipeEntity : recipeEntities) {
                RecipeEntity recipe = new RecipeEntity();
                recipe.id(recipeEntity.getId()).name(recipeEntity.getName()).image(recipeEntity.getImage())
                        .imgrate(recipeEntity.getImgrate()).price(recipeEntity.getPrice()).type(recipeEntity.getType())
                        .steps(recipeEntity.getSteps());

                recipeModels.add(RecipeEntityToRecipeModel(recipe));

            }
            return recipeModels;
        } else
            return new ArrayList<RecipeModel>();

    }

    private RecipeModel RecipeEntityToRecipeModel(RecipeEntity recipeEntity) {
        RecipeModel recipe_steps = new RecipeModel();
        recipe_steps.id(recipeEntity.getId()).name(recipeEntity.getName()).id(recipeEntity.getId())
                .image(recipeEntity.getImage()).imgrate(recipeEntity.getImgrate()).price(recipeEntity.getPrice())
                .steps(recipeEntity.getSteps()).type(recipeEntity.getType()).recipe_steps(recipeEntity.getSteps());

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
