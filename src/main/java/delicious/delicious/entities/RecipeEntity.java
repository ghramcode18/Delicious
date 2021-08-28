package delicious.delicious.entities;

import java.util.List;
import java.util.Objects;

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
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String image ;

    @Column(nullable = true)
    private double price ;

    @Column(nullable = true)
    private String type ;

    @OneToOne
    private Recipe_stepsEntity steps ;

    @Column(nullable = true)
    private String imgrate;

    @ManyToMany(targetEntity = UserEntity.class)
    @JoinTable(
    name = "user_favorites", 
    joinColumns = @JoinColumn(name = "recipe_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List <UserEntity>users_added_to_favorite;
   
    @ManyToMany(targetEntity = UserEntity.class)
    @JoinTable(
    name = "users_clicks", 
    joinColumns = @JoinColumn(name = "recipe_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List <UserEntity>user_clicks;

     @OneToOne
     private Recipe_stepsEntity users_clicked_recipe;


    public RecipeEntity() {
    }

    public RecipeEntity(Integer id, String name, String image, double price, String type, Recipe_stepsEntity steps, String imgrate, List<UserEntity> users_added_to_favorite, List<UserEntity> user_clicks, Recipe_stepsEntity users_clicked_recipe) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.type = type;
        this.steps = steps;
        this.imgrate = imgrate;
        this.users_added_to_favorite = users_added_to_favorite;
        this.user_clicks = user_clicks;
        this.users_clicked_recipe = users_clicked_recipe;
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

    public Recipe_stepsEntity getSteps() {
        return this.steps;
    }

    public void setSteps(Recipe_stepsEntity steps) {
        this.steps = steps;
    }

    public String getImgrate() {
        return this.imgrate;
    }

    public void setImgrate(String imgrate) {
        this.imgrate = imgrate;
    }

    public List<UserEntity> getUsers_added_to_favorite() {
        return this.users_added_to_favorite;
    }

    public void setUsers_added_to_favorite(List<UserEntity> users_added_to_favorite) {
        this.users_added_to_favorite = users_added_to_favorite;
    }

    public List<UserEntity> getUser_clicks() {
        return this.user_clicks;
    }

    public void setUser_clicks(List<UserEntity> user_clicks) {
        this.user_clicks = user_clicks;
    }

    public Recipe_stepsEntity getUsers_clicked_recipe() {
        return this.users_clicked_recipe;
    }

    public void setUsers_clicked_recipe(Recipe_stepsEntity users_clicked_recipe) {
        this.users_clicked_recipe = users_clicked_recipe;
    }

    public RecipeEntity id(Integer id) {
        setId(id);
        return this;
    }

    public RecipeEntity name(String name) {
        setName(name);
        return this;
    }

    public RecipeEntity image(String image) {
        setImage(image);
        return this;
    }

    public RecipeEntity price(double price) {
        setPrice(price);
        return this;
    }

    public RecipeEntity type(String type) {
        setType(type);
        return this;
    }

    public RecipeEntity steps(Recipe_stepsEntity steps) {
        setSteps(steps);
        return this;
    }

    public RecipeEntity imgrate(String imgrate) {
        setImgrate(imgrate);
        return this;
    }

    public RecipeEntity users_added_to_favorite(List<UserEntity> users_added_to_favorite) {
        setUsers_added_to_favorite(users_added_to_favorite);
        return this;
    }

    public RecipeEntity user_clicks(List<UserEntity> user_clicks) {
        setUser_clicks(user_clicks);
        return this;
    }

    public RecipeEntity users_clicked_recipe(Recipe_stepsEntity users_clicked_recipe) {
        setUsers_clicked_recipe(users_clicked_recipe);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RecipeEntity)) {
            return false;
        }
        RecipeEntity recipeEntity = (RecipeEntity) o;
        return Objects.equals(id, recipeEntity.id) && Objects.equals(name, recipeEntity.name) && Objects.equals(image, recipeEntity.image) && price == recipeEntity.price && Objects.equals(type, recipeEntity.type) && Objects.equals(steps, recipeEntity.steps) && Objects.equals(imgrate, recipeEntity.imgrate) && Objects.equals(users_added_to_favorite, recipeEntity.users_added_to_favorite) && Objects.equals(user_clicks, recipeEntity.user_clicks) && Objects.equals(users_clicked_recipe, recipeEntity.users_clicked_recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, price, type, steps, imgrate, users_added_to_favorite, user_clicks, users_clicked_recipe);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", image='" + getImage() + "'" +
            ", price='" + getPrice() + "'" +
            ", type='" + getType() + "'" +
            ", steps='" + getSteps() + "'" +
            ", imgrate='" + getImgrate() + "'" +
            ", users_added_to_favorite='" + getUsers_added_to_favorite() + "'" +
            ", user_clicks='" + getUser_clicks() + "'" +
            ", users_clicked_recipe='" + getUsers_clicked_recipe() + "'" +
            "}";
    }


}
