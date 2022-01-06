package pl.kazmierski.app.building.model;



import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "building")
@Data
public class Building{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name = "apartments_number")
    private int apartments_number;
    @Column(name = "surface")
    private int surface;

    @Column(name = "file_path")
    private String filePath;

    public Building(String name, int apartments_number, int surface) {
        this.name = name;
        this.apartments_number = apartments_number;
        this.surface = surface;
    }


    public Building() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
