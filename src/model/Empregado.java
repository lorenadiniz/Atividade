package model;

public class Empregado {
	private String nome;
	private int horas;
	private double valorPorHora;

	public static final Double SALARIO_MINIMO = 1100.0;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isBlank()) {
			throw new IllegalArgumentException("O nome não pode estar vazio");
		}
		this.nome = nome;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		if (horas > 40){
			throw new IllegalArgumentException("O número de horas trabalhadas por funcionários deve ser menor ou igual a 40 horas mensais.");
		}
		this.horas = horas;
	}

	public double getValorPorHora( ) {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		if (valorPorHora < 30.00 && valorPorHora > 200.00){
			throw new IllegalArgumentException("O valor das horas por hora não pode ser inferior a 30,00 e não pode ser superior á 200,00.");
		}
		this.valorPorHora = valorPorHora;
	}

	public double realizarPagamento(){
		Double valorAPagar = 0.0;
		valorAPagar = (horas * valorPorHora) > SALARIO_MINIMO ? horas * valorPorHora : SALARIO_MINIMO;
		return valorAPagar;

	}
}