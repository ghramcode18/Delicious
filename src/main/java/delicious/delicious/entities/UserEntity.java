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
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "Users")
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private String userName ;

    @Column(nullable = false)
    private String email;

  
    
    @ManyToMany(targetEntity = RecipeEntity.class)
    @JoinTable(name = "user_favorites", joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "recipe_id")})
    private List  <RecipeEntity>recipe_favorite;

    @Column(nullable = false)
    private String password ;
    
    // @ManyToMany(mappedBy = "user_clicks")
    
    // private List  <RecipeEntity>recipes_clicks;

    @OneToMany(targetEntity = FireBaseEntity.class,mappedBy = "user")
    
    private List<FireBaseEntity> firebase;

    public UserEntity() {
    }

    public UserEntity(Integer id, String userName, String email, List<RecipeEntity> recipe_favorite, String password, List<FireBaseEntity> firebase) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.recipe_favorite = recipe_favorite;
        this.password = password;
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

    public List<RecipeEntity> getRecipe_favorite() {
        return this.recipe_favorite;
    }

    public void setRecipe_favorite(List<RecipeEntity> recipe_favorite) {
        this.recipe_favorite = recipe_favorite;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserEntity recipe_favorite(List<RecipeEntity> recipe_favorite) {
        setRecipe_favorite(recipe_favorite);
        return this;
    }

    public UserEntity password(String password) {
        setPassword(password);
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
        return Objects.equals(id, userEntity.id) && Objects.equals(userName, userEntity.userName) && Objects.equals(email, userEntity.email) && Objects.equals(recipe_favorite, userEntity.recipe_favorite) && Objects.equals(password, userEntity.password) && Objects.equals(firebase, userEntity.firebase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, recipe_favorite, password, firebase);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", email='" + getEmail() + "'" +
            ", recipe_favorite='" + getRecipe_favorite() + "'" +
            ", password='" + getPassword() + "'" +
            ", firebase='" + getFirebase() + "'" +
            "}";
    }

}
