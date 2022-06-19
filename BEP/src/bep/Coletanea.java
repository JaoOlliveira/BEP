package bep;

public class Coletanea {
	
	private Bordado bordados[];
	private int numeroBordados;
	
	Coletanea(){
		this.bordados = new Bordado[100];
		this.numeroBordados = 0;
	}
	
	public void adicionarBordados(Bordado[] bordado) {
		for (int i = 0; i < bordado.length; i++) {
			this.setBordados(bordado[i]);
		}
		
	}

	public String[] imprimirColetanea() {
		String[] coletanea = new String[this.numeroBordados];
		for (int i = 0; i < this.numeroBordados; i++) {
			coletanea[i] = this.bordados[i].imprimirBordado();
		}
		
		return coletanea;
	}

	public void setBordados(Bordado bordado) {
		if(this.numeroBordados <= 100) {
			this.bordados[this.numeroBordados] = bordado;
			this.numeroBordados++;
		}
	}
	
	
	

	
	
	
}
