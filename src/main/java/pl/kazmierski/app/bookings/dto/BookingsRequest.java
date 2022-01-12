package pl.kazmierski.app.bookings.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookingsRequest {

    public String name;
    public String surname;
    public String email;
    public String pesel_number;
    public Long number_of_apartment;


}
