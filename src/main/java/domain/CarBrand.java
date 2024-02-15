package domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CarBrand {
    @Id
    private Long id;
    private String name;

    public CarBrand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
