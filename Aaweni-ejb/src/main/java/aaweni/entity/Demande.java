package aaweni.entity;

import java.io.Serializable;
import java.util.Set;

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

@Entity
@Table(name="Demande")
public class Demande implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Demande_ID")
	int id;
	@Column(name = "Dem_Type")
	String type;
	@Column(name = "Dem_Panne")
	String panne;
	
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


	public User getClient() {
		return clientD;
	}


	public void setClient(User client) {
		this.clientD = client;
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

	public void setCordgeoudemande(CordgeoDemande cordgeoudemande) {
		this.cordgeoudemande = cordgeoudemande;
	}

	public Set<Offre_Agent> getOffreAgent() {
		return OffreAgent;
	}

	public void setOffreAgent(Set<Offre_Agent> offreAgent) {
		OffreAgent = offreAgent;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	User clientD; 
	
	@OneToOne()
	@JoinColumn(name="Cordgeo_ID")
	private  CordgeoDemande cordgeoudemande;
	
	 @OneToMany(fetch = FetchType.LAZY,mappedBy ="demande")
	 private Set<Offre_Agent> OffreAgent;

}
