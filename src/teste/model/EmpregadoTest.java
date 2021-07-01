package teste.model;

import model.Empregado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exceptions.HorasMaximasException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpregadoTest {

	private Empregado empregado1;

	@BeforeEach
	private void instanciaObjeto() {
		empregado1 = new Empregado();
		empregado1.setNome("Empregado Fake");
	}

	/**
	 * @author : Cristian Passos
	 * @description : Método verifica o salário do funcionário, neste caso vai
	 *              retornar uma exceção, Porque o salário esta abaixo do
	 *              salário Mínimo.
	 **/
	@Test
	public void salarioAbaixoDoSalarioMinimoTest() {
		System.out.println("Inicio teste método salarioAbaixoDoSalarioMinimoTest");
		empregado1.setHoras(10);
		empregado1.setValorPorHora(100);
		assertEquals(1100.0, empregado1.realizarPagamento(), 0.0001);
		System.out.println("Fim teste método salarioAbaixoDoSalarioMinimoTest");
	}

	/**
	 * @author : Cristian Passos
	 * @description : Método verifica o salário do funcionário, neste caso não
	 *              vai retornar uma exceção, Porque o salário esta acima do
	 *              salário Mínimo.
	 **/
	@Test
	public void salarioAcimaDoSalarioMinimoTest() {
		System.out.println("Inicio teste método salarioAcimaDoSalarioMinimoTest");
		empregado1.setHoras(40);
		empregado1.setValorPorHora(200);
		assertEquals(8000.0, empregado1.realizarPagamento(), 0.0001);
		System.out.println("Fim teste método salarioAcimaDoSalarioMinimoTest");
	}

	/**
	 * @author : Cristian Passos
	 * @description : Método verifica o salário do funcionário, neste caso não
	 *              vai retornar uma exceção, Porque o salário é igual ao
	 *              salário Mínimo.
	 **/
	@Test
	public void salarioIgualAoSalarioMinimoTest() {
		System.out.println("Inicio teste método salarioIgualAoSalarioMinimoTest");
		empregado1.setHoras(40);
		empregado1.setValorPorHora(27.5);
		assertEquals(1100.0, empregado1.realizarPagamento(), 0.0001);
		System.out.println("Fim teste método salarioIgualAoSalarioMinimoTest");
	}

	/**
	 * @author : Lorena Martins
	 * @description : Valida horas acima do aceito.
	 **/
	@Test
	public void horasTrabalhoMaximoTest() throws HorasMaximasException {
		empregado1.setHoras(45);
		assertEquals(0, empregado1.getHoras());
	}

	/**
	 * @author : Lorena Martins
	 * @description : Valida horas dentro do aceito.
	 **/
	@Test
	public void horasTrabalhoTest() throws HorasMaximasException {
		empregado1.setHoras(35);
		assertEquals(35, empregado1.getHoras());
	}

	/**
	 * @author : Lorena Martins
	 * @description : Valida horas vazias.
	 **/
	@Test
	public void TesteHorasVazias() throws HorasMaximasException {
		empregado1.setHoras();
		assertEquals(0, empregado1.getHoras());
	}
}
