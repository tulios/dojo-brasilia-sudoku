package br.dojo;

public class Tabuleiro {
	private int numero;
	private Quadrante[][] tabuleiro = new Quadrante[3][3];
	private Setor[] setoresHorizontais;
	private Setor[] setoresVerticais;
	
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
		return setoresHorizontais[num];
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
		
		//inicializando
		setoresHorizontais = new Setor[3];
		setoresVerticais = new Setor[3];
		
		for (int x=0; x<3; x++){
			Quadrante[] auxHorizontal = new Quadrante[3];
			Quadrante[] auxVertical = new Quadrante[3];
			
			auxHorizontal[0] = this.tabuleiro[x][0];
			auxHorizontal[1] = this.tabuleiro[x][1];
			auxHorizontal[2] = this.tabuleiro[x][2];
			
			auxVertical[0] = this.tabuleiro[0][x];
			auxVertical[1] = this.tabuleiro[1][x];
			auxVertical[2] = this.tabuleiro[2][x];
			
			setoresHorizontais[x] = new Setor(x, auxHorizontal);
			setoresVerticais[x] = new Setor(x, auxVertical);
		}
	}
	
	public int length() {
		return (numero-1);
	}

	public Setor getSetorVertical(int i) {
		return setoresVerticais[i];
	}
	
}
