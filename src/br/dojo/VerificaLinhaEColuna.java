package br.dojo;

import java.util.HashSet;
import java.util.Set;

public class VerificaLinhaEColuna {
	
	public VerificaLinhaEColuna(Numero[] elementos) throws LinhaOuColunaInvalidaException{
		Set<Numero> set = new HashSet<Numero>();
		int qtd = 9;
		for (Numero n: elementos){
			if (n == Numero.BRANCO){
				qtd--;
			}else{
				set.add(n);
			}
		}
		if (qtd != set.size()){
			throw new LinhaOuColunaInvalidaException();
		}
	}
}
