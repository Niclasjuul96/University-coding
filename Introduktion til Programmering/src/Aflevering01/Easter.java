public class Easter {

	public static String computeEaster(int year) {
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

		return (yearFormat(y) + " " + calcDate((days - 2), month) + " " + calcDate(days, month) + " "
				+ calcDate((days + 1), month));

	}

	public static String calcDate(int d, int m) {

		if (m + (d / 32) == 3) {
			return dateFormat(d) + ".0" + m;
		}
		return dateFormat(d - 31) + ".0" + (m + 1);
	}

	public static String dateFormat(int d) {
		if (d < 10) {
			return "0" + d;
		}
		return "" + d;

	}

	public static String yearFormat(int y) {
		String n = Integer.toString(y);
		for (int i = n.length(); i < 4; i++) {
			n = "0" + n;
		}
		return n;
	}
}

