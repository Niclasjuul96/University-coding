public class FractionR {
    int a = 0;
    int b = 0;
    
    public FractionR(int a, int b){
        int newa = a;
        int newb = b;

        if(a % b == 0 && a != 0 && b != 0){
            int dom = a/b;
            System.out.println(dom);
            newa = a /dom;
            newb = b /dom;
        }

        this.a = newa;
        this.b = newb;
    }
}
