package br.dojo;

public class Quadrante {
	private int numero;
	private Numero[][] valor;

	public Quadrante(int numero){
		this.numero = numero;
		valor = new Numero[3][3];
		for(int x = 0 ; x < 3 ; x++)
		{
			for (int i = 0; i < 3; i++) {
				valor[x][i] = Numero.BRANCO;
			}	
		}
	}

	@Override
	public String toString() {
		return String.valueOf(numero);
	}

	public int getNumero() {
		return numero;
	}

	/**
	 * Retorna o valor que esta dentro do quadrante (um array)
	 * @return Integer[][]
	 */
	public Numero[][] getValor() {
		return valor;
	}

	public void setValor(Numero[][] valor) {		
		this.valor = valor;
	}

}













