package Uge01;

public class Opgave9 {
	
	
		public static void main( String[] args) {
		ping ();
		}
		private static void ping () {
		
		System .out. println ("ping");
		pong ();
		System .out. println ("done ping");
		}
		private static void pong () {
		System .out. println ("pong");
		ping ();
		System .out. println ("done pong");
		}
		}


// Dette program looper ind i hinaden derfor kan dette program ikke køres
