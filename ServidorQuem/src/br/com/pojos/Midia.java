package br.com.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Midia implements Serializable {

	private static final long serialVersionUID = -2212393770193958580L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMidia;
	
	@Enumerated(EnumType.STRING)
	private TipoMidia tipoMidia;  
	
	@Column(nullable = false)
	private String caminho;
	
	@Column(length = 255)
	private String descricao;
	
	public Midia(TipoMidia tipoMidia, String caminho, String descricao){
		this.tipoMidia = tipoMidia;
		this.caminho = caminho;
		this.descricao = descricao;
	}
	
	public Midia(){
	
	}

	public int getIdMidia() {
		return idMidia;
	}

	public void setIdMidia(int idMidia) {
		this.idMidia = idMidia;
	}

	public TipoMidia getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(TipoMidia tipoMidia) {
		this.tipoMidia = tipoMidia;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	}