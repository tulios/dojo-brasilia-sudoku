package br.dojo;

import java.util.HashSet;
import java.util.Set;

public class VerificaLinha {
	
	public VerificaLinha(Numero[] linha) throws LinhaInvalidaException{
		Set<Numero> set = new HashSet<Numero>();
		int qtd = 9;
		for (Numero n: linha){
			if (n == Numero.BRANCO){
				qtd--;
			}else{
				set.add(n);
			}
		}
		if (qtd != set.size()){
			throw new LinhaInvalidaException();
		}
	}
}
