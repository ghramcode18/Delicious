package delicious.delicious.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "RecipeEntity")
public class RecipeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String image ;

    @Column(nullable = true)
    private double price ;

    @Column(nullable = true)
    private String type ;

    @OneToOne
    private Recipe_stepsEntity steps ;

    @Column(nullable = true)
    private String imgrate;

    @ManyToMany (mappedBy = "RecipeEntity")
    private List <UserEntity>user_favorite;
   
    @ManyToMany (mappedBy = "RecipeEntity")
    private List <UserEntity>user_clike;

  //  (mappedBy = "id_recipeSteps_id")
     @OneToOne
     private Recipe_stepsEntity recipe_steps;

    


}
