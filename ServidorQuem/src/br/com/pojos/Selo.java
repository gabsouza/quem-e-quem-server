package br.com.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Selo implements Serializable{

	private static final long serialVersionUID = 892980676576219329L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSelo;
	
	@Column(length = 15)
	private String nomeSelo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Midia.class)
	@JoinColumn(name = "id_midia")
	private Midia midia;
	
	public Selo(){
		
	}

	public int getIdSelo() {
		return idSelo;
	}

	public void setIdSelo(int idSelo) {
		this.idSelo = idSelo;
	}
	
	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Midia getMidia() {
		return midia;
	}

	public void setMidia(Midia midia) {
		this.midia = midia;
	}

	public String getNomeSelo() {
		return nomeSelo;
	}

	public void setNomeSelo(String nomeSelo) {
		this.nomeSelo = nomeSelo;
	}
			
}
