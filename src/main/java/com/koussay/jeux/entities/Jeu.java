package com.koussay.jeux.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Jeu {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idJeu;
@NotNull
@Size (min = 2,max = 40)
private String titre;
@Min(value = 5)
@Max(value = 10000)
private Double taille;
private String niveauDifficulte;

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateCreation;
@ManyToOne
private Entreprise entreprise;
public Jeu() {
super();
}
public Jeu(String titre, Double taille,String niveauDifficulte, Date dateCreation) {
super();
this.titre = titre;
this.taille = taille;
this.niveauDifficulte = niveauDifficulte;
this.dateCreation = dateCreation;
}
public Long getIdJeu() {
return idJeu;
}
public void setIdJeu(Long idJeu) {
this.idJeu = idJeu;
}
public String getTitre() {
return titre;
}
public void setTitre(String titre) {
this.titre = titre;
}
public Double getTaille() {
return taille;
}
public void setTaille(Double taille) {
this.taille = taille;
}

public String getNiveauDifficulte() {
return niveauDifficulte;
}
public void setNiveauDifficulte(String niveauDifficulte) {
this.niveauDifficulte = niveauDifficulte;
}

public Date getDateCreation() {
return dateCreation;
}
public void setDateCreation(Date dateCreation) {
this.dateCreation = dateCreation;
}

@Override
public String toString() {
return "Jeu [idJeu=" + idJeu + ", titre=" +
titre + ", taille=" + taille + ", niveauDifficulte=" + niveauDifficulte
+ ", dateCreation=" + dateCreation + "]";
}
public Entreprise getEntreprise() {
	return entreprise;
}
public void setEntreprise(Entreprise entreprise) {
	this.entreprise = entreprise;
}
}
