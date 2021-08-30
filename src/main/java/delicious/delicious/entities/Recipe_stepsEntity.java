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
@Table(name = "recipe_steps")
public class Recipe_stepsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(nullable = true)
    private Integer step_Number;
    @Column(nullable = true)
    private String Descripion;
    @OneToOne
    private RecipeEntity recipe;

    public Recipe_stepsEntity() {
    }

    public Recipe_stepsEntity(Integer Id, Integer step_Number, String Descripion, RecipeEntity recipe) {
        this.Id = Id;
        this.step_Number = step_Number;
        this.Descripion = Descripion;
        this.recipe = recipe;
    }

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getStep_Number() {
        return this.step_Number;
    }

    public void setStep_Number(Integer step_Number) {
        this.step_Number = step_Number;
    }

    public String getDescripion() {
        return this.Descripion;
    }

    public void setDescripion(String Descripion) {
        this.Descripion = Descripion;
    }

    public RecipeEntity getRecipe() {
        return this.recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public Recipe_stepsEntity Id(Integer Id) {
        setId(Id);
        return this;
    }

    public Recipe_stepsEntity step_Number(Integer step_Number) {
        setStep_Number(step_Number);
        return this;
    }

    public Recipe_stepsEntity Descripion(String Descripion) {
        setDescripion(Descripion);
        return this;
    }

    public Recipe_stepsEntity recipe(RecipeEntity recipe) {
        setRecipe(recipe);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Recipe_stepsEntity)) {
            return false;
        }
        Recipe_stepsEntity recipe_stepsEntity = (Recipe_stepsEntity) o;
        return Objects.equals(Id, recipe_stepsEntity.Id) && Objects.equals(step_Number, recipe_stepsEntity.step_Number) && Objects.equals(Descripion, recipe_stepsEntity.Descripion) && Objects.equals(recipe, recipe_stepsEntity.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, step_Number, Descripion, recipe);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", step_Number='" + getStep_Number() + "'" +
            ", Descripion='" + getDescripion() + "'" +
            ", recipe='" + getRecipe() + "'" +
            "}";
    }

}
