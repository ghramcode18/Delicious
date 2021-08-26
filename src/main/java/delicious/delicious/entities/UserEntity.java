package delicious.delicious.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table(name = "UserName")
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private String userName ;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password ;
    

    @ManyToMany
    @JoinTable(
    name = "user_recipe", 
    joinColumns = @JoinColumn(name = "student_id"), 
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<RecipeEntity> likedCourses;

    // @ManyToOne
    // @JoinTable(name="user_recipe"
    // ,joinColumns = @JoinColumn("user_id")
    // ,inverseJoinColumns = @JoinColumns("user_id"))
    // private Set <RecipeEntity>recipeEntities= new HashSet<>()<>();
    

    @OneToMany(mappedBy = "user")
    private List<FireBaseEntity> firebase;




    
}
