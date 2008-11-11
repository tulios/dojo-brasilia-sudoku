package br.dojo;

public class Setor {
	private Quadrante[] quadrantes;
	
	public Setor(Quadrante[] quadrantes){
		this.quadrantes = quadrantes;
	}
	
	public Quadrante[] getSetor() {
		return quadrantes;
	}

	public Numero[] getLinha(int j) {
		Numero[] linha = new Numero[9];
		int aux = 0;
		for (int x=0; x<3; x++){
			linha[aux++] = quadrantes[j].getValor()[j][0];
			linha[aux++] = quadrantes[j].getValor()[j][1];
			linha[aux++] = quadrantes[j].getValor()[j][2];
		}
		return linha;
	}

}
