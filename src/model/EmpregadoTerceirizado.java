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
	
	
	//ADICIONADO A VALIDAÇÃO A EMPREGADOS TERCEIROS NO VALOR POR GORA ENTRE 30.00 E 200.
	
	public void setValorPorHora(double valorPorHora) {
		if (valorPorHora < 30.00 && valorPorHora > 200.00) {
			throw new IllegalArgumentException(
					"O valor das horas por hora não pode ser inferior a 30,00 e não pode ser superior á 200,00.");
		}
		this.valorPorHora = valorPorHora;
	}

	public double realizarPagamento() {
		Double valorAPagar = 0.0;
		valorAPagar = (getHoras() * getValorPorHora() + adicional) > SALARIO_MINIMO
				? getHoras() * getValorPorHora() + adicional
				: SALARIO_MINIMO;
		return valorAPagar;
	}

}