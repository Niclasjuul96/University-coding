import Uge03.Factorial;

public class Fraction{
    int a;
    int b;
    


    public Fraction(int numerator, int denominator) {
        a = numerator;
        b = denominator;
    }

    
    public String toString(){

        String s = "("+ a + "/" + b + ")";

        return s;
    }


    
    public Fraction plus(Fraction f){
        int af;
        int bf;

        String s = f.toString();

        s = s.substring(1, s.length()-1);
        String array[] = s.split("/");

        af = Integer.parseInt(array[0]);
        bf = Integer.parseInt(array[1]);

        af += a;
        bf += b;

        f.a = af;
        f.b = bf;

        return f;
    }
 
    public Fraction minus(Fraction f){
        int af;
        int bf;

        String s = f.toString();

        s = s.substring(1, s.length()-1);
        String array[] = s.split("/");

        af = Integer.parseInt(array[0]);
        bf = Integer.parseInt(array[1]);

        af -= a;
        bf -= b;
        
        f.a = af;
        f.b = bf;

        return f;
    }

    public Fraction times(Fraction f){
        int af;
        int bf;

        String s = f.toString();

        s = s.substring(1, s.length()-1);
        String array[] = s.split("/");

        af = Integer.parseInt(array[0]);
        bf = Integer.parseInt(array[1]);

        af *= a;
        bf *= b;
        
        f.a = af;
        f.b = bf;

        return f;
    }

    public Fraction divideBy(Fraction f){
        int af;
        int bf;

        String s = f.toString();

        s = s.substring(1, s.length()-1);
        String array[] = s.split("/");

        af = Integer.parseInt(array[0]);
        bf = Integer.parseInt(array[1]);

        af /= a;
        bf /= b;
        
        f.a = af;
        f.b = bf;

        return f;
    }

    public String reciprocal(){
        int placeholder = a;
        a = b; 
        b = placeholder;
        return  "("+ a + "/" + b + ")";
    }
    
}