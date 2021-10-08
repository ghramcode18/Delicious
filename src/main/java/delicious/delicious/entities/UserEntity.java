package delicious.delicious.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name  = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "users_added_to_favorite")
    private List<RecipeEntity> favorites;

    @ManyToMany(mappedBy = "users_clicked_recipe")
    private List<RecipeEntity> clicks= new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<FireBaseEntity> firebase= new  ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(Integer id, String userName, String email, String password, List<RecipeEntity> favorites, List<RecipeEntity> clicks, List<FireBaseEntity> firebase) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.favorites = favorites;
        this.clicks = clicks;
        this.firebase = firebase;
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

    public List<RecipeEntity> getClicks() {
        return this.clicks;
    }

    public void setClicks(List<RecipeEntity> clicks) {
        this.clicks = clicks;
    }

    public List<FireBaseEntity> getFirebase() {
        return this.firebase;
    }

    public void setFirebase(List<FireBaseEntity> firebase) {
        this.firebase = firebase;
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

    public UserEntity clicks(List<RecipeEntity> clicks) {
        setClicks(clicks);
        return this;
    }

    public UserEntity firebase(List<FireBaseEntity> firebase) {
        setFirebase(firebase);
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
        return Objects.equals(id, userEntity.id) && Objects.equals(userName, userEntity.userName) && Objects.equals(email, userEntity.email) && Objects.equals(password, userEntity.password) && Objects.equals(favorites, userEntity.favorites) && Objects.equals(clicks, userEntity.clicks) && Objects.equals(firebase, userEntity.firebase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, password, favorites, clicks, firebase);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", favorites='" + getFavorites() + "'" +
            ", clicks='" + getClicks() + "'" +
            ", firebase='" + getFirebase() + "'" +
            "}";
    }

}
