package Uge01;

public class ControlFlowEx {
	public static void main(String[] args) {
		message1();
		message2();
		System.out.println("End of main.");
	}

	public static void message1() {
		System.out.println("Message 1.");
	}

	public static void message2() {
		System.out.println("Start of message2.");
		message1();
		System.out.println("End of message2.");
	}
}