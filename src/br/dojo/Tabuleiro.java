package br.dojo;

public class Tabuleiro {
	private int numero;
	private Quadrante[][] tabuleiro = new Quadrante[3][3];
	private Setor[] setores;
	
	public Tabuleiro(){
		numero = 1;
		for (int x=0; x<3; x++){
			for (int y=0; y<3; y++){
				tabuleiro[x][y] = new Quadrante(numero++);
			}
		}
		setTabuleiro(tabuleiro);
	}
	
	public Setor getSetorHorizontal(int num) {	
		return null;
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
		setores = new Setor[3];
		for (int x=0; x<3; x++){
			Quadrante[] aux = new Quadrante[3];
			aux[0] = this.tabuleiro[x][0];
			aux[1] = this.tabuleiro[x][1];
			aux[2] = this.tabuleiro[x][2];
			setores[x] = new Setor(aux);
		}
	}
	
	public int length() {
		return (numero-1);
	}
	
}
