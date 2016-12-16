package br.com.pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Alternativa implements Serializable{

	private static final long serialVersionUID = -37767541869854404L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlternativa; 
	@Column(nullable = false, length = 50)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private GeneroPersonagem generoPersonagem;
	
	@XmlElementWrapper
	@ManyToOne(targetEntity = Pergunta.class, fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "id_pergunta")
	private Pergunta pergunta;
		
	public Alternativa(String descricao, GeneroPersonagem generoPersonagem){
		this.descricao = descricao;
		this.generoPersonagem = generoPersonagem;
	}
	
	public Alternativa(){
		
	}

	public int getIdAlternativa() {
		return idAlternativa;
	}

	public void setIdAlternativa(int idAlternativa) {
		this.idAlternativa = idAlternativa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GeneroPersonagem getGeneroPersonagem() {
		return generoPersonagem;
	}

	public void setGeneroPersonagem(GeneroPersonagem generoPersonagem) {
		this.generoPersonagem = generoPersonagem;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}


	
	
	
	
	
}
