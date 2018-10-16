public class RationalNumber extends RealNumber{
  //super();

  private double rationalnumber;


  public RationalNumber(){
    rationalnumber= 0.0;
  }

  public RationalNumber(int numerator,int denominator){
    rationalnumber= numerator/denominator;
  }

  public double getrationalnumber(){
    return rationalnumber;
  }

}
