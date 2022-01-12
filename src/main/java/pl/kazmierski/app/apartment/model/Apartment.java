package pl.kazmierski.app.apartment.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.kazmierski.app.bookings.model.Bookings;
import pl.kazmierski.app.building.model.Building;

import javax.persistence.*;

@Entity
@Table(name = "apartment")
@Data
public class Apartment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "surface")
    private int surface;

    @Column(name = "number_of_rooms")
    private int number_of_rooms;
    @Column(name = "floor")
    private int floor;

    @ManyToOne
    @JoinColumn(name = "building")
    private Building buildings_number;

    @OneToOne(orphanRemoval = false, mappedBy = "apartment",cascade = CascadeType.REMOVE)
    private Bookings bookings;

    public Apartment() {
    }

    public Apartment(int surface, int number_of_rooms, int floor, Building buildings_number) {
        this.surface = surface;
        this.number_of_rooms = number_of_rooms;
        this.floor = floor;
        this.buildings_number = buildings_number;
    }
}

