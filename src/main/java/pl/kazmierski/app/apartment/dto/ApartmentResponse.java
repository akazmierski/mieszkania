package pl.kazmierski.app.apartment.dto;

import lombok.Data;

@Data
public class ApartmentResponse {
    private int surface;
    private int number_of_rooms;
    private int floor;
    private Long buildings_number;
    private long id;
}
