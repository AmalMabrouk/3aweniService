package aaweni.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Avis")
public class Avis implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Avis_ID")
	int id;
	@Column(name = "Avis_Details")
	String avis_details;
	@Column(name = "Avis_NoteRating")
	int noterating;
	
	
	
	public Avis(int id, String avis_details, int noterating, User agent, User client) {
		super();
		this.id = id;
		this.avis_details = avis_details;
		this.noterating = noterating;
		this.agent = agent;
		this.client = client;
	}
	
	public Avis() {
		super();
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvis_details() {
		return avis_details;
	}

	public void setAvis_details(String avis_details) {
		this.avis_details = avis_details;
	}

	public int getNoterating() {
		return noterating;
	}

	public void setNoterating(int noterating) {
		this.noterating = noterating;
	}

	public User getAgent() {
		return agent;
	}

	public void setAgent(User agent) {
		this.agent = agent;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}



	@ManyToOne(fetch = FetchType.EAGER)
	User agent; 
	@ManyToOne(fetch = FetchType.EAGER)
	User client;



	@Override
	public String toString() {
		return "Avis [id=" + id + ", avis_details=" + avis_details + ", noterating=" + noterating + ", agent=" + agent.id
				+ ", client=" + client.id + "]";
	} 
	
	
	

}
