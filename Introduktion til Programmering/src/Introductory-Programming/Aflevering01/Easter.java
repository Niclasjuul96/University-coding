public class Easter {

	
	public static String computeEaster(int year) {
		//den matematiske funktion der er blevet givet i opgaven, hvor year bliver til y
		int y = year;
		int a, b, c, d, e, f, days;
		int month = 3;
		a = y % 4;
		b = y % 7;
		c = y % 19;
		d = (19 * c + 24) % 30;
		e = (2 * a + 4 * b + 6 * d + 5) % 7;
		f = (c + 11 * d + 22 * e) / 451;
		days = 22 + d + e - 7 * f;

		//Her bliver alle de forskellige metoder kaldet for at lave det endelige output
		return (yearFormat(y) + " " + calcDate((days - 2), month) + " " + calcDate(days, month) + " "
				+ calcDate((days + 1), month));

	}

	public static String calcDate(int d, int m) {
		//denne metode bruges til at finde ud af om det er påske i enten marts eller april
		if (m + (d / 32) == 3) {
			return dateFormat(d) + ".0" + m;
		}
		return dateFormat(d - 31) + ".0" + (m + 1);
	}

	public static String dateFormat(int d) {
		//Denne metode sørger for at hvis dagene er mindre end 1+ vil der blive prtinet et 0 foran
		if (d < 10) {
			return "0" + d;
		}
		return "" + d;

	}

	public static String yearFormat(int y) {
		//Denne funktion tager en y værdi og laver den om til en string, for derefter at køre den
		//igennem et loop og sætte et hvis antal 0 foran, hvis y er mindre end 1000
		String n = Integer.toString(y);
		for (int i = n.length(); i < 4; i++) {
			n = "0" + n;
		}
		return n;
	}
}
