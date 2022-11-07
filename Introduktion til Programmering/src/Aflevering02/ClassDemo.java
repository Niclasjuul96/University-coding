public class ClassDemo{

    public static void main(String[] args) {
        Fraction f1 = new Fraction(4,2);
        Fraction f2 = new Fraction(5,3);
        Fraction f3 = new Fraction(1,7);
        Fraction f4 = new Fraction(6,24);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f2.reciprocal());
        System.out.println(f1.plus(f2));
        System.out.println(f1.minus(f2));
        System.out.println(f1.times(f2));
        System.out.println(f1.divideBy(f2));
        Fraction fr = ((f4.divideBy(f3)).plus(f1)).minus(f2);
        System.out.println(fr);
    }

}