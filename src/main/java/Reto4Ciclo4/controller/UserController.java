package Reto4Ciclo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import Reto4Ciclo4.model.User;
import Reto4Ciclo4.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

    /**
     *
     * @author Angie
     */
    public class UserController {
        /**
         * Variable que representa el servicio de Usuario
         */
        @Autowired
        private UserService userService;
        /**
         * Método para obtener el listado de Usuarios existentes
         *
         * @return listado de Usuarios formato JSON
         */

        @GetMapping("/all")
        public List<User> getAll(){
            return userService.getAll();
        }
        /**
         * Método para obtener el listado de Usuarios existentes
         *
         */
        @GetMapping("/{id}")
        public Optional<User> getUser(@PathVariable("id") Integer id) {
            return userService.getUser(id);
        }
    /**
     * Método para crear un Usuario
     *
     */
        @PostMapping("/new")
        @ResponseStatus(HttpStatus.CREATED)
        public User save(@RequestBody User user){
            return userService.save(user);
        }
        /**
         * Método para actualizar un Usuario
         *
         */
        @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
        public  User update(@RequestBody User user){
            return userService.update(user);
        }
        /**
         * Método para borrar un Usuario
         *
         */
        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public boolean delete(@PathVariable("id") int id){
            return userService.delete(id);
        }
        /**
         * Método para Consultar un Email
         *
         * @param email Consultado
         * @return Usuario en formato JSON
         */
        @GetMapping("/{email}/{password}")
        public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
            return userService.authenticateUser(email,password);
        }

        /**
         * Método para Consultar un email y password Usuario
         *
         */
        @GetMapping("/emailExist/{email}")
        public boolean emailExists (@PathVariable("email") String email){
            return userService.emailExists(email);
        }

        @GetMapping("/birthday/{monthBirthDay}")
        public List<User>getByMonthBirthtDay(@PathVariable("monthBirthDay")String monthBirthDay){
            return userService.getByMonthBirthDay(monthBirthDay);
        }
    }


