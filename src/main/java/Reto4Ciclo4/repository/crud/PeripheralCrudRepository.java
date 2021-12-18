package Reto4Ciclo4.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;
import Reto4Ciclo4.model.Peripheral;

import java.util.List;

public interface PeripheralCrudRepository extends MongoRepository<Peripheral, String> {
    public List<Peripheral>findByPrice(double price);

    public List<Peripheral>findByDescriptionContainingIgnoreCase(String description);
}



