package delicious.delicious.models;

import java.util.List;
import java.util.Objects;

public class ResDTO {
    private  String name;
    private  String type ;
    // List <RecipeModel>meals;
    // List <RecipeModel>salades;
    // List <RecipeModel>pizza;
    // List <RecipeModel>sandwishes;


    public ResDTO() {
    }

    public ResDTO(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResDTO name(String name) {
        setName(name);
        return this;
    }

    public ResDTO type(String type) {
        setType(type);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ResDTO)) {
            return false;
        }
        ResDTO resDTO = (ResDTO) o;
        return Objects.equals(name, resDTO.name) && Objects.equals(type, resDTO.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

   
}
