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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Perfil implements Serializable {

	private static final long serialVersionUID = -5858562772172889269L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	@Column(length = 15)
	private String nomePerfil;
	
	@XmlTransient
	@ManyToOne(targetEntity = Responsavel.class, fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "id_responsavel")
	private Responsavel responsavel;
	
	@XmlTransient
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Selo.class)
	private List<Selo> selos = new ArrayList<Selo>();
	
	@XmlTransient
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = UsuarioMiniJogo.class)
	private List<UsuarioMiniJogo> usuariosMiniJogos = new ArrayList<UsuarioMiniJogo>();
	
	@XmlTransient
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_midia")
	private Midia midia;
	
	public Perfil(String nomePerfil){
		this.nomePerfil = nomePerfil;
	}
	
	public Perfil(){
		
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public List<Selo> getSelos() {
		return selos;
	}

	public void setSelos(List<Selo> selos) {
		this.selos = selos;
	}

	public List<UsuarioMiniJogo> getUsuariosMiniJogos() {
		return usuariosMiniJogos;
	}

	public void setUsuariosMiniJogos(List<UsuarioMiniJogo> usuariosMiniJogos) {
		this.usuariosMiniJogos = usuariosMiniJogos;
	}

	public Midia getMidia() {
		return midia;
	}

	public void setMidia(Midia midia) {
		this.midia = midia;
	}

}
