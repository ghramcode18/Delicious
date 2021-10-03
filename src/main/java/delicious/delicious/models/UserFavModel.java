package delicious.delicious.models;

import java.util.List;
import java.util.Objects;

import delicious.delicious.entities.RecipeEntity;

public class UserFavModel {
    private Integer id;

    private List<RecipeEntity> recipe_favoriteModel;

    public UserFavModel() {
    }
    public UserFavModel(Integer id) {
    }
    public UserFavModel(Integer id, List<RecipeEntity> recipe_favoriteModel) {
        this.id = id;
        this.recipe_favoriteModel = recipe_favoriteModel;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<RecipeEntity> getRecipe_favoriteModel() {
        return this.recipe_favoriteModel;
    }

    public void setRecipe_favoriteModel(List<RecipeEntity> recipe_favoriteModel) {
        this.recipe_favoriteModel = recipe_favoriteModel;
    }

    public UserFavModel id(Integer id) {
        setId(id);
        return this;
    }

    public UserFavModel recipe_favoriteModel(List<RecipeEntity> recipe_favoriteModel) {
        setRecipe_favoriteModel(recipe_favoriteModel);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserFavModel)) {
            return false;
        }
        UserFavModel userFavModel = (UserFavModel) o;
        return Objects.equals(id, userFavModel.id) && Objects.equals(recipe_favoriteModel, userFavModel.recipe_favoriteModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipe_favoriteModel);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", recipe_favoriteModel='" + getRecipe_favoriteModel() + "'" +
            "}";
    }


}
