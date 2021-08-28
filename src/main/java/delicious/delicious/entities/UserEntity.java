package delicious.delicious.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "users")
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private String password;

    @ManyToMany(mappedBy = "users_added_to_favorite")
    private List<RecipeEntity> favorites;

    @ManyToMany(mappedBy = "users_clicked_recipe")
    private List<RecipeEntity> clicks;

    @OneToMany(mappedBy = "user")
    private List<FireBaseEntity> firebase;

    public UserEntity() {
    }

    public UserEntity(Integer id, String name, String email, String password, List<RecipeEntity> favorites) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.favorites = favorites;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RecipeEntity> getFavorites() {
        return this.favorites;
    }

    public void setFavorites(List<RecipeEntity> favorites) {
        this.favorites = favorites;
    }

    public UserEntity id(Integer id) {
        setId(id);
        return this;
    }

    public UserEntity name(String name) {
        setName(name);
        return this;
    }

    public UserEntity email(String email) {
        setEmail(email);
        return this;
    }

    public UserEntity password(String password) {
        setPassword(password);
        return this;
    }

    public UserEntity favorites(List<RecipeEntity> favorites) {
        setFavorites(favorites);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) && Objects.equals(name, userEntity.name) && Objects.equals(email, userEntity.email) && Objects.equals(password, userEntity.password) && Objects.equals(favorites, userEntity.favorites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, favorites);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", favorites='" + getFavorites() + "'" +
            "}";
    }

}
