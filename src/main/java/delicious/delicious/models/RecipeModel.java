package delicious.delicious.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import delicious.delicious.entities.Recipe_stepsEntity;
import delicious.delicious.entities.UserEntity;

public class RecipeModel {
    private Integer id;
    private String name;
    private String image ;
    private double price ;
    private String type ;
    private String imgrate;
    // private Recipe_stepsEntity steps ;
    private List <UserEntity>user_favorite=new ArrayList<>();
    private List <UserEntity>user_clike=new ArrayList<>();
    private Recipe_stepsEntity recipe_steps;

    public RecipeModel() {
    }

    public RecipeModel(Integer id, String name, String image, double price, String type, Recipe_stepsEntity steps, String imgrate, List<UserEntity> user_favorite, List<UserEntity> user_clike, Recipe_stepsEntity recipe_steps) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.type = type;
      //  this.steps = steps;
        this.imgrate = imgrate;
        this.user_favorite = user_favorite;
        this.user_clike = user_clike;
        this.recipe_steps = recipe_steps;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // public Recipe_stepsEntity getSteps() {
    //     return this.steps;
    // }

    // public void setSteps(Recipe_stepsEntity steps) {
    //     this.steps = steps;
    // }

    public String getImgrate() {
        return this.imgrate;
    }

    public void setImgrate(String imgrate) {
        this.imgrate = imgrate;
    }

    public List<UserEntity> getUser_favorite() {
        return this.user_favorite;
    }

    public void setUser_favorite(List<UserEntity> user_favorite) {
        this.user_favorite = user_favorite;
    }

    public List<UserEntity> getUser_clike() {
        return this.user_clike;
    }

    public void setUser_clike(List<UserEntity> user_clike) {
        this.user_clike = user_clike;
    }

    public Recipe_stepsEntity getRecipe_steps() {
        return this.recipe_steps;
    }

    public void setRecipe_steps(Recipe_stepsEntity recipe_steps) {
        this.recipe_steps = recipe_steps;
    }

    public RecipeModel id(Integer id) {
        setId(id);
        return this;
    }

    public RecipeModel name(String name) {
        setName(name);
        return this;
    }

    public RecipeModel image(String image) {
        setImage(image);
        return this;
    }

    public RecipeModel price(double price) {
        setPrice(price);
        return this;
    }

    public RecipeModel type(String type) {
        setType(type);
        return this;
    }

    // public RecipeModel steps(Recipe_stepsEntity steps) {
    //     setSteps(steps);
    //     return this;
    // }

    public RecipeModel imgrate(String imgrate) {
        setImgrate(imgrate);
        return this;
    }

    public RecipeModel user_favorite(List<UserEntity> user_favorite) {
        setUser_favorite(user_favorite);
        return this;
    }

    public RecipeModel user_clike(List<UserEntity> user_clike) {
        setUser_clike(user_clike);
        return this;
    }

    public RecipeModel recipe_steps(Recipe_stepsEntity recipe_steps) {
        setRecipe_steps(recipe_steps);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RecipeModel)) {
            return false;
        }
        RecipeModel recipeModel = (RecipeModel) o;
        return Objects.equals(id, recipeModel.id) && Objects.equals(name, recipeModel.name) && Objects.equals(image, recipeModel.image) && price == recipeModel.price && Objects.equals(type, recipeModel.type) &&  Objects.equals(imgrate, recipeModel.imgrate) && Objects.equals(user_favorite, recipeModel.user_favorite) && Objects.equals(user_clike, recipeModel.user_clike) && Objects.equals(recipe_steps, recipeModel.recipe_steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, price, type, imgrate, user_favorite, user_clike, recipe_steps);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", image='" + getImage() + "'" +
            ", price='" + getPrice() + "'" +
            ", type='" + getType() + "'" +
           // ", steps='" + getSteps() + "'" +
            ", imgrate='" + getImgrate() + "'" +
            ", user_favorite='" + getUser_favorite() + "'" +
            ", user_clike='" + getUser_clike() + "'" +
            ", recipe_steps='" + getRecipe_steps() + "'" +
            "}";
    }

}
