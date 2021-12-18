package Reto4Ciclo4.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "peripheral")
public class Peripheral {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String description;
    private boolean availability;
    private double price;
    private Integer quantity;
    private String photography;

}