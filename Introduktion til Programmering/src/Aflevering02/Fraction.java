
public class Fraction{
    //generating fields a as Numerator and b as denominator.
    int a;
    int b;
    

    //generating a new unit and puts the input values into a and b to be stored. 
    public Fraction(int numerator, int denominator) {
        a = numerator;
        b = denominator;
    }

    //our tostring method that gets called when you try to print the object. even tho i created a function checkString.  
    public String toString(){
        String s;

        if(a < 0){
            if(b < 0){
                //if both are negative its resets itself, and nothing happens. 
                s = "("+ a*-1 + "/" + b*-1 + ")";
            }else{
                //if only a is negative, i times a with -1 so a isn't negative, and then add a minus at the start. 
                s = "-("+ a*-1 + "/" + b + ")";
            }
            
        }else{
            if(b < 0){
                //if only b is negative, then set the whole fraction negative, and put b to positive again.
                s = "-("+ a + "/" + b*-1 + ")";
            }else{
                //if nothing is negative, then it does nothing and then outputs without edits. 
                s = "("+ a + "/" + b + ")";
            }
            
        }
        return s;
    }


    //created a function that gets the value a and b from the fraction object, and puts it into a int array. that can gets easily accessed. 
    public int[] getValue(Fraction f){
        int af = 0;
        int bf = 0;
        

        String s = f.toString();
        if(s.startsWith("-")){
            s = s.substring(2, s.length()-1);
        }else{
            s = s.substring(1, s.length()-1);
        }
        
        String array[] = s.split("/");

        af = Integer.parseInt(array[0]);
        bf = Integer.parseInt(array[1]);

        return new int[] {af,bf};
    }
    
    //The plus method does as it says, it takes, the 2 fractions we have and additive them together. 
    public Fraction plus(Fraction f){
        int af = 0;
        int bf = 0;
        //gets the values from our method. 
        int values[] = getValue(f);

        //put the values into variables.
        af = values[0];
        bf = values[1];

        //manipulate the values according to what fractions rules are applied for additive fractions. 
        int newb = b*bf;
        int newa = (newb/b)*a + (newb/bf)*af;

        return new Fraction(newa, newb);
    }
 
    //The plus method does as it says, it takes, the 2 fractions we have and substract it. 
    public Fraction minus(Fraction f){
        int af = 0;
        int bf = 0;
        //gets the values from our method.
        int values[] = getValue(f);

        //put the values into variables. 
        af = values[0];
        bf = values[1];

        //manipulate the values accordingly to what the fraction rules are for substracting fractions.
        int newb = b*bf;
        int newa = a*(newb/b) - af*(newb/bf);


        return new Fraction(newa, newb);
    }


    //The method that times to fractions together. 
    public Fraction times(Fraction f){
        int af = 0;
        int bf = 0;

        //gets the values from our method. 
        int values[] = getValue(f);

        //put the values into variables.
        af = values[0];
        bf = values[1];

        //manipulate the values accordingly to what the fraction rules are for time those fractions together. 
        int newb = b*bf;
        int newa = a*af;

        return new Fraction(newa, newb);
    }

    //The method to divide two fractions. 
    public Fraction divideBy(Fraction f){
        int af = 0;
        int bf = 0;

        //gets the values from our method.
        int values[] = getValue(f);

        //put the values into variables.
        af = values[0];
        bf = values[1];

        //manipulate the values accordingly for the rules of dividing two fractions. 
        int newb = b*af;
        int newa = a*bf;


        return new Fraction(newa, newb);
    }

    //The method reciporcal goes to switch the a and b values around.s 
    public Fraction reciprocal(){
        int newa = b;
        int newb = a;

        return new Fraction(newa, newb);
    }
    
}