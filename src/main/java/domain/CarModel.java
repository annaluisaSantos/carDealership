package domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CarModel {

    @Id
    private Long id;
    private String name;
    private CarBrand carBrand;

    public CarModel(Long id, String name, CarBrand carBrand) {
        this.id = id;
        this.name = name;
        this.carBrand = carBrand;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }
}
