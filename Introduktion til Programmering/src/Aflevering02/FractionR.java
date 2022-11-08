public class FractionR {
    //generating fields a as Numerator and b as denominator.
    int a = 0;
    int b = 0;
    

    //mostly this code is copy paste from the previous exercice. So the only thing that are different is this FractionR, where it reduce the fractions down to the 
    //lowest possible fraction. or the most simplified fraction.
    public FractionR(int a, int b){
        //generating a field that holds our divisor which contains the number a and b have to be divided by. 
        int divisor = 0;

        //here i do i loop throgh all numbers from a down to 0. 
        for(int i = a; i >= 1; i--){
            //here i check if the current state of i is diviable with both a and b, if so i put that into divisor. and that it keeps doing that and lower and lower until it finds
            //the lowest possible divisor. 
            if(a % i == 0 && b % i == 0){
                divisor = i;
                break;
            }   
        }
        //checks if it's not 0 then divide divisor with a and b. 
        if(divisor != 0){
            a/=divisor;
            b/=divisor;
        }
        //put a and b into the object's fields and done. 
        this.a = a;
        this.b = b;
    }

    //our tostring method that gets called when you try to print the object.  
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
    public int[] getValue(FractionR f){
        int af = 0;
        int bf = 0;
        
        //this part takes the object and makes it to a string, that i can manipulate.
        String s = f.toString();
        //if the string starts with "-" then i cut the 2 first charactors, and the last, so that only numbers are back.
        if(s.startsWith("-")){
            s = s.substring(2, s.length()-1);
        }else{
            s = s.substring(1, s.length()-1);
        }
        
        //when we have cut our string from the parenthesis. the we are using the slash to split the fractions and get the 2 numbers.
        String array[] = s.split("/");

        //put the 2 values from our array and put into 2 int values.
        af = Integer.parseInt(array[0]);
        bf = Integer.parseInt(array[1]);

        return new int[] {af,bf};
    }
    
    //The plus method does as it says, it takes, the 2 fractions we have and additive them together. 
    public FractionR plus(FractionR f){
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

        return new FractionR(newa, newb);
    }
 
    //The plus method does as it says, it takes, the 2 fractions we have and substract it. 
    public FractionR minus(FractionR f){
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


        return new FractionR(newa, newb);
    }


    //The method that times to fractions together. 
    public FractionR times(FractionR f){
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

        return new FractionR(newa, newb);
    }

    //The method to divide two fractions. 
    public FractionR divideBy(FractionR f){
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


        return new FractionR(newa, newb);
    }

    //The method reciporcal goes to switch the a and b values around.s 
    public FractionR reciprocal(){
        int newa = b;
        int newb = a;

        return new FractionR(newa, newb);
    }

}
