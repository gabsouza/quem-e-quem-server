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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Pergunta implements Serializable{

	private static final long serialVersionUID = 4886271165487014032L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPergunta;
	@Column(nullable = false)
	private int quantTentativas;
	//@Column(nullable = false)
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Midia.class)
	private List<Midia> midias = new ArrayList<Midia>();
	
	//@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = UsuarioMiniJogo.class)
	//private List<UsuarioMiniJogo> usuario_mini_jogo = new ArrayList<UsuarioMiniJogo>();
	
//	@OneToMany(mappedBy = "pergunta", targetEntity = Resposta.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Resposta> respostas = new ArrayList<Resposta>();
	
	//@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Alternativa.class)
	//private List<Alternativa> alternativas = new ArrayList<Alternativa>();
	
	
	@OneToMany(mappedBy = "pergunta", targetEntity = Dica.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Dica> dicas = new ArrayList<Dica>();

	@XmlTransient
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = MiniJogo.class)
	private MiniJogo miniJogo;
	
	public Pergunta(int quantTentativas, String descricao){
		this.quantTentativas = quantTentativas;
		this.descricao = descricao;
	}
	
	public Pergunta(){
		
	}

	public int getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(int idPergunta) {
		this.idPergunta = idPergunta;
	}

	public int getQuantTentativas() {
		return quantTentativas;
	}

	public void setQuantTentativas(int quantTentativas) {
		this.quantTentativas = quantTentativas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Midia> getMidias() {
		return midias;
	}

	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}

	public List<Dica> getDicas() {
		return dicas;
	}

	public void setDicas(List<Dica> dicas) {
		this.dicas = dicas;
	}

	public MiniJogo getMiniJogo() {
		return miniJogo;
	}

	public void setMiniJogo(MiniJogo miniJogo) {
		this.miniJogo = miniJogo;
	}
	
}
