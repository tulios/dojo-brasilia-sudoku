package br.dojo;

public class NumeroInvalidoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NumeroInvalidoException(){
		super("Número inválido para o quadrante!");
	}
	
}
