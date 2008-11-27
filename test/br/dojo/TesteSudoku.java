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
		Assert.assertTrue(vt.isOK());
	}

	@Test
	public void verificaLinhaTabuleiroComElementosBrancos(){
		VerificaTabuleiro vf = new VerificaTabuleiro(new Tabuleiro());
		Assert.assertTrue(vf.verificaLinhaTabuleiro());


	}
	@Test
	public void verificaLinhaTabuleiroComElementosCertos(){
		Tabuleiro tab = new Tabuleiro();
		Quadrante q1 = new Quadrante(1);
		Quadrante q2 = new Quadrante(2);
		Quadrante q3 = new Quadrante(3);

		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.DOIS;
		n1[0][2] = Numero.TRES;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.CINCO;
		n2[0][2] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;

		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);

		VerificaTabuleiro vf = new VerificaTabuleiro(tab);
		Assert.assertTrue(vf.verificaLinhaTabuleiro());

	}
	@Test	
	public void verificaLinhaTabuleiroComElementosRepetidos(){
		Tabuleiro tab = new Tabuleiro();
		Quadrante q1 = new Quadrante(1);
		Quadrante q2 = new Quadrante(2);
		Quadrante q3 = new Quadrante(3);

		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.UM;
		n1[0][2] = Numero.TRES;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.QUATRO;
		n2[0][2] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;

		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);

		VerificaTabuleiro vf = new VerificaTabuleiro(tab);
		Assert.assertFalse(vf.verificaLinhaTabuleiro());

	}

	@Test	
	public void verificaLinhaTabuleiroComElementosCertosEBrancos(){
		Tabuleiro tab = new Tabuleiro();
		Quadrante q1 = new Quadrante(1);
		Quadrante q2 = new Quadrante(2);
		Quadrante q3 = new Quadrante(3);

		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.BRANCO;
		n1[0][2] = Numero.TRES;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.BRANCO;
		n2[0][2] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;

		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);

		VerificaTabuleiro vf = new VerificaTabuleiro(tab);
		Assert.assertTrue(vf.verificaLinhaTabuleiro());
	}

	@Test
	public void verificaLinhaComValoresDesordenados(){
		Tabuleiro tab = new Tabuleiro();
		Quadrante q1 = new Quadrante(1);
		Quadrante q2 = new Quadrante(2);
		Quadrante q3 = new Quadrante(3);

		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.SETE;
		n1[0][1] = Numero.QUATRO;
		n1[0][2] = Numero.SEIS;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.UM;
		n2[0][1] = Numero.CINCO;
		n2[0][2] = Numero.TRES;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.DOIS;
		n3[0][1] = Numero.NOVE;
		n3[0][2] = Numero.OITO;

		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);

		VerificaTabuleiro vf = new VerificaTabuleiro(tab);
		Assert.assertTrue(vf.verificaLinhaTabuleiro());
	}

	@Test
	public void verificaLinhaTabuleiroComElementosCertosEmQualquerLinha(){
		Tabuleiro tab = new Tabuleiro();
		Quadrante q1 = new Quadrante(1);
		Quadrante q2 = new Quadrante(2);
		Quadrante q3 = new Quadrante(3);

		Numero[][] n1 = new Numero[3][3];		
		n1[1][0] = Numero.UM;
		n1[1][1] = Numero.DOIS;
		n1[1][2] = Numero.TRES;

		Numero[][] n2 = new Numero[3][3];		
		n2[1][0] = Numero.QUATRO;
		n2[1][1] = Numero.CINCO;
		n2[1][2] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[1][0] = Numero.SETE;
		n3[1][1] = Numero.OITO;
		n3[1][2] = Numero.NOVE;

		tab.getTabuleiro()[1][0].setValor(n1);
		tab.getTabuleiro()[1][1].setValor(n2);
		tab.getTabuleiro()[1][2].setValor(n3);

		VerificaTabuleiro vf = new VerificaTabuleiro(tab);
		Assert.assertTrue(vf.verificaLinhaTabuleiro());

	}

	@Test
	public void verificaTodasLinhasDaPrimeiraLinhaTabuleiro(){
		Tabuleiro tab = new Tabuleiro();
			for (int x=0; x<3; x++){
				Numero[][] n1 = new Numero[3][3];		
				n1[x][0] = Numero.UM;
				n1[x][1] = Numero.DOIS;
				n1[x][2] = Numero.TRES;

				Numero[][] n2 = new Numero[3][3];		
				n2[x][0] = Numero.QUATRO;
				n2[x][1] = Numero.CINCO;
				n2[x][2] = Numero.SEIS;

				Numero[][] n3 = new Numero[3][3];		
				n3[x][0] = Numero.SETE;
				n3[x][1] = Numero.OITO;
				n3[x][2] = Numero.NOVE;

				tab.getTabuleiro()[x][0].setValor(n1);
				tab.getTabuleiro()[x][1].setValor(n2);
				tab.getTabuleiro()[x][2].setValor(n3);

				VerificaTabuleiro vf = new VerificaTabuleiro(tab);
				Assert.assertTrue(vf.verificaLinhaTabuleiro());
			}
	}
	/*@Test
	public void verificaTodasLinhasDeTodosOsSetoresDoTabuleiro(){
		
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.DOIS;
		n1[0][2] = Numero.TRES;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.CINCO;
		n2[0][2] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;
		//Pega cada setor no eixo x do Tabuleiro
		Tabuleiro tab = new Tabuleiro();
		for(int i = 0; i < 3; i++){
			Setor setor = tab.getSetorHorizontal(i);
			for(int j = 0; j<3; j++){
				Quadrante[] q = setor.getLinha(j);
				q[0].setValor(n1);
				q[1].setValor(n2);
				q[2].setValor(n3);
				
				VerificaTabuleiro vf = new VerificaTabuleiro(tab);
				//Assert.assertTrue(vf.verificaLinhaTabuleiro());
			}	
		}
	}*/
	
	@Test
	public void testVerificaGetLinhaDoSetor(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//cria uma linha
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.DOIS;
		n1[0][2] = Numero.TRES;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.CINCO;
		n2[0][2] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorHorizontal(0);
		Assert.assertNotNull(setor);
		
		Numero[] linha = setor.getLinha(0);
		Assert.assertEquals(9, linha.length);
		
		Assert.assertEquals(Numero.UM, linha[0]);
		Assert.assertEquals(Numero.DOIS, linha[1]);
		Assert.assertEquals(Numero.TRES, linha[2]);
		Assert.assertEquals(Numero.QUATRO, linha[3]);
		Assert.assertEquals(Numero.CINCO, linha[4]);
		Assert.assertEquals(Numero.SEIS, linha[5]);
		Assert.assertEquals(Numero.SETE, linha[6]);
		Assert.assertEquals(Numero.OITO, linha[7]);
		Assert.assertEquals(Numero.NOVE, linha[8]);
		
	}
	
	@Test
	public void testVerificaLinhaSetorComElementosCorretos(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//cria uma linha
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.DOIS;
		n1[0][2] = Numero.TRES;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.CINCO;
		n2[0][2] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorHorizontal(0);
		Assert.assertNotNull(setor);
		
		Numero[] linha = setor.getLinha(0);
		Assert.assertEquals(9, linha.length);
		
		try{
			new VerificaLinhaEColuna(linha);
			
		}catch(LinhaOuColunaInvalidaException ex){
			Assert.fail("A linha está correta e o verificador" +
						"está lançando exception!");
		}
	}
	
	@Test
	public void testVerificaLinhaSetorComElementosCorretosMaisBrancos(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//cria uma linha
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.DOIS;
		n1[0][2] = Numero.BRANCO;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.BRANCO;
		n2[0][2] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.BRANCO;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorHorizontal(0);
		Assert.assertNotNull(setor);
		
		Numero[] linha = setor.getLinha(0);
		Assert.assertEquals(9, linha.length);
		
		try{
			new VerificaLinhaEColuna(linha);
			
		}catch(LinhaOuColunaInvalidaException ex){
			Assert.fail("A linha está correta e o verificador" +
						"está lançando exception!");
		}
	}
	
	@Test
	public void testVerificaClasseDeVericacaoDeLinhaLancandoException(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//cria uma linha
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.DOIS;
		n1[0][2] = Numero.BRANCO;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.QUATRO;
		n2[0][2] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.BRANCO;
		n3[0][1] = Numero.NOVE;
		n3[0][2] = Numero.NOVE;
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorHorizontal(0);
		Assert.assertNotNull(setor);
		
		Numero[] linha = setor.getLinha(0);
		Assert.assertEquals(9, linha.length);
		
		try{
			new VerificaLinhaEColuna(linha);
			Assert.fail("A Linha está incorreta");
		}catch(LinhaOuColunaInvalidaException ex){
		}
	}
	
	@Test
	public void verificaTodasAsLinhasCorretasDeUmSetor(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//criando quadrantes completos
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.DOIS;
		n1[0][2] = Numero.TRES;
		n1[1][0] = Numero.QUATRO;
		n1[1][1] = Numero.CINCO;
		n1[1][2] = Numero.SEIS;
		n1[2][0] = Numero.SETE;
		n1[2][1] = Numero.OITO;
		n1[2][2] = Numero.NOVE;
		      
		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.CINCO;
		n2[0][2] = Numero.SEIS;
		n2[1][0] = Numero.SETE;
		n2[1][1] = Numero.OITO;
		n2[1][2] = Numero.NOVE;
		n2[2][0] = Numero.UM;
		n2[2][1] = Numero.DOIS;
		n2[2][2] = Numero.TRES;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;
		n3[1][0] = Numero.UM;
		n3[1][1] = Numero.DOIS;
		n3[1][2] = Numero.TRES;
		n3[2][0] = Numero.QUATRO;
		n3[2][1] = Numero.CINCO;
		n3[2][2] = Numero.SEIS;
		
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorHorizontal(0);
		Assert.assertNotNull(setor);
		
		//verifico cada linha
		Numero[] linha = setor.getLinha(0);
		Assert.assertEquals(9, linha.length);
		Numero[] linha1 = setor.getLinha(1);
		Assert.assertEquals(9, linha1.length);
		Numero[] linha2 = setor.getLinha(2);
		Assert.assertEquals(9, linha2.length);
		
		//passo cada linha para o verificaLinha
		try{
			new VerificaLinhaEColuna(linha);
			new VerificaLinhaEColuna(linha1);
			new VerificaLinhaEColuna(linha2);
			
		}catch(LinhaOuColunaInvalidaException ex){
			Assert.fail("A linha está correta e o verificador" +
						"está lançando exception!");
		}
	}
	
	@Test
	public void verificaTodasAsLinhasCertasComBrancosDeUmSetor(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//criando quadrantes completos
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.DOIS;
		n1[0][2] = Numero.TRES;
		n1[1][0] = Numero.BRANCO;
		n1[1][1] = Numero.CINCO;
		n1[1][2] = Numero.SEIS;
		n1[2][0] = Numero.SETE;
		n1[2][1] = Numero.OITO;
		n1[2][2] = Numero.BRANCO;
		      
		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.CINCO;
		n2[0][2] = Numero.SEIS;
		n2[1][0] = Numero.BRANCO;
		n2[1][1] = Numero.OITO;
		n2[1][2] = Numero.NOVE;
		n2[2][0] = Numero.UM;
		n2[2][1] = Numero.DOIS;
		n2[2][2] = Numero.BRANCO;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.BRANCO;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;
		n3[1][0] = Numero.UM;
		n3[1][1] = Numero.DOIS;
		n3[1][2] = Numero.TRES;
		n3[2][0] = Numero.QUATRO;
		n3[2][1] = Numero.CINCO;
		n3[2][2] = Numero.SEIS;
		
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorHorizontal(0);
		Assert.assertNotNull(setor);
		
		//verifico cada linha
		Numero[] linha = setor.getLinha(0);
		Assert.assertEquals(9, linha.length);
		Numero[] linha1 = setor.getLinha(1);
		Assert.assertEquals(9, linha1.length);
		Numero[] linha2 = setor.getLinha(2);
		Assert.assertEquals(9, linha2.length);
		
		//passo cada linha para o verificaLinha
		try{
			new VerificaLinhaEColuna(linha);
			new VerificaLinhaEColuna(linha1);
			new VerificaLinhaEColuna(linha2);
			
		}catch(LinhaOuColunaInvalidaException ex){
			Assert.fail("A linha está correta e o verificador" +
						"está lançando exception!");
		}
	}
	
	@Test
	public void verificaTodasAsLinhasErradasDeUmSetor(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//criando quadrantes completos
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.DOIS;
		n1[0][2] = Numero.TRES;
		n1[1][0] = Numero.QUATRO;
		n1[1][1] = Numero.CINCO;
		n1[1][2] = Numero.SEIS;
		n1[2][0] = Numero.SETE;
		n1[2][1] = Numero.OITO;
		n1[2][2] = Numero.NOVE;
		      
		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.UM;
		n2[0][1] = Numero.CINCO;
		n2[0][2] = Numero.SEIS;
		n2[1][0] = Numero.SETE;
		n2[1][1] = Numero.OITO;
		n2[1][2] = Numero.NOVE;
		n2[2][0] = Numero.UM;
		n2[2][1] = Numero.DOIS;
		n2[2][2] = Numero.TRES;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;
		n3[1][0] = Numero.UM;
		n3[1][1] = Numero.DOIS;
		n3[1][2] = Numero.TRES;
		n3[2][0] = Numero.QUATRO;
		n3[2][1] = Numero.CINCO;
		n3[2][2] = Numero.SEIS;
		
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorHorizontal(0);
		Assert.assertNotNull(setor);
		
		//verifico cada linha
		Numero[] linha = setor.getLinha(0);
		Assert.assertEquals(9, linha.length);
		Numero[] linha1 = setor.getLinha(1);
		Assert.assertEquals(9, linha1.length);
		Numero[] linha2 = setor.getLinha(2);
		Assert.assertEquals(9, linha2.length);
		
		//passo cada linha para o verificaLinha
		try{
			new VerificaLinhaEColuna(linha);
			new VerificaLinhaEColuna(linha1);
			new VerificaLinhaEColuna(linha2);
			
			Assert.fail("A linha está incorreta e o verificador" +
			"não está lançando exception!");
		}catch(LinhaOuColunaInvalidaException ex){
		}
	}
	
	@Test
	public void testVerificaGetColunaDoSetor(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//cria uma coluna
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[1][0] = Numero.DOIS;
		n1[2][0] = Numero.TRES;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[1][0] = Numero.CINCO;
		n2[2][0] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[1][0] = Numero.OITO;
		n3[2][0] = Numero.NOVE;
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[1][0].setValor(n2);
		tab.getTabuleiro()[2][0].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorVertical(0);
		Assert.assertNotNull(setor);
		
		Numero[] coluna = setor.getColuna(0);
		Assert.assertEquals(9, coluna.length);
		
		Assert.assertEquals(Numero.UM, coluna[0]);
		Assert.assertEquals(Numero.DOIS, coluna[1]);
		Assert.assertEquals(Numero.TRES, coluna[2]);
		Assert.assertEquals(Numero.QUATRO, coluna[3]);
		Assert.assertEquals(Numero.CINCO, coluna[4]);
		Assert.assertEquals(Numero.SEIS, coluna[5]);
		Assert.assertEquals(Numero.SETE, coluna[6]);
		Assert.assertEquals(Numero.OITO, coluna[7]);
		Assert.assertEquals(Numero.NOVE, coluna[8]);
	}
	
	@Test
	public void testVerificaColunaSetorComElementosCorretos(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//cria uma linha
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[1][0] = Numero.DOIS;
		n1[2][0] = Numero.TRES;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[1][0] = Numero.CINCO;
		n2[2][0] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[1][0] = Numero.OITO;
		n3[2][0] = Numero.NOVE;
		
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[1][0].setValor(n2);
		tab.getTabuleiro()[2][0].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorVertical(0);
		Assert.assertNotNull(setor);
		
		Numero[] coluna = setor.getColuna(0);
		Assert.assertEquals(9, coluna.length);
		
		try{
			new VerificaLinhaEColuna(coluna);
			
		}catch(LinhaOuColunaInvalidaException ex){
			Assert.fail("A coluna está correta e o verificador" +
						"está lançando exception!");
		}
	}
	
	@Test
	public void testVerificaColunaSetorComElementosCorretosMaisBrancos(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//cria uma coluna
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[1][0] = Numero.DOIS;
		n1[2][0] = Numero.BRANCO;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[1][0] = Numero.BRANCO;
		n2[2][0] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.BRANCO;
		n3[1][0] = Numero.OITO;
		n3[2][0] = Numero.NOVE;
		
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[1][0].setValor(n2);
		tab.getTabuleiro()[2][0].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorVertical(0);
		Assert.assertNotNull(setor);
		
		Numero[] coluna = setor.getColuna(0);
		Assert.assertEquals(9, coluna.length);
		
		try{
			new VerificaLinhaEColuna(coluna);
			
		}catch(LinhaOuColunaInvalidaException ex){
			Assert.fail("A coluna está correta e o verificador" +
						"está lançando exception!");
		}
	}
	
	@Test
	public void testVerificaClasseDeVericacaoDeColunaLancandoException(){
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//cria uma linha
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[1][0] = Numero.DOIS;
		n1[2][0] = Numero.BRANCO;

		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[1][0] = Numero.QUATRO;
		n2[2][0] = Numero.SEIS;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.BRANCO;
		n3[1][0] = Numero.NOVE;
		n3[2][0] = Numero.NOVE;
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[1][0].setValor(n2);
		tab.getTabuleiro()[2][0].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorHorizontal(0);
		Assert.assertNotNull(setor);
		
		Numero[] coluna = setor.getLinha(0);
		Assert.assertEquals(9, coluna.length);
		
		try{
			new VerificaLinhaEColuna(coluna);
			Assert.fail("A Coluna está incorreta");
		}catch(LinhaOuColunaInvalidaException ex){
		}
	}
	
	@Test
	public void verificaTodasAsColunasCorretasDeUmSetor(){
		/*Teste apenas COPIADO... Ainda não está testando
		o que queremos...*/
		
		//Preparaçao
		Tabuleiro tab = new Tabuleiro();
		
		//criando quadrantes completos
		Numero[][] n1 = new Numero[3][3];		
		n1[0][0] = Numero.UM;
		n1[0][1] = Numero.DOIS;
		n1[0][2] = Numero.TRES;
		n1[1][0] = Numero.QUATRO;
		n1[1][1] = Numero.CINCO;
		n1[1][2] = Numero.SEIS;
		n1[2][0] = Numero.SETE;
		n1[2][1] = Numero.OITO;
		n1[2][2] = Numero.NOVE;
		      
		Numero[][] n2 = new Numero[3][3];		
		n2[0][0] = Numero.QUATRO;
		n2[0][1] = Numero.CINCO;
		n2[0][2] = Numero.SEIS;
		n2[1][0] = Numero.SETE;
		n2[1][1] = Numero.OITO;
		n2[1][2] = Numero.NOVE;
		n2[2][0] = Numero.UM;
		n2[2][1] = Numero.DOIS;
		n2[2][2] = Numero.TRES;

		Numero[][] n3 = new Numero[3][3];		
		n3[0][0] = Numero.SETE;
		n3[0][1] = Numero.OITO;
		n3[0][2] = Numero.NOVE;
		n3[1][0] = Numero.UM;
		n3[1][1] = Numero.DOIS;
		n3[1][2] = Numero.TRES;
		n3[2][0] = Numero.QUATRO;
		n3[2][1] = Numero.CINCO;
		n3[2][2] = Numero.SEIS;
		
		tab.getTabuleiro()[0][0].setValor(n1);
		tab.getTabuleiro()[0][1].setValor(n2);
		tab.getTabuleiro()[0][2].setValor(n3);
		
		//Verificação
		Setor setor = tab.getSetorVertical(0);
		Assert.assertNotNull(setor);
		
		//verifico cada coluna
		Numero[] linha = setor.getLinha(0);
		Assert.assertEquals(9, linha.length);
		Numero[] linha1 = setor.getLinha(1);
		Assert.assertEquals(9, linha1.length);
		Numero[] linha2 = setor.getLinha(2);
		Assert.assertEquals(9, linha2.length);
		
		//passo cada linha para o verificaLinha
		try{
			new VerificaLinhaEColuna(linha);
			new VerificaLinhaEColuna(linha1);
			new VerificaLinhaEColuna(linha2);
			
		}catch(LinhaOuColunaInvalidaException ex){
			Assert.fail("A linha está correta e o verificador" +
						"está lançando exception!");
		}
	}
}
