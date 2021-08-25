package delicious.delicious.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "favorite_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore 
    private FavoriteEntity fEntity;



}
