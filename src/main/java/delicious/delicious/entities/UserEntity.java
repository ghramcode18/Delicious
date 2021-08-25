package delicious.delicious.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @OneToMany(mappedBy = "uEntity" ,cascade = CascadeType.ALL , orphanRemoval = true)
    List<FavoriteEntity> favorite;


    @OneToMany(mappedBy = "user")
    private List<FireBaseEntity> firebase;




    
}
