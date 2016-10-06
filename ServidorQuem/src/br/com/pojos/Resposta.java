package br.com.pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Resposta implements Serializable{

	private static final long serialVersionUID = -998993369085728865L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResposta;
	private int pontuacao;
	private float evolucao;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = Pergunta.class )
	private Pergunta pergunta;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = UsuarioMiniJogo.class)
	private UsuarioMiniJogo usuarioMiniJogo;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, targetEntity = Alternativa.class)
	private Alternativa alternativa;
	
	public Resposta(int pontuacao, float evolucao){
		this.pontuacao = pontuacao;
		this.evolucao = evolucao;
	}
	
	public Resposta(){
		
	}

	public int getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public float getEvolucao() {
		return evolucao;
	}

	public void setEvolucao(float evolucao) {
		this.evolucao = evolucao;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public UsuarioMiniJogo getUsuarioMiniJogo() {
		return usuarioMiniJogo;
	}

	public void setUsuarioMiniJogo(UsuarioMiniJogo usuarioMiniJogo) {
		this.usuarioMiniJogo = usuarioMiniJogo;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}
	
}
