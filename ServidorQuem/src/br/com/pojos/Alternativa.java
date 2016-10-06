package br.com.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.pojos.StatusAlternativa;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Alternativa implements Serializable{

	private static final long serialVersionUID = -37767541869854404L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlternativa; 
	@Enumerated(EnumType.STRING)
	private StatusAlternativa statusAlternativa;
	@Column(nullable = false, length = 50)
	private String descricao;
	
	@OneToMany(mappedBy = "alternativa", cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Resposta.class)
	private List<Resposta> respostas = new ArrayList<Resposta>();
		
	public Alternativa(StatusAlternativa statusAlternativa, String descricao){
		this.statusAlternativa = statusAlternativa;
		this.descricao = descricao;
	}
	
	public Alternativa(){
		
	}

	public int getIdAlternativa() {
		return idAlternativa;
	}

	public void setIdAlternativa(int idAlternativa) {
		this.idAlternativa = idAlternativa;
	}

	public StatusAlternativa getStatusAlternativa() {
		return statusAlternativa;
	}

	public void setStatusAlternativa(StatusAlternativa statusAlternativa) {
		this.statusAlternativa = statusAlternativa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
	
	
}
