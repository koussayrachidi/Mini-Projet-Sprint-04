package com.koussay.jeux.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koussay.jeux.entities.Entreprise;
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long>{

}