package pl.kazmierski.app.building.dto;


import lombok.Data;

@Data
public class BuildingResponse{
    private long id;
    private String name;
    private int apartments_number;
    private int surface;


}
