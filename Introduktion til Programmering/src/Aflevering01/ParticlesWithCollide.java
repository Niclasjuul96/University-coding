
public class ParticlesWithCollide {
	public static void runSimulation (int n, int s, int t ) {

		//n skal være positiv//
		//Linjen med værdierne printes som krævet//
		System.out.println("n="+n+" s="+s+" t="+t);

		//Start positionerne//

		int P1x=(int)(Math.random()*n);
		int P1y=(int)(Math.random()*n);
		int P2x=(int)(Math.random()*n);
		int P2y=(int)(Math.random()*n);

		//Start postionerne printes//
		
		System.out.print("move "+0+", positions");
		System.out.println("P1["+P1x+";"+P1y+"]"+" P2["+P2x+";"+P2y+"]");
		//En værdi for moves defineres uden for loopet. Den huskes som i//
		int rememberi=1;
		//for loop begyndelse. Koere antal gange til t//
		for(int i=1;i<t+1;i++){

			rememberi+=1;
			//En tildfaeldig vaerdi [-s,s] laegges til startvaerdien//

			P1x=P1x+(-s+(int)(Math.random()*((s-(-s))+1)));
			P1y=P1y+(-s+(int)(Math.random()*((s-(-s))+1)));
			P2x=P2x+(-s+(int)(Math.random()*((s-(-s))+1)));
			P2y=P2y+(-s+(int)(Math.random()*((s-(-s))+1)));

			//hvis partiklen kommer uden for grittet, kommer det tilbage på den naermeste plads som er det yderste værdi n eller 0
			if (P1x>n) {P1x=n;}
			if (P1y>n) {P1y=n;}
			if (P1x<0) {P1x=0;}
			if (P1y<0) {P1y=0;}

			if (P2x>n) {P2x=n;}
			if (P2y>n) {P2y=n;}
			if (P2x<0) {P2x=0;}
			if (P2y<0) {P2y=0;}

			if (P1x==P2x && P1y==P2y) {
				System.out.print("move "+i+", positions P1[");
				System.out.println(P1x+";"+P1y+"]"+" P2["+P2x+";"+P2y+"]");
				System.out.println("particles collide");
				break;
			}
			//Ved kollision (positionerne er ens) stopper loopet
			//da move 0 er start positionerne begynder tælleren på 1.
			System.out.print("move "+i+", positions P1["+P1x+";"+P1y+"]");
			System.out.println(" P2["+P2x+";"+P2y+"]");
			//Et ny loop begynder kun med partikel 1
		}
		for(int i=rememberi;i<t+1;i++){
			P1x=P1x+(-s+(int)(Math.random()*((s-(-s))+1)));
			P1y=P1y+(-s+(int)(Math.random()*((s-(-s))+1)));	
			if (P1x>n) {P1x=n;}
			if (P1y>n) {P1y=n;}
			if (P1x<0) {P1x=0;}
			if (P1y<0) {P1y=0;}
			System.out.println("move "+i+", positions P1["+P1x+";"+P1y+"]");
		}
	}
}