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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class MiniJogo implements Serializable {

	private static final long serialVersionUID = 3547848248102446726L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMiniJogo;
	@Column(nullable = false, length = 20)
	private String nomeMiniJogo;
	@Column(nullable = false, length = 100)
	private String introducao;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Midia.class)
	private List<Midia> midias = new ArrayList<Midia>();
	
	@OneToMany(mappedBy = "miniJogo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Pergunta.class)
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = UsuarioMiniJogo.class)
	private List<UsuarioMiniJogo> usuariosMiniJogos = new ArrayList<UsuarioMiniJogo>();
	
	public MiniJogo(String nomeMiniJogo){
		this.nomeMiniJogo = nomeMiniJogo;
	}
	
	public MiniJogo(){
		
	}

	public int getIdMiniJogo() {
		return idMiniJogo;
	}

	public void setIdMiniJogo(int idMiniJogo) {
		this.idMiniJogo = idMiniJogo;
	}

	public String getNomeMiniJogo() {
		return nomeMiniJogo;
	}

	public void setNomeMiniJogo(String nomeMiniJogo) {
		this.nomeMiniJogo = nomeMiniJogo;
	}

	public String getIntroducao() {
		return introducao;
	}

	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}

	public List<Midia> getMidias() {
		return midias;
	}

	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public List<UsuarioMiniJogo> getUsuariosMiniJogos() {
		return usuariosMiniJogos;
	}

	public void setUsuariosMiniJogos(List<UsuarioMiniJogo> usuariosMiniJogos) {
		this.usuariosMiniJogos = usuariosMiniJogos;
	}
	
}
