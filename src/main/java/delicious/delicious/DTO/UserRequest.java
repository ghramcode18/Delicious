package delicious.delicious.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import delicious.delicious.entities.RecipeEntity;

public class UserRequest {
    private Integer id;
    private List < RecipeEntity> recipeEntity=new ArrayList<>();

    public UserRequest() {
    }

    public UserRequest(Integer id, List<RecipeEntity> recipeEntity) {
        this.id = id;
        this.recipeEntity = recipeEntity;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<RecipeEntity> getRecipeEntity() {
        return this.recipeEntity;
    }

    public void setRecipeEntity(List<RecipeEntity> recipeEntity) {
        this.recipeEntity = recipeEntity;
    }

    public UserRequest id(Integer id) {
        setId(id);
        return this;
    }

    public UserRequest recipeEntity(List<RecipeEntity> recipeEntity) {
        setRecipeEntity(recipeEntity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserRequest)) {
            return false;
        }
        UserRequest userRequest = (UserRequest) o;
        return Objects.equals(id, userRequest.id) && Objects.equals(recipeEntity, userRequest.recipeEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeEntity);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", recipeEntity='" + getRecipeEntity() + "'" +
            "}";
    }

    
}
