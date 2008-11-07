package br.dojo;

public enum Numero {
	BRANCO(0),
	UM(1),
	DOIS(2),
	TRES(3),
	QUATRO(4),
	CINCO(5),
	SEIS(6),
	SETE(7),
	OITO(8),
	NOVE(9);
	
	private int valor;
	Numero(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
}
















