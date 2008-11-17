package br.dojo;

import java.util.HashSet;
import java.util.Set;

public class VerificaTabuleiro {
	private Tabuleiro tabuleiro;

	public VerificaTabuleiro(Tabuleiro tabuleiro){
		this.tabuleiro = tabuleiro;
	}

	public boolean isOK(){
		
		//verificaLinhaTabuleiro()
		//{
			
		//}
		
		return true;
	}

	public static boolean verificaQuadrante(Quadrante q){
		Set<Integer> conjunto = new HashSet<Integer>();
		int cont = 9;
		for (int x=0; x<3; x++){
			for (int y=0; y<3; y++){
				int numero = q.getValor()[x][y].getValor();
				if(numero == Numero.BRANCO.getValor())
					cont--;
				else					
					conjunto.add(numero);
			}
		}
		if (conjunto.size() < cont){
			return false;
		}
		return true;
	}	
	
	public boolean verificaLinhaTabuleiro(){
		Quadrante[] q = new Quadrante[3];
		int elemLinhas = 9;

		for (int x=0; x<3; x++){
			q[x] = tabuleiro.getTabuleiro()[0][x];
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int x=0; x<3; x++){
			int var1 = q[x].getValor()[0][0].getValor();
			int var2 = q[x].getValor()[0][1].getValor();
			int var3 = q[x].getValor()[0][2].getValor();
			if(var1 == Numero.BRANCO.getValor())
				elemLinhas--;
			else
				set.add(var1);
			if(var2 == Numero.BRANCO.getValor())
				elemLinhas--;
			else
				set.add(var2);
			if(var3 == Numero.BRANCO.getValor())
				elemLinhas--;
			else
				set.add(var3);
		}
		if (set.size() < elemLinhas) return false;
		return true;
	}	
	
	/*public boolean verificaColunaTabuleiro(){
		Quadrante[] q = new Quadrante[3];
		int elemColunas = 9;

		for (int x=0; x<3; x++){
			q[x] = tabuleiro.getTabuleiro()[x][0];
		}
		Set<Integer> set = new HashSet<Integer>();
		
		for (int x=0; x<3; x++){
			int var1 = q[x].getValor()[0][0].getValor();
			int var2 = q[x].getValor()[1][0].getValor();
			int var3 = q[x].getValor()[2][0].getValor();
			if(var1 == Numero.BRANCO.getValor())
				elemColunas--;
			else
				set.add(var1);
			if(var2 == Numero.BRANCO.getValor())
				elemColunas--;
			else
				set.add(var2);
			if(var3 == Numero.BRANCO.getValor())
				elemColunas--;
			else
				set.add(var3);
		}
		if (set.size() < elemColunas) return false;

		return true;
	}*/
}















