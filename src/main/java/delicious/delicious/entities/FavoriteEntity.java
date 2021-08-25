package delicious.delicious.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Favorite")
public class FavoriteEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

                    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore 
    private UserEntity uEntity;

    @OneToMany(mappedBy = "favorite" ,cascade = CascadeType.ALL , orphanRemoval = true)
    List<RecipeEntity> recipeEntities;

    


}
