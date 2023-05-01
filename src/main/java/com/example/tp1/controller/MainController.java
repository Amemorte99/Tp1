package com.example.tp1.controller;

import com.example.tp1.entities.Tache;
import com.example.tp1.entities.Users;
import com.example.tp1.service.TacheService;
import com.example.tp1.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class MainController {

    @RestController
    @RequestMapping("/users")
    public class UsersController {

        private final UsersService userService;

        public UsersController(UsersService userService) {
            this.userService = userService;
        }

        @GetMapping("/{id}")
        public ResponseEntity<Users> getUserById(@PathVariable Long id) {
            Users userDTO = userService.getById(id);
            if (userDTO == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(userDTO);
            }
        }

        @PostMapping
        public ResponseEntity<Users> createUser(@RequestBody Users userDTO) {
            Users savedUserDTO = userService.save(userDTO);
            if (savedUserDTO == null) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users userDTO) throws Exception {
            Users updatedUserDTO = userService.updateUser(id, userDTO);
            if (updatedUserDTO == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(updatedUserDTO);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

    }

    @RestController
    @RequestMapping("/taches")
    public class TacheController {

        private final TacheService tacheService;

        public TacheController(TacheService tacheService) {
            this.tacheService = tacheService;
        }

        @GetMapping("/{id}")
        public ResponseEntity<Tache> getTacheById(@PathVariable Integer id) {
            Tache tacheDTO = tacheService.getById(id);
            if (tacheDTO == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(tacheDTO);
            }
        }

        @PostMapping
        public ResponseEntity<Tache> createTache(@RequestBody Tache tacheDTO) {
            Tache savedTacheDTO = tacheService.save(tacheDTO);
            if (savedTacheDTO == null) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(savedTacheDTO);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<Tache> updateTache(@PathVariable Integer id, @RequestBody Tache tacheDTO) {
            Tache updatedTacheDTO = tacheService.updateTache(id, tacheDTO);
            if (updatedTacheDTO == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(updatedTacheDTO);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTache(@PathVariable Integer id) {
            tacheService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

    }

}
