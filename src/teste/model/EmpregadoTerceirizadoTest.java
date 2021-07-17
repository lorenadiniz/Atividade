package teste.model;

import org.junit.jupiter.api.Test;

import model.EmpregadoTerceirizado;
import exceptions.PagFunTerceiroException;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpregadoTerceirizadoTest {

	private EmpregadoTerceirizado empTer;

	@BeforeEach
	private void instaciaObjeto() {
		empTer = new EmpregadoTerceirizado();
	}

	@Test
	public void TesteAdicionalAbaixoDeCem() {
		double adicional = 10.0;
		assertThrows(RuntimeException.class, () -> empTer.setAdicional(adicional));
	}

	@Test
	public void TesteAdicionalAcima() {
		double adicional = 2000.0;
		assertThrows(RuntimeException.class, () -> empTer.setAdicional(adicional));
	}

	@Test
	public void TestePagamentoComAdicional() throws PagFunTerceiroException {
		empTer.setHoras(37);
		empTer.setValorPorHora(100.0);
		empTer.setAdicional(500.00);

		int h = empTer.getHoras();
		double v = empTer.getValorPorHora();
		double a = empTer.getAdicional();
		double total = (h * v) + a;
		assertEquals(total, empTer.realizarPagamento());
	}

	@Test
	public void TesteAdicionalVzio() throws PagFunTerceiroException {
		empTer.setAdicional();
		assertEquals(0, empTer.getAdicional());
	}
	
	
	//teste para validar se é salario minimo. feito por Kelvin
	@Test
	public void TesteRealizaPagemento() throws PagFunTerceiroException {
		double a = empTer.realizarPagamento();
		assertEquals(1100,a);
	}

}
