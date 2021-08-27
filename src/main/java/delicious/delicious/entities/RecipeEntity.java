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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Recipe")
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

    @ManyToMany(targetEntity = UserEntity.class, mappedBy = "Recipe", cascade = CascadeType.ALL)
    private List <UserEntity>user_favorite;
   
    @ManyToMany(targetEntity = UserEntity.class, mappedBy = "Recipe", cascade = CascadeType.ALL)
    private List <UserEntity>user_clike;

  //  (mappedBy = "id_recipeSteps_id")
     @OneToOne
     private Recipe_stepsEntity recipe_steps;


    public RecipeEntity() {
    }

    public RecipeEntity(Integer id, String name, String image, double price, String type, Recipe_stepsEntity steps, String imgrate, List<UserEntity> user_favorite, List<UserEntity> user_clike, Recipe_stepsEntity recipe_steps) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.type = type;
        this.steps = steps;
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

    public RecipeEntity user_favorite(List<UserEntity> user_favorite) {
        setUser_favorite(user_favorite);
        return this;
    }

    public RecipeEntity user_clike(List<UserEntity> user_clike) {
        setUser_clike(user_clike);
        return this;
    }

    public RecipeEntity recipe_steps(Recipe_stepsEntity recipe_steps) {
        setRecipe_steps(recipe_steps);
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
        return Objects.equals(id, recipeEntity.id) && Objects.equals(name, recipeEntity.name) && Objects.equals(image, recipeEntity.image) && price == recipeEntity.price && Objects.equals(type, recipeEntity.type) && Objects.equals(steps, recipeEntity.steps) && Objects.equals(imgrate, recipeEntity.imgrate) && Objects.equals(user_favorite, recipeEntity.user_favorite) && Objects.equals(user_clike, recipeEntity.user_clike) && Objects.equals(recipe_steps, recipeEntity.recipe_steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, price, type, steps, imgrate, user_favorite, user_clike, recipe_steps);
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
            ", user_favorite='" + getUser_favorite() + "'" +
            ", user_clike='" + getUser_clike() + "'" +
            ", recipe_steps='" + getRecipe_steps() + "'" +
            "}";
    }
    


}
