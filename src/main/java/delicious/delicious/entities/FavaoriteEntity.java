package delicious.delicious.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favorite")
public class FavaoriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;



    
}
