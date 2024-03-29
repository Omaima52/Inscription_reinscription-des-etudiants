package com.gsnotes.bo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Niveau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNiveau;

	private String alias;

	private String titre;
	
	
//	@OneToMany(mappedBy = "niveau", cascade = CascadeType.ALL, targetEntity = Etudiant.class)
//	private List<Etudiant> etudiants;

	@OneToMany(mappedBy = "niveau" , cascade = CascadeType.ALL, targetEntity = Module.class)
	private List<Module> modules;

	@OneToMany(mappedBy = "niveau" , cascade = CascadeType.ALL, targetEntity = InscriptionAnnuelle.class, fetch = FetchType.EAGER)
	private List<InscriptionAnnuelle> inscriptions;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "niveauSuivant", referencedColumnName = "idNiveau")
	private Niveau niveauSuivant;

	@ManyToOne
	@JoinColumn(name="idFiliere")
	private Filiere filiere;

	public Long getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

//	public List<Etudiant> getEtudiants() {
//		return etudiants;
//	}
//
//	public void setEtudiants(List<Etudiant> etudiants) {
//		this.etudiants = etudiants;
//	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<InscriptionAnnuelle> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<InscriptionAnnuelle> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	
	
}