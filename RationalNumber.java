public class RationalNumber extends RealNumber{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if(deno==0)
    {
      numerator=0;
      denominator=1;
    }
    else
    {
      numerator=nume;
      denominator=deno;
    }
    this.reduce();
  }

  public double getValue(){
    if(denominator==0)
    {
      return 0.0;
    }
    else
    {
      return (double) numerator/denominator;
    }
  }
  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
      return new RationalNumber(this.getDenominator(),this.getNumerator());
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return this.getValue()==other.getValue();
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if(denominator==1)
    {
      return ""+numerator;
    }
    else
    {
      return numerator+"/"+denominator;
    }
  }



  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  public static int gcd(int a, int b){
    /*use euclids method or a better one*/
    int first;
    int second;

    int absa=Math.abs(a);
    int absb=Math.abs(b);
    if(absa>absb)
    {
      first=absa;
      second=absb;
    }
    else
    {
      first=absb;
      // System.out.println("first is "+first);
      second=absa;
      // System.out.println("second is "+second);
    }
    if(a==0)
    {
      return absb;
    }
    int i=first%second;
      // System.out.println("i is "+i);
    if(i==0)
    {
      return second;
    }

    while (i>0)
    {
      // i=first%second;
      // System.out.println("i= "+i);
      first=second;
      // System.out.println("first= "+first);
      second=i;
      // System.out.println("second= "+second);
      i=first%second;
      // System.out.println("i= "+i);
    }
    return second;


     //  else
     //  {
     //    if(absb%absa==0)
     //    {
     //      return absa;
     //    }
     //    else
     //    {
     //      while (i>0)
     //      {
     //        i=intarray[1]%intarray[0];
     //        intarray[1]=intarray[0];
     //        intarray[0]=i;
     //        intarray[2]=intarray[1]%intarray[0];
     //      }
     //      return intarray[0];
     //    }
     // }
  }



  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    //if(numerator>denominator)
    //{
      int reductionfactor=gcd(numerator,denominator);
      numerator=numerator/reductionfactor;
      //System.out.println("new numerator is " +numerator);
      denominator=denominator/reductionfactor;
      //System.out.println("new denominator is " +denominator);


    //if I put debug print statements in my gcd, they will print twice whenever
    //I call this reduce method, because this reduce method calls gcd twice
  }



  /******************Operations!!!!****************/


  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber answer=new RationalNumber
      (this.getNumerator()*other.getNumerator(),
      this.getDenominator()*other.getDenominator());
      return answer;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber answer=new RationalNumber
    (
      this.getNumerator()*other.getDenominator()+
      other.getNumerator()*this.getDenominator(),

      this.getDenominator()*other.getDenominator()
    );
    return answer;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    RationalNumber answer=new RationalNumber
    (
      this.getNumerator()*other.getDenominator()-
      other.getNumerator()*this.getDenominator(),

      this.getDenominator()*other.getDenominator()
    );
    return answer;
  }
}
