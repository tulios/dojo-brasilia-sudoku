package br.dojo;

public class Tabuleiro {
	private int numero;
	private Quadrante[][] tabuleiro = new Quadrante[3][3];
	
	public Tabuleiro(){
		numero = 1;
		for (int x=0; x<3; x++){
			for (int y=0; y<3; y++){
				tabuleiro[x][y] = new Quadrante(numero++);
			}
		}
	}
	
	/**
	 * 1 | 2 | 3<br/>
	 * ---------<br/>
	 * 4 | 5 | 6<br/>
	 * ---------<br/>
	 * 7 | 8 | 9<br/>
	 * 
	 * @return Quadrante[][]
	 */
	public Quadrante[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Quadrante[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public int length() {
		return (numero-1);
	}
	
}
