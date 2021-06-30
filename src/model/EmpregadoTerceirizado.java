package model;

public class EmpregadoTerceirizado extends Empregado{

	private double adicional;

	public double getAdicional() {

		return adicional;
	}

	public void setAdicional(double adicional) {

		this.adicional = adicional;
	}

	
    public double realizarPagamento() {
		Double valorAPagar = 0.0;
		valorAPagar = (getHoras() * getValorPorHora() + adicional) > SALARIO_MINIMO ? getHoras() * getValorPorHora() + adicional : SALARIO_MINIMO;
		return valorAPagar;
    }

}