package br.com.pojos;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum(String.class)
public enum GeneroPersonagem {
	
	FEMININO("Feminino"),
	MASCULINO("Masculino"),
	NEUTRO("Neutro");
	
	private String code;
	
	private GeneroPersonagem(String code){
		this.code = code;
	}
	
	public String getGeneroPersonagem(){
		return this.code;
	}

}

