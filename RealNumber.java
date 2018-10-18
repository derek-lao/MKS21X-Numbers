public class RealNumber{
  private double value;

  public RealNumber(double v){
    value = v;
  }

  /*
  *Return the sum of this and the other
  */
  public double add(RealNumber other){
    double answer= this.getValue()+other.getValue();
    return answer;
  }
  /*
  *Return the product of this and the other
  */
  public double multiply(RealNumber other){
    double answer= this.getValue()*other.getValue();
    return answer;
  }
  /*
  *Return the this divided by the other
  */
  public double divide(RealNumber other){
    double answer=this.getValue()/other.getValue();
    return answer;
  }
  /*
  *Return the this minus the other
  */
  public double subtract(RealNumber other){
    double answer=this.getValue()-other.getValue();
    return answer;
  }


  public double getValue(){
    return value;
  }

  public String toString(){
    return ""+value;
  }
}
