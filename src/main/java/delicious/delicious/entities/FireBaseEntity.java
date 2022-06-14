package delicious.delicious.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="firebase")
public class FireBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @ManyToOne(optional=true,targetEntity = UserEntity.class)
    private UserEntity user;

    @Column(nullable = false)
    private String token;



    public FireBaseEntity() {
    }

    public FireBaseEntity(Integer id, UserEntity user, String token) {
        this.id = id;
        this.user = user;
        this.token = token;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public FireBaseEntity id(Integer id) {
        setId(id);
        return this;
    }

    public FireBaseEntity user(UserEntity user) {
        setUser(user);
        return this;
    }

    public FireBaseEntity token(String token) {
        setToken(token);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FireBaseEntity)) {
            return false;
        }
        FireBaseEntity fiberBaseEntity = (FireBaseEntity) o;
        return Objects.equals(id, fiberBaseEntity.id) && Objects.equals(user, fiberBaseEntity.user) && Objects.equals(token, fiberBaseEntity.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, token);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", token='" + getToken() + "'" +
            "}";
    }

    
}
