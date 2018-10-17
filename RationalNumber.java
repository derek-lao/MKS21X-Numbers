public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    numerator=nume;
    denominator=deno;
    this.reduce();
  }

  public RationalNumber(){
    numerator=0;
    denominator=1;
  }

  public double getValue(){
    return numerator/denominator;
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
    if(this.getDenominator()==0)
    {
      RationalNumber answer=
        new RationalNumber(0,1);
      return answer;
    }
    else
    {
      return new RationalNumber(this.getDenominator(),this.getNumerator());
    }
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
    return "0";
  }



  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    int i=1;
    while (i>0)
    {
      i=a%b;
      a=b;
      b=i;
    }
    return b;
  }



  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    if(numerator>denominator)
    {
      numerator=numerator/gcd(numerator,denominator);
      denominator=denominator/gcd(numerator,denominator);
    }
    else
    {
      numerator=numerator/gcd(denominator,numerator);
      denominator=denominator/gcd(denominator,numerator);
    }
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
