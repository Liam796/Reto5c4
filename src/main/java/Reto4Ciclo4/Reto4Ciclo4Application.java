package Reto4Ciclo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Reto4Ciclo4.repository.crud.OrderCrudRepository;
import Reto4Ciclo4.repository.crud.PeripheralCrudRepository;
import Reto4Ciclo4.repository.crud.UserCrudRepository;

@SpringBootApplication
public class Reto4Ciclo4Application implements CommandLineRunner {


        @Autowired
        private PeripheralCrudRepository peripheralRepository;

        @Autowired
        private UserCrudRepository userRepository;

        @Autowired
        private OrderCrudRepository orderRepository;

        public static void main(String[] args) {SpringApplication.run(Reto4Ciclo4Application.class, args);}

    @Override
    public void run(String... args) throws Exception {
     userRepository.deleteAll();
     peripheralRepository.deleteAll();
     orderRepository.deleteAll();

    }
}
