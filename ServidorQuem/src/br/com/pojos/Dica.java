package br.com.pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Dica implements Serializable{

	private static final long serialVersionUID = -8281546625370983369L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDica;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Midia.class)
	@JoinColumn(name = "id_midia")
	private Midia midia;
	
	@ManyToOne(targetEntity = Pergunta.class, fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "id_pergunta")
	private Pergunta pergunta;
	

	public Dica(){
		
	}

	public int getIdDica() {
		return idDica;
	}

	public void setIdDica(int idDica) {
		this.idDica = idDica;
	}

	public Midia getMidia() {
		return midia;
	}

	public void setMidia(Midia midia) {
		this.midia = midia;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
		
}
