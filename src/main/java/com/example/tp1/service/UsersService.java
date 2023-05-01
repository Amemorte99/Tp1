package com.example.tp1.service;

import com.example.tp1.entities.Users;
import com.example.tp1.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsersService {
    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public Users getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public List<Users> getAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


    public Users updateUser(Long id, Users userDto) throws  Exception {
        Optional<Users> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new Exception("User not found with id: " + id);
        }
        Users user = optionalUser.get();
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setDateNaissance(userDto.getDateNaissance());
        user.setGenre(userDto.getGenre());
        user.setEmail(userDto.getEmail());
        user.setAdresse(userDto.getAdresse());
        user.setTel(userDto.getTel());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return user;
    }

}

