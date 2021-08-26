
package delicious.delicious.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import delicious.delicious.entities.Recipe_stepsEntity;
import delicious.delicious.models.Recipe_StepsModel;


@Mapper
public interface Recipe_stepsMapper 
{//CAN I PUT ALL OF MAPPERIN ONE CLASSE?
    Recipe_stepsMapper INSTANCE = Mappers.getMapper(Recipe_stepsMapper.class);
    @Mapping (source = "",target = "")
    Recipe_stepsEntity Recipe_StepsModelToRecipe_StepsEntity(Recipe_StepsModel Recipe_StepsModel);
    Recipe_StepsModel Recipe_StepsEntityToRecipe_StepsModel(Recipe_stepsEntity Recipe_stepsEntity);
    List<Recipe_stepsEntity> Recipe_StepsModelToRecipe_StepsEntityAslist(List<Recipe_StepsModel> Recipe_StepsModel);
    List<Recipe_StepsModel> Recipe_StepsEntityToRecipe_StepsModelAsList(List<Recipe_stepsEntity> Recipe_StepsEntities);

}
 
// //source the name in Entity and target the name in Model.

