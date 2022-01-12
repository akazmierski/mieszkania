package pl.kazmierski.app.bookings.model;

import lombok.Data;
import org.springframework.stereotype.Controller;
import pl.kazmierski.app.apartment.model.Apartment;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bookings")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "pesel_number")
    private String pesel_number;

    @OneToOne()
    @JoinColumn(name = "apartment", referencedColumnName = "id")
    private Apartment apartment;

    public Bookings(String name, String surname, String email, String pesel_number, Apartment apartment) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.pesel_number = pesel_number;
        this.apartment = apartment;
    }

    public Bookings() {


    }
}
