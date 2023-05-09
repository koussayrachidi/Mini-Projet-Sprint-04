package com.koussay.jeux.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.koussay.jeux.dto.JeuDTO;
import com.koussay.jeux.entities.Entreprise;
import com.koussay.jeux.entities.Jeu;
public interface JeuService {
JeuDTO saveJeu(JeuDTO j);
JeuDTO updateJeu(JeuDTO j);

JeuDTO getJeu(Long id);
List<JeuDTO> getAllJeux();

void deleteJeu(Jeu j);
 void deleteJeuById(Long id);
List<Entreprise> getAllEntreprises();



Page<Jeu> getAllJeuxParPage(int page, int size);

List<Jeu> findByTitre(String nom);
List<Jeu> findByTitreContains(String nom);
List<Jeu> findByTitreTaille (String titre, Double taille);
List<Jeu> findByEntreprise (Entreprise entreprise);
List<Jeu> findByEntrepriseIdEnt(Long id);
List<Jeu> findByOrderByTitreAsc();
List<Jeu> trierJeuxTitresTaille();

JeuDTO convertEntityToDto (Jeu jeu);
Jeu convertDtoToEntity(JeuDTO jeuDto);

}
