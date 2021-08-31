package delicious.delicious.models;

import java.util.List;
import java.util.Objects;

import delicious.delicious.entities.RecipeEntity;

public class UserModel {
    private Integer id;
    private String name ;
    private String email;
    private String password ;
    // private List  <RecipeEntity>recipe_favoriteModel;
  // private List  <RecipeEntity>recipes_clicksModel;


    public UserModel() {
    }

    public UserModel(Integer id, String name, String email, String passwordl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
      
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

    // public List<RecipeEntity> getRecipe_favoriteModel() {
    //     return this.recipe_favoriteModel;
    // }

    // public void setRecipe_favoriteModel(List<RecipeEntity> recipe_favoriteModel) {
    //     this.recipe_favoriteModel = recipe_favoriteModel;
    // }

   
    

   

    public UserModel id(Integer id) {
        setId(id);
        return this;
    }

    public UserModel name(String name) {
        setName(name);
        return this;
    }

    public UserModel email(String email) {
        setEmail(email);
        return this;
    }

    public UserModel password(String password) {
        setPassword(password);
        return this;
    }

    // public UserModel recipe_favoriteModel(List<RecipeEntity> recipe_favoriteModel) {
    //     setRecipe_favoriteModel(recipe_favoriteModel);
    //     return this;
    // }

  
    // @Override
    // public boolean equals(Object o) {
    //     if (o == this)
    //         return true;
    //     if (!(o instanceof UserModel)) {
    //         return false;
    //     }
    //     UserModel userModel = (UserModel) o;
    //     return Objects.equals(id, userModel.id) && Objects.equals(name, userModel.name) && Objects.equals(email, userModel.email) && Objects.equals(password, userModel.password) && Objects.equals(recipe_favoriteModel, userModel.recipe_favoriteModel) );
    // }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            
            
            "}";
    }

}
