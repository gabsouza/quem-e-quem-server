package br.com.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Relatorio implements Serializable{
	
	private static final long serialVersionUID = 3841517645962686311L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRelatorio;
	@Column(length = 400)
	private String informacoes;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	@ManyToOne(targetEntity = MiniJogo.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mini_jogo")
	private List<MiniJogo> miniJogos = new ArrayList<MiniJogo>();
	
	public Relatorio(String informacoes){
		this.informacoes = informacoes;
	}
	
	public Relatorio(){
		
	}

	public int getIdRelatorio() {
		return idRelatorio;
	}

	public void setIdRelatorio(int idRelatorio) {
		this.idRelatorio = idRelatorio;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public List<MiniJogo> getMiniJogos() {
		return miniJogos;
	}

	public void setMiniJogos(List<MiniJogo> miniJogos) {
		this.miniJogos = miniJogos;
	}

}
