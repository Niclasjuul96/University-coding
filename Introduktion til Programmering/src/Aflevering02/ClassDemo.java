public class ClassDemo{

    public static void main(String[] args) {
        FractionR f1 = new FractionR(4, 2);
		FractionR f2 = new FractionR(5, 3);
		FractionR f3 = new FractionR(1, 7);
		FractionR f4 = new FractionR(6, 24);
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f4);
		System.out.println(f2.reciprocal());
		System.out.println(f1.plus(f2));
		System.out.println(f1.minus(f2));
		System.out.println(f1.times(f2));
		System.out.println(f1.divideBy(f2));
		FractionR fr = ((f4.divideBy(f3)).plus(f1)).minus(f2);
		System.out.println(fr);
    }

}