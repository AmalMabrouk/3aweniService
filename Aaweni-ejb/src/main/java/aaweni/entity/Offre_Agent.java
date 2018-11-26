package aaweni.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Offre_Agent")

public class Offre_Agent implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Offre_Agent_ID")
	int id;
	@Column(name = "Prix")
	double prixpropose;
	@Column(name = "Etat")
	String etat;

	public Offre_Agent() {
		super();
	}

	public Offre_Agent(int id, double prixpropose, String etat, User user, Demande demande) {
		super();
		this.id = id;
		this.prixpropose = prixpropose;
		this.etat = etat;
		this.user = user;
		this.demande = demande;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public double getPrixpropose() {
		return prixpropose;
	}

	public void setPrixpropose(double prixpropose) {
		this.prixpropose = prixpropose;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Agent_ID")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Demande_ID")
	private Demande demande;

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	@Override
	public String toString() {
		return "Offre_Agent [id=" + id + ", prixpropose=" + prixpropose + ", etat=" + etat + ", user=" + user.id
				+ ", demande=" + demande.id + "]";
	}

	

}
