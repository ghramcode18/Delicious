package delicious.delicious.entities;

import java.util.ArrayList;
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
@Table(name  = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;

    private String email;

    private String password;

    @ManyToMany(mappedBy = "users_added_to_favorite")
    private List<RecipeEntity> favorites;

    @ManyToMany(mappedBy = "users_clicked_recipe")
    private List<RecipeEntity> clicksnew = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<FireBaseEntity> firebasenew= new  ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(Integer id, String userName, String email, String password, List<RecipeEntity> favorites, List<RecipeEntity> clicksnew, List<FireBaseEntity> firebasenew) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.favorites = favorites;
        this.clicksnew = clicksnew;
        this.firebasenew = firebasenew;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public List<RecipeEntity> getClicksnew() {
        return this.clicksnew;
    }

    public void setClicksnew(List<RecipeEntity> clicksnew) {
        this.clicksnew = clicksnew;
    }

    public List<FireBaseEntity> getFirebasenew() {
        return this.firebasenew;
    }

    public void setFirebasenew(List<FireBaseEntity> firebasenew) {
        this.firebasenew = firebasenew;
    }

    public UserEntity id(Integer id) {
        setId(id);
        return this;
    }

    public UserEntity userName(String userName) {
        setUserName(userName);
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

    public UserEntity clicksnew(List<RecipeEntity> clicksnew) {
        setClicksnew(clicksnew);
        return this;
    }

    public UserEntity firebasenew(List<FireBaseEntity> firebasenew) {
        setFirebasenew(firebasenew);
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
        return Objects.equals(id, userEntity.id) && Objects.equals(userName, userEntity.userName) && Objects.equals(email, userEntity.email) && Objects.equals(password, userEntity.password) && Objects.equals(favorites, userEntity.favorites) && Objects.equals(clicksnew, userEntity.clicksnew) && Objects.equals(firebasenew, userEntity.firebasenew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, password, favorites, clicksnew, firebasenew);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", favorites='" + getFavorites() + "'" +
            ", clicksnew='" + getClicksnew() + "'" +
            ", firebasenew='" + getFirebasenew() + "'" +
            "}";
    }

}
