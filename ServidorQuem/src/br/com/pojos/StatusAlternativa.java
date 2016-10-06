package br.com.pojos;

public enum StatusAlternativa {
	
	ERRADA("Wrong"),
	CORRETA("Correct");
	
	private String code;
	
	private StatusAlternativa(String code){
		this.code = code;
	}
	
	public String getStatusAlterntiva(){
		return this.code;
	}

}

