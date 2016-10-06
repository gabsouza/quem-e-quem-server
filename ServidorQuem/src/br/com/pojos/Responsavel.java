package br.com.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Responsavel implements Serializable{

	private static final long serialVersionUID = -6118938763597816669L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResponsavel;
	@Column(length = 15)
	private String nomeResponsavel;
	@Column(nullable = false, length = 200) // Botar limite?
	private String emailResponsavel;
//	@Column(length = 10)
//	private String senha;
	
	@OneToMany(mappedBy = "responsavel",targetEntity = Perfil.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Perfil> perfis = new ArrayList<Perfil>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Relatorio.class)
	private List<Relatorio> relatorios = new ArrayList<Relatorio>();
	
	public Responsavel(String nomeResponsavel, String emailResponsavel){
		this.nomeResponsavel = nomeResponsavel;
		this.emailResponsavel = emailResponsavel;
		//this.senha = senha;
	}
	
	public Responsavel(){
		
	}

	public int getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}
	
}
