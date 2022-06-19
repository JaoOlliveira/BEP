package bep;

public class ColetaneaRepositorio {

	private Coletanea coletaneas[];
	private int quantidadeColetaneas;

	ColetaneaRepositorio() {
		this.coletaneas = new Coletanea[10];
		this.quantidadeColetaneas = 0;
	}

	public void adicionarColetanea(int idColetanea, Bordado[] bordado) {
		if (this.coletaneas[idColetanea] == null) {
			if (this.quantidadeColetaneas < 10)
				this.coletaneas[idColetanea] = new Coletanea();
			this.coletaneas[idColetanea].adicionarBordados(bordado);
			this.quantidadeColetaneas++;
		} else {
			this.coletaneas[idColetanea].adicionarBordados(bordado);
		}
	}

	public String[] imprimirColetanea(int idColetanea) {
		return this.coletaneas[idColetanea].imprimirColetanea();
	}

}
