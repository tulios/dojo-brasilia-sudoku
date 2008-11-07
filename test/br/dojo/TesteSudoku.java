package br.dojo;

import junit.framework.Assert;

import org.junit.Test;

public class TesteSudoku {
	
	@Test
	public void verificaTabuleiro(){
		Tabuleiro tabuleiro = new Tabuleiro();
		Assert.assertNotNull(tabuleiro);
		
		Assert.assertNotNull(tabuleiro.getTabuleiro());
	}
	
	@Test
	public void verificaQuadrantes(){
		Tabuleiro tabuleiro = new Tabuleiro();		
		Assert.assertEquals(9, tabuleiro.length());
		//verifica se o array de cada quadrante é 9
		for (int x=0; x<3; x++){
			for(int y=0; y<3; y++){
				Numero[][] valor = tabuleiro.getTabuleiro()[x][y].getValor();
				for (Numero[] v: valor){
					Assert.assertEquals(3, v.length);
				}
			}
		}
	}
	
	@Test
	public void verificaPosicaoDosQuadrantes(){
		Tabuleiro tabuleiro = new Tabuleiro();
		
		Assert.assertEquals(1, tabuleiro.getTabuleiro()[0][0].getNumero());
		Assert.assertEquals(2, tabuleiro.getTabuleiro()[0][1].getNumero());
		Assert.assertEquals(3, tabuleiro.getTabuleiro()[0][2].getNumero());
		Assert.assertEquals(4, tabuleiro.getTabuleiro()[1][0].getNumero());
		Assert.assertEquals(5, tabuleiro.getTabuleiro()[1][1].getNumero());
		Assert.assertEquals(6, tabuleiro.getTabuleiro()[1][2].getNumero());
		Assert.assertEquals(7, tabuleiro.getTabuleiro()[2][0].getNumero());
		Assert.assertEquals(8, tabuleiro.getTabuleiro()[2][1].getNumero());
		Assert.assertEquals(9, tabuleiro.getTabuleiro()[2][2].getNumero());
	}
	
	@Test
	public void verificaRepeticoesNoTabuleiroVazio(){
		Tabuleiro tabuleiro = new Tabuleiro();
		VerificaTabuleiro vf = new VerificaTabuleiro(tabuleiro);
		Assert.assertNotNull(vf);
		Assert.assertTrue(vf.isOK());
	}
	*
	@Test
	public void verificaRepeticaoQuadrante(){
		Quadrante q = new Quadrante(1);
		Numero[][] n = new Numero[3][3];
		n[0][0] = Numero.UM;
		n[0][1] = Numero.DOIS;
		n[0][2] = Numero.TRES;
		n[1][0] = Numero.QUATRO;
		n[1][1] = Numero.CINCO;
		n[1][2] = Numero.SEIS;
		n[2][0] = Numero.SETE;
		n[2][1] = Numero.OITO;
		n[2][2] = Numero.NOVE;
		q.setValor(n);
		Assert.assertTrue(VerificaTabuleiro.verificaQuadrante(q));
	}
	
	@Test
	public void verificaRepeticaoQuadranteFalhando(){
		Quadrante q = new Quadrante(1);
		Numero[][] n = new Numero[3][3];
		n[0][0] = Numero.UM;
		n[0][1] = Numero.DOIS;
		n[0][2] = Numero.UM;
		n[1][0] = Numero.CINCO;
		n[1][1] = Numero.CINCO;
		n[1][2] = Numero.SEIS;
		n[2][0] = Numero.OITO;
		n[2][1] = Numero.OITO;
		n[2][2] = Numero.UM;
		q.setValor(n);
		Assert.assertFalse(VerificaTabuleiro.verificaQuadrante(q));
	}

	@Test
	public void verificaRepeticaoQuadranteComBranco(){
		Quadrante q = new Quadrante(1);
		Numero[][] n = new Numero[3][3];
		n[0][0] = Numero.BRANCO;
		n[0][1] = Numero.BRANCO;
		n[0][2] = Numero.TRES;
		n[1][0] = Numero.QUATRO;
		n[1][1] = Numero.BRANCO;
		n[1][2] = Numero.SEIS;
		n[2][0] = Numero.BRANCO;
		n[2][1] = Numero.OITO;
		n[2][2] = Numero.NOVE;
		q.setValor(n);
		Assert.assertTrue(VerificaTabuleiro.verificaQuadrante(q));
	}
	
	@Test
	public void verificaRepeticaoQuadranteComUmBranco(){
		Quadrante q = new Quadrante(1);
		Numero[][] n = new Numero[3][3];
		n[0][0] = Numero.BRANCO;
		n[0][1] = Numero.DOIS;
		n[0][2] = Numero.TRES;
		n[1][0] = Numero.QUATRO;
		n[1][1] = Numero.CINCO;
		n[1][2] = Numero.SEIS;
		n[2][0] = Numero.SETE;
		n[2][1] = Numero.OITO;
		n[2][2] = Numero.NOVE;
		q.setValor(n);
		Assert.assertTrue(VerificaTabuleiro.verificaQuadrante(q));
	}
	
	@Test
	public void verificaQuadrantesLinha(){
		Tabuleiro t = new Tabuleiro();
		Quadrante um = t.getTabuleiro()[0][0];
		Quadrante dois = t.getTabuleiro()[0][1];
		Quadrante tres = t.getTabuleiro()[0][2];
		
		Numero[][] n = new Numero[3][3];
		n[0][0] = Numero.UM;
		n[0][1] = Numero.DOIS;
		n[0][2] = Numero.TRES;
		n[1][0] = Numero.QUATRO;
		n[1][1] = Numero.CINCO;
		n[1][2] = Numero.SEIS;
		n[2][0] = Numero.SETE;
		n[2][1] = Numero.OITO;
		n[2][2] = Numero.NOVE;
		
		um.setValor(n);
		dois.setValor(n);
		tres.setValor(n);
		
		Assert.assertTrue(VerificaTabuleiro.verificaQuadrante(um));
		Assert.assertTrue(VerificaTabuleiro.verificaQuadrante(dois));
		Assert.assertTrue(VerificaTabuleiro.verificaQuadrante(tres));
		
		VerificaTabuleiro vt = new VerificaTabuleiro(t);
		Assert.assertFalse(vt.isOK());
	}
	
	@Test
	public void verificaLinhaTabuleiro(){
		VerificaTabuleiro vf = new VerificaTabuleiro(new Tabuleiro());
		Assert.assertTrue(vf.verificaLinhaTabuleiro());
	/*
	 * criar a verficaLinhaTabuleiro dentro do IsOK junto com os outros métodos
	 * de verificação do tabuleiro 	
	 */
	}
	
}
















