import java.lang.Math;
import java.util.Scanner;

public class Particles {
		
	public static void runSimulation (int n , int s , int t ) {
		
	//Grittet består af nxn matric://
	//n skal være positiv//
	
	System.out.println("n="+n+" s="+s+" t="+t);
	
	//Start positionerne//
		
	int P1x=(int)Math.abs(Math.random()*n);
	int P1y=(int)Math.abs(Math.random()*n);
	int P2x=(int)Math.abs(Math.random()*n);
	int P2y=(int)Math.abs(Math.random()*n);
	int P3x=(int)Math.abs(Math.random()*n);
	int P3y=(int)Math.abs(Math.random()*n);
	
	System.out.println("move "+0+", positions P1["+P1x+";"+P1y+"]"+" P2["+P2x+";"+P2y+"]"+" P3["+P3x+";"+P3y+"]");
	
	
	//for loop begyndelse. Køre antal gange til t//
	for(int i=1;i < t+1 ;i++) {
	
	
	//En tildfældig værdi [-s,s] lægges til startværdien//
	
		P1x=P1x+(-s +(int)(Math.random()*((s-(-s))+1)));
		P1y=P1y+(-s +(int)(Math.random()*((s-(-s))+1)));
		P2x=P2x+(-s +(int)(Math.random()*((s-(-s))+1)));
		P2y=P2y+(-s +(int)(Math.random()*((s-(-s))+1)));
		P3x=P3x+(-s +(int)(Math.random()*((s-(-s))+1)));
		P3y=P3y+(-s +(int)(Math.random()*((s-(-s))+1)));
	
	//hvis partiklen kommer uden for grittet, kommer det tilbage på den nærmeste plads som er det yderste værdi n eller 0
	if (P1x>n) {P1x=n;}
	if (P1y>n) {P1y=n;}
	if (P1x<0) {P1x=0;}
	if (P1y<0) {P1y=0;}
	
	if (P2x>n) {P2x=n;}
	if (P2y>n) {P2y=n;}
	if (P2x<0) {P2x=0;}
	if (P2y<0) {P2y=0;}
	
	if (P3x>n) {P3x=n;}
	if (P3y>n) {P3y=n;}
	if (P3x<0) {P3x=0;}
	if (P3y<0) {P3y=0;}
	

	//da move 0 er start positionerne begynder tælleren på 1. 
	
	System.out.println("move "+i+", positions P1["+P1x+";"+P1y+"]"+" P2["+P2x+";"+P2y+"]"+" P3["+P3x+";"+P3y+"]");
	}
	}
}


