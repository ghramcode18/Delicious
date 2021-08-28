// package delicious.delicious.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import delicious.delicious.repositories.RecipeRepo;
// import delicious.delicious.repositories.Recipe_StepsRepo;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import delicious.delicious.entities.RecipeEntity;
// import delicious.delicious.entities.Recipe_stepsEntity;
// import delicious.delicious.models.RecipeModel;
// import delicious.delicious.models.Recipe_StepsModel;
// @Service
// public class RecipeService {
//     @Autowired
//     RecipeRepo recipeRepo;

//     @Autowired
//     Recipe_StepsRepo recipe_StepsRepo;


//     public List <RecipeModel> sendRecipe ()
//     {
//       List <RecipeEntity>recipeEntities = recipeRepo.findAll();
  

//             if (recipeEntities.size()>0) {
//                 List <RecipeModel>RecipeModels = new ArrayList<>();

//                 for ( RecipeEntity rEntity:recipeEntities) {

//                     RecipeModel Model = new RecipeModel();
//                     Model.id(rEntity.getId())
//                     .name(rEntity.getName())
//                     .image(rEntity.getImage())
//                     .type(rEntity.getType())
//                     .price(rEntity.getPrice())
//                     .imgrate(rEntity.getImgrate())
//                     .recipe_steps(getrecipe_steps(rEntity.getSteps()));

//                     RecipeModels.add(Model);
                    
//                 }
//                 return RecipeModels;
                
//             }
//             else return new ArrayList<RecipeModel>();
    
//     }


//     private Recipe_stepsEntity getrecipe_steps(Recipe_stepsEntity recipe_steps) {
//      Optional<Recipe_stepsEntity> recipe_stepsEntity= recipe_StepsRepo.findById(recipe_steps.getId());
//      Recipe_StepsModel rModel =new Recipe_StepsModel();
//      rModel.id(recipe_steps.getId())
//      .descripion(recipe_steps.getDescripion())
//      .step_number(recipe_steps.getStep_Number());
 
//         return recipe_StepsModelToRecipe_stepEntity(rModel);
//     }
    

//     private Recipe_StepsModel recipe_stepEntityToRecipe_StepsModel( Recipe_stepsEntity recipe_steps)
//     {  Recipe_StepsModel rModel =new Recipe_StepsModel();
//         rModel.id(recipe_steps.getId())
//         .descripion(recipe_steps.getDescripion())
//         .step_number(recipe_steps.getStep_Number());

//         return rModel;


//     }
//     private Recipe_stepsEntity recipe_StepsModelToRecipe_stepEntity( Recipe_StepsModel recipe_steps)
//     {  Recipe_stepsEntity entity =new Recipe_stepsEntity();
//         entity.Id(recipe_steps.getId())
//         .Descripion(recipe_steps.getDescripion())
//          .step_Number (recipe_steps.getStep_number());
//         return entity;


//     }
//     /*
    
// private List<RoleModel> getRoleList(User user){
// 30
//     List<RoleModel> roleList = new ArrayList<>();
// 31
//     for(int i=0; i< user.getRoles().size(); i++) {
// 32
//         RoleModel roleModel = new RoleModel();
// 33
//         roleModel.setName(user.getRoles().get(i).getName());
// 34
//         roleModel.setDescription(user.getRoles().get(i).getDescription());
// 35
//         roleList.add(roleModel);
// 36
//     }
// 37
//     return roleList;
// 38
// }
//     13
// public List<UserModel > getUsers() {
// 14
//     List<User> userList = userRepository.findAll();
// 15
//     if(userList.size()>0) {
// 16
//         List<UserModel> userModels = new ArrayList<>();
// 17
//         for (User user : userList) {
// 18
//             UserModel model = new UserModel();
// 19
//             model.setFirstName(user.getFirstName());
// 20
//             model.setLastName(user.getLastName());
// 21
//             model.setMobile(user.getMobile());
// 22
//             model.setEmail(user.getEmail());
// 23
//             model.setRoles(getRoleList(user));
// 24
//             userModels.add(model);
// 25
//         }
// 26
//         return userModels;
// 27
//     } else return new ArrayList<UserModel>();
// 28
// }
//     */
// }
