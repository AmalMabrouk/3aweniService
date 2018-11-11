package aaweni.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@XmlRootElement
@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@Table(name = "User")
public class User  implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	int id;
	@Column(name = "User_NOM")
	String nom;
	@Column(name = "User_PRENOM")
	String prenom;
	@Column(name = "User_ADRESS_MAIL")
	String adresseMail;
	@Column(name = "User_CIN")
	String cin;
	@Column(name = "User_password")
	String password;
	@Column(name = "User_specialite")
	String specialité;
	@Column(name = "User_role")
	String role;
	
	
	public User(int id, String nom, String prenom, String adresseMail, String cin, String password, String specialité,
			String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.cin = cin;
		this.password = password;
		this.specialité = specialité;
		this.role = role;
	}
	
	
	public User(int id, String nom, String prenom, String adresseMail, String cin, String password, String specialité,
			String role, Set<Avis> listeAvisAgent, Set<Avis> listeAvisClient, Set<Demande> listeDemande,
			CordgeoUser cordgeouser, Set<Offre_Agent> offreAgent) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.cin = cin;
		this.password = password;
		this.specialité = specialité;
		this.role = role;
		ListeAvisAgent = listeAvisAgent;
		ListeAvisClient = listeAvisClient;
		ListeDemande = listeDemande;
		this.cordgeouser = cordgeouser;
		OffreAgent = offreAgent;
	}


	public User() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresseMail() {
		return adresseMail;
	}


	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSpecialité() {
		return specialité;
	}


	public void setSpecialité(String specialité) {
		this.specialité = specialité;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	



	public Set<Avis> getListeAvisAgent() {
		return ListeAvisAgent;
	}


	public void setListeAvisAgent(Set<Avis> listeAvisAgent) {
		ListeAvisAgent = listeAvisAgent;
	}


	public Set<Avis> getListeAvisClient() {
		return ListeAvisClient;
	}


	public void setListeAvisClient(Set<Avis> listeAvisClient) {
		ListeAvisClient = listeAvisClient;
	}






public Set<Demande> getListeDemande() {
		return ListeDemande;
	}


	public void setListeDemande(Set<Demande> listeDemande) {
		ListeDemande = listeDemande;
	}


	public CordgeoUser getCordgeouser() {
		return cordgeouser;
	}


	public void setCordgeouser(CordgeoUser cordgeouser) {
		this.cordgeouser = cordgeouser;
	}


	public Set<Offre_Agent> getOffreAgent() {
		return OffreAgent;
	}


	public void setOffreAgent(Set<Offre_Agent> offreAgent) {
		OffreAgent = offreAgent;
	}


@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresseMail=" + adresseMail + ", cin="
				+ cin + ", password=" + password + ", specialité=" + specialité + ", role=" + role + ", ListeAvisAgent="
				+ ListeAvisAgent + ", ListeAvisClient=" + ListeAvisClient + ", ListeDemande=" + ListeDemande
				+ ", cordgeouser=" + cordgeouser + ", OffreAgent=" + OffreAgent + "]";
	}






	@OneToMany(fetch = FetchType.LAZY,mappedBy="agent",cascade = CascadeType.ALL)
	private Set<Avis> ListeAvisAgent;
	@OneToMany(fetch = FetchType.LAZY,mappedBy="client",cascade = CascadeType.ALL) 
	private Set<Avis> ListeAvisClient;
	@OneToMany(fetch = FetchType.LAZY,mappedBy="clientD",cascade = CascadeType.ALL) 
	private Set<Demande> ListeDemande;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Cordgeo_ID")
	private  CordgeoUser cordgeouser;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
	private Set<Offre_Agent> OffreAgent;
	
	
	
	
    }
	
	
	
	
	
	


