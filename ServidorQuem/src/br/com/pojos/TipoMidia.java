package br.com.pojos;

public enum TipoMidia {
	
	AUDIO("Audio"),
	FIGURA("Figure"),
	VIDEO("Video"),
	PERSONAGEM("Character");
	
	private String code;
	
	private TipoMidia(String code){
		this.code = code;
	}
	
	public String getTipoMidia(){
		return this.code;
	}

}
