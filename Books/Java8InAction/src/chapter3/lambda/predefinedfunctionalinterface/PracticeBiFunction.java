package chapter3.lambda.predefinedfunctionalinterface;

import java.util.function.BiFunction;

public class PracticeBiFunction {
  public static void main(String[] args) {

    BiFunction<String, String, Integer> biFunction = (a,b) -> (a+b).length() ;

    System.out.println(biFunction.apply("Basics", "Strong"));

  }
}
