package pl.kazmierski.app.apartment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ApartmentValidator {
    public List<String> list;
    public String reason;

    public ApartmentValidator(List<String> list, String reason) {
        this.list = list;
        this.reason = reason;
    }
}
