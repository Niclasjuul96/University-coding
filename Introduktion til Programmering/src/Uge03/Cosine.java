package Uge03;

import java.lang.Math;

public class Cosine {
    
    public static void main(String[] args) {
        test(1,7,11);
    }

    public static void test(int minOrder, int maxOrder, int numbTests){
        double cosMath, cosTaylor, x;

        for(int order = minOrder; order <= maxOrder; order++){
            for(int k = 0; k < numbTests; k++){
                x = Math.PI - 2.0 * Math.PI * (double)k/numbTests-1;
                cosMath = Math.cos(x);
                cosTaylor = cosineT(x, order);
                System.out.println("Order " + order + " x=" + x + " cosM=" + cosMath + " cosT=" + cosTaylor + " difference=" + Math.abs(cosMath - cosTaylor));
            }
        }
    }

    public static double cosineT(double x, int k){
        double result = 0.0;
        int sign = 1;
        for(int i = 0; i <=k;i++){
            result += sign * Math.pow(x, 2*i)/factorial(2*i);
            sign *=-1;
        }
        return result;
    }

    public static int factorial(int n) {
        int f = 1; 
        for(int i = 2; i <= n; i++){
            f *= i; 
        }
        return f;
    }
}
