package delicious.delicious.models;

import java.util.List;
import java.util.Objects;

import delicious.delicious.entities.Recipe_stepsEntity;
import delicious.delicious.entities.UserEntity;

public class RecipeFavModel {
    private Integer id;
    private String name;
    private String image ;
    private double price ;
    private String type ;
    private String imgrate;
    private Recipe_stepsEntity steps ;

    public RecipeFavModel() {
    }

    public RecipeFavModel(Integer id, String name, String image, double price, String type, String imgrate, Recipe_stepsEntity steps) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.type = type;
        this.imgrate = imgrate;
        this.steps = steps;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgrate() {
        return this.imgrate;
    }

    public void setImgrate(String imgrate) {
        this.imgrate = imgrate;
    }

    public Recipe_stepsEntity getSteps() {
        return this.steps;
    }

    public void setSteps(Recipe_stepsEntity steps) {
        this.steps = steps;
    }

    public RecipeFavModel id(Integer id) {
        setId(id);
        return this;
    }

    public RecipeFavModel name(String name) {
        setName(name);
        return this;
    }

    public RecipeFavModel image(String image) {
        setImage(image);
        return this;
    }

    public RecipeFavModel price(double price) {
        setPrice(price);
        return this;
    }

    public RecipeFavModel type(String type) {
        setType(type);
        return this;
    }

    public RecipeFavModel imgrate(String imgrate) {
        setImgrate(imgrate);
        return this;
    }

    public RecipeFavModel steps(Recipe_stepsEntity steps) {
        setSteps(steps);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RecipeFavModel)) {
            return false;
        }
        RecipeFavModel recipeFavModel = (RecipeFavModel) o;
        return Objects.equals(id, recipeFavModel.id) && Objects.equals(name, recipeFavModel.name) && Objects.equals(image, recipeFavModel.image) && price == recipeFavModel.price && Objects.equals(type, recipeFavModel.type) && Objects.equals(imgrate, recipeFavModel.imgrate) && Objects.equals(steps, recipeFavModel.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, price, type, imgrate, steps);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", image='" + getImage() + "'" +
            ", price='" + getPrice() + "'" +
            ", type='" + getType() + "'" +
            ", imgrate='" + getImgrate() + "'" +
            ", steps='" + getSteps() + "'" +
            "}";
    }

}
