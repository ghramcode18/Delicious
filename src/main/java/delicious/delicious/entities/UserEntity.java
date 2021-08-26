package delicious.delicious.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;



@Data
@EqualsAndHashCode(exclude = "Recipes")

@Entity
@Table(name = "UserEntity")
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private String userName ;

    @Column(nullable = false)
    private String email;

  
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_Recipe",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "Recipe_id", referencedColumnName = "id"))
    private List  <RecipeEntity>recipe_favoriteEntity;

    @Column(nullable = false)
    private String password ;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_Recipe",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "Recipe_id", referencedColumnName = "id"))
    private List  <RecipeEntity>recipes_clicksEntity;

    @OneToMany(mappedBy = "user")
    private List<FireBaseEntity> firebase;

    public UserEntity() {
    }

    public UserEntity(Integer id, String userName, String email, String password, List<RecipeEntity> recipe_favoriteEntity, List<RecipeEntity> recipes_clicksEntity, List<FireBaseEntity> firebase) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.recipe_favoriteEntity = recipe_favoriteEntity;
        this.recipes_clicksEntity = recipes_clicksEntity;
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

    public List<RecipeEntity> getRecipe_favoriteEntity() {
        return this.recipe_favoriteEntity;
    }

    public void setRecipe_favoriteEntity(List<RecipeEntity> recipe_favoriteEntity) {
        this.recipe_favoriteEntity = recipe_favoriteEntity;
    }

    public List<RecipeEntity> getRecipes_clicksEntity() {
        return this.recipes_clicksEntity;
    }

    public void setRecipes_clicksEntity(List<RecipeEntity> recipes_clicksEntity) {
        this.recipes_clicksEntity = recipes_clicksEntity;
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

    public UserEntity recipe_favoriteEntity(List<RecipeEntity> recipe_favoriteEntity) {
        setRecipe_favoriteEntity(recipe_favoriteEntity);
        return this;
    }

    public UserEntity recipes_clicksEntity(List<RecipeEntity> recipes_clicksEntity) {
        setRecipes_clicksEntity(recipes_clicksEntity);
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
        return Objects.equals(id, userEntity.id) && Objects.equals(userName, userEntity.userName) && Objects.equals(email, userEntity.email) && Objects.equals(password, userEntity.password) && Objects.equals(recipe_favoriteEntity, userEntity.recipe_favoriteEntity) && Objects.equals(recipes_clicksEntity, userEntity.recipes_clicksEntity) && Objects.equals(firebase, userEntity.firebase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, password, recipe_favoriteEntity, recipes_clicksEntity, firebase);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", recipe_favoriteEntity='" + getRecipe_favoriteEntity() + "'" +
            ", recipes_clicksEntity='" + getRecipes_clicksEntity() + "'" +
            ", firebase='" + getFirebase() + "'" +
            "}";
    }


}
