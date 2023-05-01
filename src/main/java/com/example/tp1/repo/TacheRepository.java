package com.example.tp1.repo;

import com.example.tp1.entities.Tache;
import com.example.tp1.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Integer> {
    List<Tache> findByResponsable(Users responsable);
}
