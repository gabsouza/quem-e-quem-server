package br.com.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class UsuarioMiniJogo implements Serializable{

	private static final long serialVersionUID = 3705851221202931220L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuarioMiniJogo;
	
	//@ManyToMany(mappedBy = "usuario_mini_jogo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Pergunta.class)
	//private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	@OneToMany(mappedBy = "usuarioMiniJogo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Resposta.class )
	private List<Resposta> respostas = new ArrayList<Resposta>();
	
	//ISSO?
	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Alternativa.class)
	//private List<Alternativa> alternativas = new ArrayList<Alternativa>();
	
	@ManyToMany(mappedBy = "usuariosMiniJogos", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Perfil.class)
	private List<Perfil> perfis = new ArrayList<Perfil>();
	
	@ManyToMany(mappedBy = "usuariosMiniJogos", cascade = CascadeType.ALL,fetch = FetchType.LAZY, targetEntity = MiniJogo.class )
	private List<MiniJogo> miniJogos = new ArrayList<MiniJogo>();
	
	public UsuarioMiniJogo(){
		
	}

	public int getIdUsuarioMiniJogo() {
		return idUsuarioMiniJogo;
	}

	public void setIdUsuarioMiniJogo(int idUsuarioMiniJogo) {
		this.idUsuarioMiniJogo = idUsuarioMiniJogo;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public List<MiniJogo> getMiniJogos() {
		return miniJogos;
	}

	public void setMiniJogos(List<MiniJogo> miniJogos) {
		this.miniJogos = miniJogos;
	}
	
}
