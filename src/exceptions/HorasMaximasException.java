package exceptions;

public class HorasMaximasException extends Exception {
	public HorasMaximasException() {
		super("Funcionários podem trabalhar no máximo 40 horas.");
	}
}
