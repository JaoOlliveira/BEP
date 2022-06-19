package bep;

public class Bordado {

	private String tamanho[][];
	private int quantidadePontos;

	Bordado(int linha, int coluna) {
		this.tamanho = new String[linha][coluna];
		this.quantidadePontos = 0;
	}
	
	
	public void atualizarBordado(String ponto, int linha, int coluna) {
		this.tamanho[linha-1][coluna-1] = ponto;
	}

	public String imprimirBordado() {
		String borda = this.gerarBorda();
		String bordado = borda + "\n";
		
		for (int i = 0; i < tamanho.length; i++) {
			String linha = "";
			for (int j = -1; j <= tamanho[i].length ; j++) {
				if (j == -1 || j == tamanho[i].length) {
					linha += "|";
				} else {
					if (tamanho[i][j] != null) {
						linha += tamanho[i][j];
					} else {
						linha += " ";
					}
				}
			}
			bordado += linha + "\n";
		}
		
		bordado += borda;
		return bordado;

	}
	
	public void alterarTamanhoBordado(int linha, int coluna) {
		
	}
	
	private String gerarBorda() {
		String borda = "|";
		for (int i = 0; i < tamanho[1].length; i++) {
			borda += "-";
		}
		borda += "|";

		return borda;
	}
}
