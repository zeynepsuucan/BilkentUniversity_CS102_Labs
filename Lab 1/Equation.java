public class Equation {
    int a;
    int b;
    int c;


    public int getA(){
        return this.a;
    }

    public int getB(){
        return this.b;
    }

    public int getC(){
        return this.c;
    }

    public Equation(int a, int b, int c){

        if(b < 0){
            this.a = (-1)*a;
            this.b = (-1)*b;
            this.c = (-1)*c;
        }
        
        else{
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public void reduceEquation(){
        int d = gcd3(a,b,c);
        a = a/d;
        b = b/d;
        c = c/d;
    }

    private int gcd(int x, int y){

        x = Math.abs(x);
        y = Math.abs(y);
        
        if(x>y){
            
            if(y == 0){
                return x;
            }
            else {
                return gcd(y, x%y);
            }
        }
        
        else {
            if(x == 0){
                return y;
            }
            else {
                return gcd(x, y%x);
            }
        }
    }
    
    private int gcd3(int x, int y, int z){
        z = Math.abs(z);
        int gcd2 = gcd(x, y);
        return gcd(gcd2, z);
    }

    public Equation add(Equation eq2){
        a = this.a + eq2.a;
        b = this.b + eq2.b;
        c = this.c + eq2.c; 

        Equation eqSum = new Equation(a,b,c);
        eqSum.reduceEquation();
        return eqSum;
    }

    public Equation substract(Equation eq2){
        a = this.a - eq2.a;
        b = this.b - eq2.b;
        c = this.c - eq2.c;

        Equation eqSub = new Equation(a,b,c);
        eqSub.reduceEquation();
        return eqSub;
    }

    public String toString(){
    
        String result = a + " = ";
        
        if(b!=0){
            if(b!=1){
                result += b;
            }
         result += "x";
        }

        if(c!=0){
            if(c<0 || b==0)
            result += "" + c;
            
            else 
            result += " + " + c;
        }

        return result;
 
    }

    public boolean equals(Equation eq){

        Equation reduced = new Equation(a, b, c);
        reduced.reduceEquation();
        Equation reduced1 = eq;
        reduced1.reduceEquation();

        if(reduced1.getA()==(reduced.getA()) && reduced1.getB()==(reduced.getB()) && reduced1.getC()==(reduced.getC()) )
        return true;
        
        else
        return false;

    }
}