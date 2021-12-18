package Reto4Ciclo4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Reto4Ciclo4.model.Peripheral;
import Reto4Ciclo4.repository.PeripheralRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeripheralService {
    @Autowired
    private PeripheralRepository peripheralRepository;

    public List<Peripheral>getAll(){
        return peripheralRepository.getAll();
    }

    public Optional<Peripheral>getPeripheral(String reference) {
        return peripheralRepository.getPeripheral(reference);
    }
    public Peripheral save(Peripheral peripheral){
        if (peripheral.getReference()==null){
            return peripheral;
        }
        return peripheralRepository.save(peripheral);
    }

    public Peripheral update(Peripheral peripheral){
        if (peripheral.getReference()!=null){
            Optional<Peripheral>dbPeripheral=peripheralRepository.getPeripheral(peripheral.getReference());
            if (!dbPeripheral.isEmpty()){
                if (peripheral.getBrand()!=null) {
                    dbPeripheral.get().setBrand(peripheral.getBrand());
                }
                if (peripheral.getCategory()!=null){
                    dbPeripheral.get().setCategory(peripheral.getCategory());
                }
                if (peripheral.getDescription()!=null){
                    dbPeripheral.get().setDescription(peripheral.getDescription());
                }

                dbPeripheral.get().setAvailability(peripheral.isAvailability());

                if (peripheral.getPrice()!=0.0){
                    dbPeripheral.get().setPrice(peripheral.getPrice());
                }
                if (peripheral.getQuantity()!=0){
                    dbPeripheral.get().setQuantity(peripheral.getQuantity());
                }
                if (peripheral.getPhotography()!=null){
                    dbPeripheral.get().setPhotography(peripheral.getPhotography());
                }
                peripheralRepository.update(dbPeripheral.get());
                return dbPeripheral.get();
            }else
                return peripheral;
        }else{
            return peripheral;
        }
    }
    public boolean delete(String reference){
        return getPeripheral(reference).map(peripheral -> {
            peripheralRepository.delete(peripheral);
            return true;
        }).orElse(false);
    }

    public List<Peripheral>getByPrice(double price){
        return peripheralRepository.getByPrice(price);
    }
    public List<Peripheral>getByDescriptionContainingIgnoreCase(String description){
        return peripheralRepository.getByDescriptionContainingIgnoreCase(description);
    }



}
