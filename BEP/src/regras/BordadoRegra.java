package regras;

public class BordadoRegra {
	
	
	public boolean verificaIdBordado(int id) {
		
		if(id >= 0 && id <= 9) {
			return false;
		}
		
		return true;
	}
	
	public boolean verificaNumeroLinhasCadastro(int linhas) {
		
		if(linhas >= 2 && linhas <= 100) {
			return false;
		}
		
		return true;
	}
	
	public boolean verificaNumeroColunasCadastro(int colunas) {
			
		if(colunas >= 2 && colunas <= 100) {
			return false;
		}
		return true;
	}
	
	public boolean verificaNumeroLinhasAtualizacao(int linhas) {
		
		if(linhas >= 1 && linhas <= 100) {
			return false;
		}
		
		return true;
	}
	
	public boolean verificaNumeroColunasAtualizacao(int colunas) {
			
		if(colunas >= 1 && colunas <= 100) {
			return false;
		}
		return true;
	}
	
	
	public boolean verificaPonto(String ponto) {
		
		String pontosValidos[] = {"/","\\","|","-","+","x"," "};
		
		for (int i = 0; i < pontosValidos.length; i++) {
			if(pontosValidos[i].equals(ponto)) {
				return false;
			}
		}
		
		return true;
	}
}
