package bep;

public class BordadoRepositorio {
	
	private Bordado bordados[] ;
	private int quantidadeBordados;
	
	BordadoRepositorio() {
		this.bordados = new Bordado[10];
		this.quantidadeBordados = 0;
	}
	
	public void cadastrarBordado(int idBordado, int linha, int coluna ) {
		bordados[idBordado] = new Bordado(linha,coluna);
		this.quantidadeBordados++;
	}
	
	public void atualizarBordado(int idBordado, String ponto, int linha, int coluna ) {
		bordados[idBordado].atualizarBordado(ponto, linha, coluna);
	}
	
	public String imprimirBordado(int idBordado) {
		return bordados[idBordado].imprimirBordado();
	}
	
	public String[] listarBordado() {
		String listaBordados[] = new String[quantidadeBordados];
		int index = 0;
		for (int i = 0; i < this.bordados.length; i++) {
			if(this.bordados[i] != null) {
				listaBordados[index] = this.bordados[i].imprimirBordado();
				index++;
			}
		}
		
		return listaBordados;
	}
	
	
	public void alterarTamanhoBordado(int idBordado, int linha, int coluna) {
		
	}
	
	public boolean verificaIdBordado(int idBordado) {
		
		if(this.bordados[idBordado] == null) {
			return true;
		}
		
		return false;
	}
	
	public int getQuantidadeBordados() {
		return quantidadeBordados;
	}

	public void setQuantidadeBordados(int quantidadeBordados) {
		this.quantidadeBordados = quantidadeBordados;
	}


	
	public Bordado getBordados(int idBordado) {
		return bordados[idBordado];
	}
	
	


}
