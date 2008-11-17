package br.dojo;

public class Setor {
	private Quadrante[] quadrantes;
	private int numeroSetor;
	
	public Setor(int numeroSetor, Quadrante[] quadrantes){
		this.quadrantes = quadrantes;
		this.numeroSetor = numeroSetor;
	}
	
	public Quadrante[] getSetor() {
		return quadrantes;
	}
	
	public int getNumeroSetor() {
		return numeroSetor;
	}

	public Numero[] getLinha(int numLinha) {
		Numero[] linha = new Numero[9];
		int aux = 0;
		for (int x=0; x<3; x++){
			linha[aux++] = quadrantes[x].getValor()[numLinha][0];
			linha[aux++] = quadrantes[x].getValor()[numLinha][1];
			linha[aux++] = quadrantes[x].getValor()[numLinha][2];
		}
		return linha;
	}

}
