package old.lambda.predefinedfunctionalinterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorPratice {

  public static void main(String arg[]) {
    BinaryOperator<String> tBinaryOperator = (t, t2) -> t + t2;
    System.out.println(tBinaryOperator.apply("hello  ", "world!!1"));
  }

}
