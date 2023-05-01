package com.example.tp1.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.util.ArrayList;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;



    @Column(nullable = true)
    private String nom;

    @Column(nullable = true)
    private String prenom;



    @Column(nullable = true)
    private String dateNaissance;

    @Column(nullable = true)
    private String genre;



    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String adresse;

    @Column(nullable = true)
    private String tel;


    @Column(name = "ACTIF")
    private Boolean actif = false;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

   @Column
    private Boolean isNotLocked = true;

    @Column
    private Boolean isActive = false;

    @Column
    private Boolean etat = true;


    private List<Tache> tacheList;

    @CreationTimestamp
    @Column(nullable = false)
    private Date dateCreate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date dateUpdate;








    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "idRole"))
    @ManyToMany
    @ToString.Exclude
    private Collection<Role> roles = new ArrayList<>();



}
