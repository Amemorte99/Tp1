package com.example.tp1.service;


import com.example.tp1.entities.Tache;
import com.example.tp1.repo.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TacheService {
    private final TacheRepository tacheRepository;

    @Autowired
    public TacheService(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    public Tache save(Tache tache) {
        return tacheRepository.save(tache);
    }

    public Tache getById(Integer id) {
        return tacheRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tache not found"));
    }

    public List<Tache> getAll() {
        return tacheRepository.findAll();
    }

    public void deleteById(Integer id) {
        tacheRepository.deleteById(id);
    }
    public Tache updateTache(Integer id, Tache tache) {
        Tache existingTache = tacheRepository.findById(id)
                .orElseThrow(null);

        existingTache.setNom(tache.getNom());
        existingTache.setDateDebut(tache.getDateDebut());
        existingTache.setDateFin(tache.getDateFin());
        existingTache.setTauxAvancement(tache.getTauxAvancement());
        existingTache.setResponsable(tache.getResponsable());

        Tache updatedTache = tacheRepository.save(existingTache);
        return updatedTache;
    }
}

