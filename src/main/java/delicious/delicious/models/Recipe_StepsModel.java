// package delicious.delicious.models;

// import java.util.Objects;

// import delicious.delicious.entities.RecipeEntity;

// public class Recipe_StepsModel {
 
//     private Integer id;
//     private Integer step_number;
//     private String descripion;
//     private RecipeEntity recipeEntity;



//     public Recipe_StepsModel() {
//     }

//     public Recipe_StepsModel(Integer id, Integer step_number, String descripion, RecipeEntity recipeEntity) {
//         this.id = id;
//         this.step_number = step_number;
//         this.descripion = descripion;
//         this.recipeEntity = recipeEntity;
//     }

//     public Integer getId() {
//         return this.id;
//     }

//     public void setId(Integer id) {
//         this.id = id;
//     }

//     public Integer getStep_number() {
//         return this.step_number;
//     }

//     public void setStep_number(Integer step_number) {
//         this.step_number = step_number;
//     }

//     public String getDescripion() {
//         return this.descripion;
//     }

//     public void setDescripion(String descripion) {
//         this.descripion = descripion;
//     }

//     public RecipeEntity getRecipeEntity() {
//         return this.recipeEntity;
//     }

//     public void setRecipeEntity(RecipeEntity recipeEntity) {
//         this.recipeEntity = recipeEntity;
//     }

//     public Recipe_StepsModel id(Integer id) {
//         setId(id);
//         return this;
//     }

//     public Recipe_StepsModel step_number(Integer step_number) {
//         setStep_number(step_number);
//         return this;
//     }

//     public Recipe_StepsModel descripion(String descripion) {
//         setDescripion(descripion);
//         return this;
//     }

//     public Recipe_StepsModel recipeEntity(RecipeEntity recipeEntity) {
//         setRecipeEntity(recipeEntity);
//         return this;
//     }

//     @Override
//     public boolean equals(Object o) {
//         if (o == this)
//             return true;
//         if (!(o instanceof Recipe_StepsModel)) {
//             return false;
//         }
//         Recipe_StepsModel recipeStepsModel = (Recipe_StepsModel) o;
//         return Objects.equals(id, recipeStepsModel.id) && Objects.equals(step_number, recipeStepsModel.step_number) && Objects.equals(descripion, recipeStepsModel.descripion) && Objects.equals(recipeEntity, recipeStepsModel.recipeEntity);
//     }

//     @Override
//     public int hashCode() {
//         return Objects.hash(id, step_number, descripion, recipeEntity);
//     }

//     @Override
//     public String toString() {
//         return "{" +
//             " id='" + getId() + "'" +
//             ", step_number='" + getStep_number() + "'" +
//             ", descripion='" + getDescripion() + "'" +
//             ", recipeEntity='" + getRecipeEntity() + "'" +
//             "}";
//     }

  
    
// }
