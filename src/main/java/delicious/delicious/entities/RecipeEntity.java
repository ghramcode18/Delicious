package delicious.delicious.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String image;

    private String type;

    private double price;

    private String imgrate;


    @ManyToMany(targetEntity = UserEntity.class)
    @JoinTable(
    name = "user_favorites", 
    joinColumns = @JoinColumn(name = "recipe_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> users_added_to_favorite;

    @ManyToMany(targetEntity = UserEntity.class)
    @JoinTable(name ="users_clicks", 
    joinColumns = {@JoinColumn(name = "recipe_id")},
    inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<UserEntity> users_clicked_recipe;


    // @OneToOne
    // private Recipe_stepsEntity recipe_steps;





    // public RecipeEntity() {
    // }

    // public RecipeEntity(Integer id, String name, String image, String type, double price, String imgrate, List<UserEntity> users_added_to_favorite, List<UserEntity> users_clicked_recipe, Recipe_stepsEntity recipe_steps) {
    //     this.id = id;
    //     this.name = name;
    //     this.image = image;
    //     this.type = type;
    //     this.price = price;
    //     this.imgrate = imgrate;
    //     this.users_added_to_favorite = users_added_to_favorite;
    //     this.users_clicked_recipe = users_clicked_recipe;
    //     this.recipe_steps = recipe_steps;
    // }

    // public Integer getId() {
    //     return this.id;
    // }

    // public void setId(Integer id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return this.name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getImage() {
    //     return this.image;
    // }

    // public void setImage(String image) {
    //     this.image = image;
    // }

    // public String getType() {
    //     return this.type;
    // }

    // public void setType(String type) {
    //     this.type = type;
    // }

    // public double getPrice() {
    //     return this.price;
    // }

    // public void setPrice(double price) {
    //     this.price = price;
    // }

    // public String getImgrate() {
    //     return this.imgrate;
    // }

    // public void setImgrate(String imgrate) {
    //     this.imgrate = imgrate;
    // }

    // public List<UserEntity> getUsers_added_to_favorite() {
    //     return this.users_added_to_favorite;
    // }

    // public void setUsers_added_to_favorite(List<UserEntity> users_added_to_favorite) {
    //     this.users_added_to_favorite = users_added_to_favorite;
    // }

    // public List<UserEntity> getUsers_clicked_recipe() {
    //     return this.users_clicked_recipe;
    // }

    // public void setUsers_clicked_recipe(List<UserEntity> users_clicked_recipe) {
    //     this.users_clicked_recipe = users_clicked_recipe;
    // }

    // public Recipe_stepsEntity getRecipe_steps() {
    //     return this.recipe_steps;
    // }

    // public void setRecipe_steps(Recipe_stepsEntity recipe_steps) {
    //     this.recipe_steps = recipe_steps;
    // }

    // public RecipeEntity id(Integer id) {
    //     setId(id);
    //     return this;
    // }

    // public RecipeEntity name(String name) {
    //     setName(name);
    //     return this;
    // }

    // public RecipeEntity image(String image) {
    //     setImage(image);
    //     return this;
    // }

    // public RecipeEntity type(String type) {
    //     setType(type);
    //     return this;
    // }

    // public RecipeEntity price(double price) {
    //     setPrice(price);
    //     return this;
    // }

    // public RecipeEntity imgrate(String imgrate) {
    //     setImgrate(imgrate);
    //     return this;
    // }

    // public RecipeEntity users_added_to_favorite(List<UserEntity> users_added_to_favorite) {
    //     setUsers_added_to_favorite(users_added_to_favorite);
    //     return this;
    // }

    // public RecipeEntity users_clicked_recipe(List<UserEntity> users_clicked_recipe) {
    //     setUsers_clicked_recipe(users_clicked_recipe);
    //     return this;
    // }

    // public RecipeEntity recipe_steps(Recipe_stepsEntity recipe_steps) {
    //     setRecipe_steps(recipe_steps);
    //     return this;
    // }

    // @Override
    // public boolean equals(Object o) {
    //     if (o == this)
    //         return true;
    //     if (!(o instanceof RecipeEntity)) {
    //         return false;
    //     }
    //     RecipeEntity recipeEntity = (RecipeEntity) o;
    //     return Objects.equals(id, recipeEntity.id) && Objects.equals(name, recipeEntity.name) && Objects.equals(image, recipeEntity.image) && Objects.equals(type, recipeEntity.type) && price == recipeEntity.price && Objects.equals(imgrate, recipeEntity.imgrate) && Objects.equals(users_added_to_favorite, recipeEntity.users_added_to_favorite) && Objects.equals(users_clicked_recipe, recipeEntity.users_clicked_recipe) && Objects.equals(recipe_steps, recipeEntity.recipe_steps);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(id, name, image, type, price, imgrate, users_added_to_favorite, users_clicked_recipe, recipe_steps);
    // }

    // @Override
    // public String toString() {
    //     return "{" +
    //         " id='" + getId() + "'" +
    //         ", name='" + getName() + "'" +
    //         ", image='" + getImage() + "'" +
    //         ", type='" + getType() + "'" +
    //         ", price='" + getPrice() + "'" +
    //         ", imgrate='" + getImgrate() + "'" +
    //         ", users_added_to_favorite='" + getUsers_added_to_favorite() + "'" +
    //         ", users_clicked_recipe='" + getUsers_clicked_recipe() + "'" +
    //         ", recipe_steps='" + getRecipe_steps() + "'" +
    //         "}";
    // }
}