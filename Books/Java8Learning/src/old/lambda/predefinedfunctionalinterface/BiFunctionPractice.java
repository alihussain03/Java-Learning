package old.lambda.predefinedfunctionalinterface;

import java.util.function.BiFunction;

public class BiFunctionPractice {

  public static void main(String arg[]) {
    BiFunction<String, String, String> biFunction = (s, s2) -> s + s2;

    System.out.println(biFunction.apply("Hello ", "World"));
  }
}
