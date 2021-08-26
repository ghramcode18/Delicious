package delicious.delicious.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


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

    @Column(nullable = true)
    private String steps ;

    @Column(nullable = true)
    private String imgrate;

    @ManyToMany 
    private boolean favaorite
    ;
    @ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "users_in_board", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
        @JoinColumn(name = "board_id") })
    List<FavaoriteEntity> favaoriteEntities;

   
}
