package model;

public class EmpregadoTerceirizado extends Empregado {

	private double adicional;

	public double getAdicional() {

		return adicional;
	}

	public void setAdicional(double adicional) {

		if (adicional >= 100.0 && adicional <= 1100.0) {
			throw new IllegalArgumentException("O adicional deve ser entre 100,00 e 1.100,00");
		}

		this.adicional = adicional;
	}

	public void setAdicional() {
		adicional = 0;
	}

	public double realizarPagamento() {
		Double valorAPagar = 0.0;
		valorAPagar = (getHoras() * getValorPorHora() + adicional) > SALARIO_MINIMO
				? getHoras() * getValorPorHora() + adicional
				: SALARIO_MINIMO;
		return valorAPagar;
	}

}