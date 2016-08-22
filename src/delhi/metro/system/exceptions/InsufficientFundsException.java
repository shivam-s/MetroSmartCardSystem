package delhi.metro.system.exceptions;

public class InsufficientFundsException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientFundsException(String message, double balance) {
		System.out.println("Insufficient Balance Exception :" + message
				+ balance);
	}

}
