package bep;

import java.util.Scanner;

import regras.BordadoRegra;

public class BEP {
	
	static BordadoRegra regrasBordado = new BordadoRegra();
	static BordadoRepositorio bordadoRepositorio = new BordadoRepositorio();
	static ColetaneaRepositorio coletaneaRepositorio = new ColetaneaRepositorio();
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Bem-vind@ ao sistema de bordados!");
		
		while(true) {
			int bordadosDisponiveis = 10 - bordadoRepositorio.getQuantidadeBordados();
			
			System.out.println("\nVocê pode cadastrar " + bordadosDisponiveis  + " bordados. O que deseja fazer?");
			System.out.println("A - Cadastrar bordado");
			System.out.println("B - Atualizar Bordado");
			System.out.println("C - Imprimir bordado");
			System.out.println("D - Listar bordados");
			System.out.println("E - Alterar tamanho do bordado");
			System.out.println("F - Cadastrar coletanea");
			System.out.println("G - Imprimir coletanea");
			System.out.println("000 - Finalizar");
			System.out.print("Acao> ");
			String acao = sc.nextLine();
			
			switch (acao) {
			
			case "A": cadastrarBordado(); break;
			case "B": atualizarBordado(); break;
			case "C": imprimirBordado(); break;
			case "D": listarBordados(); break;
			case "F": cadastrarColetanea(); break;
			case "G": imprimirColetanea(); break;
			case "000": break;	
			default: System.out.println("\n //ERRO - Opção inválida \n");
				
			}
			
			if(acao.equals("000")) {
				break;
			}
			
		}
		
		System.out.println("O programa foi encerrado!");
		

	}
	
	public static void cadastrarBordado() {
		System.out.print("Numero do bordado [0-9]: ");
		int id = sc.nextInt();
		if(regrasBordado.verificaIdBordado(id)) {
			System.out.println("\n //ERRO - Numero do bordado fora do intervalo permitido \n");
			return;
		}
		System.out.print("Numero de linhas [2-100]: ");
		int linha = sc.nextInt();
		if(regrasBordado.verificaNumeroLinhasCadastro(linha)) {
			System.out.println("\n //ERRO - Numero inválido de linhas \n");
			return;
		}
		System.out.print("Numero de colunas [2-100]: ");
		int coluna = sc.nextInt();
		if(regrasBordado.verificaNumeroColunasCadastro(coluna)) {
			System.out.println("\n //ERRO - Numero inválido de colunas \n");
			return ;
		}
		sc.nextLine();
		
		bordadoRepositorio.cadastrarBordado(id, linha, coluna);
		
		return;
	}
	
	public static void atualizarBordado() {
		System.out.print("Numero do bordado [0-9] : ");
		int id = sc.nextInt();
		
		if(bordadoRepositorio.verificaIdBordado(id)) {
			System.out.println("\n //ERRO - Bordado informado não existe \n");
			return;
		}
		
		System.out.println("No a ser colocado no bordado [/ \\ | - x, vazio para remover um ja existente]");
		String ponto = sc.next();
		if(regrasBordado.verificaPonto(ponto)) {
			System.out.println("\n //ERRO - No invalido \n");
			return;
		}
		
		System.out.print("Numero de linhas [1-x] : ");
		int linha = sc.nextInt();
		if(regrasBordado.verificaNumeroLinhasAtualizacao(linha)) {
			System.out.println("\n //ERRO - Numero inválido de linhas \n");
			return;
		}
		
		System.out.print("Numero de colunas [1-x] : ");
		int coluna = sc.nextInt();
		if(regrasBordado.verificaNumeroColunasAtualizacao(coluna)) {
			System.out.println("\n //ERRO - Numero inválido de colunas \n");
			return ;
		}
		
		sc.nextLine();
		
		bordadoRepositorio.atualizarBordado(id,ponto, linha, coluna);
		
		return;
	}
	
	public static void imprimirBordado() {
		System.out.print("Numero do bordado [0-9] : ");
		int id = sc.nextInt();
		
		if(bordadoRepositorio.verificaIdBordado(id)) {
			System.out.println("\n //ERRO - Bordado informado não existe \n");
			return;
		}
		
		System.out.println(bordadoRepositorio.imprimirBordado(id));
	}
	
	public static void listarBordados() {

		String bordados[] = bordadoRepositorio.listarBordado();
		
		if(bordados.length == 0) {
			System.out.println("\n //Nenhum bordado cadastrado \n");
		}
		
		for (int i = 0; i < bordados.length; i++) {
			System.out.println(bordados[i]);
		}
	}
	
	public static void cadastrarColetanea() {
		System.out.print("Numero da coletanea [1-10]: ");
		int idColetanea = sc.nextInt();
		System.out.print("Total de bordados a serem inseridos: ");
		int numeroBordados = sc.nextInt();
		Bordado bordados[] = new Bordado[numeroBordados];
		for (int i = 0; i < numeroBordados; i++) {
			System.out.print((i+1) +"° Bordado a ser inserido: ");
			int idBordados = sc.nextInt();
			bordados[i] = bordadoRepositorio.getBordados(idBordados);
		}
		coletaneaRepositorio.adicionarColetanea(idColetanea, bordados);
		sc.nextLine();
		
	}
	
	public static void imprimirColetanea() {
		System.out.print("Numero da coletanea [1-10]: ");
		int idColetanea = sc.nextInt();
		String coletanea[] = coletaneaRepositorio.imprimirColetanea(idColetanea);
		
		for (int i = 0; i < coletanea.length; i++) {
			System.out.println(coletanea[i]);
		}
	}
}
