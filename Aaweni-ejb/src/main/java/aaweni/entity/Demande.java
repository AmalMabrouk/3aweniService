package aaweni.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Demande")

public class Demande implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Demande_ID")
	int id;
	@Column(name = "Dem_Type")
	String type;
	@Column(name = "Dem_titre")
	String titre;
	@Column(name = "Dem_Panne")
	String panne;
	@Column(name = "Dem_Etat")
	String etat;
	@Column(name = "Dem_picture")
	String picture;
	@Column(name = "Dem_Date")
	@Temporal(TemporalType.TIMESTAMP)
	Date datedemande;

	public Demande() {
		super();
	}

	public Demande(int id, String type, String panne, User client) {
		super();
		this.id = id;
		this.type = type;
		this.panne = panne;
		this.clientD = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPanne() {
		return panne;
	}

	public void setPanne(String panne) {
		this.panne = panne;
	}

	public User getClientD() {
		return clientD;
	}

	public void setClientD(User clientD) {
		this.clientD = clientD;
	}

	public CordgeoDemande getCordgeoudemande() {
		return cordgeoudemande;
	}
	

	public Date getDatedemande() {
		return datedemande;
	}

	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}

	public Demande(int id, String type, String panne, User clientD, CordgeoDemande cordgeoudemande,
			Set<Offre_Agent> offreAgent) {
		super();
		this.id = id;
		this.type = type;
		this.panne = panne;
		this.clientD = clientD;
		this.cordgeoudemande = cordgeoudemande;
		OffreAgent = offreAgent;
	}

	public void setCordgeoudemande(CordgeoDemande cordgeoudemande) {
		this.cordgeoudemande = cordgeoudemande;
	}

	public Set<Offre_Agent> getOffreAgent() {
		return OffreAgent;
	}

	public void setOffreAgent(Set<Offre_Agent> offreAgent) {
		OffreAgent = offreAgent;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	User clientD;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Cordgeo_ID")
	private CordgeoDemande cordgeoudemande;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "demande")
	private Set<Offre_Agent> OffreAgent;

	@Override
	public String toString() {
		return "Demande [id=" + id +", titre="+titre+ ", type=" + type + ", panne=" + panne + ", etat=" + etat + ", image="+picture+", clientD="
				+ clientD.id + ", cordgeoudemande=" + cordgeoudemande + ", OffreAgent=" + OffreAgent + "date="+datedemande +"]";
	}

}
