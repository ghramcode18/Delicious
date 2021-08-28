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

    private String img;

    private String type;

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


    public RecipeEntity() {
    }

    public RecipeEntity(Integer id, String name, String img, String type, List<UserEntity> users_added_to_favorite) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.type = type;
        this.users_added_to_favorite = users_added_to_favorite;
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

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<UserEntity> getUsers_added_to_favorite() {
        return this.users_added_to_favorite;
    }

    public void setUsers_added_to_favorite(List<UserEntity> users_added_to_favorite) {
        this.users_added_to_favorite = users_added_to_favorite;
    }

    public RecipeEntity id(Integer id) {
        setId(id);
        return this;
    }

    public RecipeEntity name(String name) {
        setName(name);
        return this;
    }

    public RecipeEntity img(String img) {
        setImg(img);
        return this;
    }

    public RecipeEntity type(String type) {
        setType(type);
        return this;
    }

    public RecipeEntity users_added_to_favorite(List<UserEntity> users_added_to_favorite) {
        setUsers_added_to_favorite(users_added_to_favorite);
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
        return Objects.equals(id, recipeEntity.id) && Objects.equals(name, recipeEntity.name) && Objects.equals(img, recipeEntity.img) && Objects.equals(type, recipeEntity.type) && Objects.equals(users_added_to_favorite, recipeEntity.users_added_to_favorite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, img, type, users_added_to_favorite);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", img='" + getImg() + "'" +
            ", type='" + getType() + "'" +
            ", users_added_to_favorite='" + getUsers_added_to_favorite() + "'" +
            "}";
    }

}
