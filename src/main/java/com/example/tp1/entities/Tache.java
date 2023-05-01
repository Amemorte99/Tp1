package com.example.tp1.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tache {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private float tauxAvancement;
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Users responsable;
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
}
