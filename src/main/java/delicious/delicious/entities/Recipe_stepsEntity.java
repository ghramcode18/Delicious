package delicious.delicious.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Recipe_steps")
public class Recipe_steps {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = true)
    private Integer step_number;
    @Column(nullable = true)
    private String descripion;

    @OneToOne(mappedBy = "idRecipe_step")
    private RecipeEntity recipeEntity;

    public Recipe_steps() {
    }

    public Recipe_steps(Integer id, Integer step_number, String descripion, RecipeEntity recipeEntity) {
        this.id = id;
        this.step_number = step_number;
        this.descripion = descripion;
        this.recipeEntity = recipeEntity;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStep_number() {
        return this.step_number;
    }

    public void setStep_number(Integer step_number) {
        this.step_number = step_number;
    }

    public String getDescripion() {
        return this.descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public RecipeEntity getRecipeEntity() {
        return this.recipeEntity;
    }

    public void setRecipeEntity(RecipeEntity recipeEntity) {
        this.recipeEntity = recipeEntity;
    }

    public Recipe_steps id(Integer id) {
        setId(id);
        return this;
    }

    public Recipe_steps step_number(Integer step_number) {
        setStep_number(step_number);
        return this;
    }

    public Recipe_steps descripion(String descripion) {
        setDescripion(descripion);
        return this;
    }

    public Recipe_steps recipeEntity(RecipeEntity recipeEntity) {
        setRecipeEntity(recipeEntity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Recipe_steps)) {
            return false;
        }
        Recipe_steps recipe_steps = (Recipe_steps) o;
        return Objects.equals(id, recipe_steps.id) && Objects.equals(step_number, recipe_steps.step_number) && Objects.equals(descripion, recipe_steps.descripion) && Objects.equals(recipeEntity, recipe_steps.recipeEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, step_number, descripion, recipeEntity);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", step_number='" + getStep_number() + "'" +
            ", descripion='" + getDescripion() + "'" +
            ", recipeEntity='" + getRecipeEntity() + "'" +
            "}";
    }
  
}
