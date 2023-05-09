package com.koussay.jeux.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.koussay.jeux.dto.JeuDTO;
import com.koussay.jeux.entities.Entreprise;
import com.koussay.jeux.entities.Jeu;
import com.koussay.jeux.repos.EntrepriseRepository;
import com.koussay.jeux.repos.JeuRepository;

@Service
public class JeuServiceImpl implements JeuService {
@Autowired
JeuRepository jeuRepository;

@Autowired
ModelMapper modelMapper;

@Autowired
EntrepriseRepository entrepriseRepository;
@Override
public JeuDTO saveJeu(JeuDTO j) {
return convertEntityToDto(jeuRepository.save(convertDtoToEntity(j)));
}
@Override
public JeuDTO updateJeu(JeuDTO j) {
return  convertEntityToDto(jeuRepository.save(convertDtoToEntity(j)));
}
@Override
public void deleteJeu(Jeu j) {
jeuRepository.delete(j);
}
 @Override
public void deleteJeuById(Long id) {
jeuRepository.deleteById(id);
}
@Override
public JeuDTO getJeu(Long id) {
return convertEntityToDto(jeuRepository.findById(id).get());
}
@Override
public List<JeuDTO> getAllJeux() {
return jeuRepository.findAll().stream()
		.map(this::convertEntityToDto)
		.collect(Collectors.toList());
}
@Override
public Page<Jeu> getAllJeuxParPage(int page, int size) {
	return jeuRepository.findAll(PageRequest.of(page, size));

}
@Override
public List<Jeu> findByTitre(String nom) {
	
	return jeuRepository.findByTitre(nom);
}
@Override
public List<Jeu> findByTitreContains(String nom) {
	
	return jeuRepository.findByTitreContains(nom);
}
@Override
public List<Jeu> findByTitreTaille(String titre, Double taille) {
	return jeuRepository.findByTitreTaille(titre, taille);
}
@Override
public List<Jeu> findByEntreprise(Entreprise entreprise) {
	
	return jeuRepository.findByEntreprise(entreprise);
}
@Override
public List<Jeu> findByEntrepriseIdEnt(Long id) {
	return jeuRepository.findByEntrepriseIdEnt(id);
}
@Override
public List<Jeu> findByOrderByTitreAsc() {
	
	return jeuRepository.findByOrderByTitreAsc();
}
@Override
public List<Jeu> trierJeuxTitresTaille() {
	return jeuRepository.trierJeuxTitresTaille();
}
@Override
public List<Entreprise> getAllEntreprises() {
	return entrepriseRepository.findAll();
}
@Override
public JeuDTO convertEntityToDto(Jeu jeu) {
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

	JeuDTO jeuDTO = modelMapper.map(jeu, JeuDTO.class);
	 return jeuDTO; 
	
	/*JeuDTO jeuDTO = new JeuDTO();
	jeuDTO.setIdJeu(jeu.getIdJeu());
	jeuDTO.setTitre(jeu.getTitre());
	jeuDTO.setTaille(jeu.getTaille());
	jeuDTO.setNiveauDifficulte(jeu.getNiveauDifficulte());
	jeuDTO.setDateCreation(jeu.getDateCreation());
	jeuDTO.setEntreprise(jeu.getEntreprise());
	 return jeuDTO;*/
	 
	/* return JeuDTO.builder()
	 .idJeu(jeu.getIdJeu())
	 .titre(jeu.getTitre())
	 .taille(jeu.getTaille())
	 .niveauDifficulte(jeu.getNiveauDifficulte())
	 .dateCreation(jeu.getDateCreation())
	 .entreprise(jeu.getEntreprise())
	 .build();*/ 
}
@Override
public Jeu convertDtoToEntity(JeuDTO jeuDto) {
	Jeu jeu = new Jeu();
	jeu = modelMapper.map(jeuDto, Jeu.class);
return jeu;
	/*jeu.setIdJeu(jeuDto.getIdJeu());
	jeu.setTitre(jeuDto.getTitre());
	jeu.setTaille(jeuDto.getTaille());
	jeu.setNiveauDifficulte(jeuDto.getNiveauDifficulte());
	jeu.setDateCreation(jeuDto.getDateCreation());
	jeu.setEntreprise(jeuDto.getEntreprise());
	 return jeu; */
}
}