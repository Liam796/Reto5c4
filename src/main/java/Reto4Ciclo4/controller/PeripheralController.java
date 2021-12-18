package Reto4Ciclo4.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import Reto4Ciclo4.model.Peripheral;
import Reto4Ciclo4.service.PeripheralService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peripherals")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PeripheralController {
    @Autowired
    private PeripheralService peripheralService;

    @GetMapping("/all")
    public List<Peripheral> getAll(){
        return peripheralService.getAll();
    }
    @GetMapping("/{reference}")
    public Optional<Peripheral> getPeripheral(@PathVariable("reference") String reference) {
        return peripheralService.getPeripheral(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral save (@RequestBody Peripheral peripheral){
        return peripheralService.save(peripheral);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral update(@RequestBody Peripheral peripheral) {
        return peripheralService.update(peripheral);
    }
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return peripheralService.delete(reference);
    }
    @GetMapping("/price/{price}")
    public List<Peripheral>getByPrice(@PathVariable("price")double price){
        return peripheralService.getByPrice(price);
    }
    @GetMapping("/description/{description}")
    public List<Peripheral>getByByDescriptionContainingIgnoreCase(@PathVariable("description") String description){
        return peripheralService.getByDescriptionContainingIgnoreCase(description);
    }

}

