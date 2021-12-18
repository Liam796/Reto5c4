package Reto4Ciclo4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto4Ciclo4.model.Peripheral;
import Reto4Ciclo4.repository.crud.PeripheralCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeripheralRepository {
    @Autowired
    private PeripheralCrudRepository peripheralCrudRepository;
    public List<Peripheral> getAll(){
        return peripheralCrudRepository.findAll();
    }
    public Optional<Peripheral> getPeripheral(String reference){
        return peripheralCrudRepository.findById(reference);
    }
    public Peripheral save(Peripheral peripheral){
        return peripheralCrudRepository.save(peripheral);
    }
    public void update(Peripheral peripheral){
        peripheralCrudRepository.save(peripheral);
    }
    public void delete(Peripheral peripheral){
        peripheralCrudRepository.delete(peripheral);
    }
    public List<Peripheral>getByPrice(double price){
       return peripheralCrudRepository.findByPrice(price);
    }

    public List<Peripheral>getByDescriptionContainingIgnoreCase(String description){
        return peripheralCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}



