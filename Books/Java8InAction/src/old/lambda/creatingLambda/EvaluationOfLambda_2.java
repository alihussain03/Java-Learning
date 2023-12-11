package old.lambda.creatingLambda;

public class EvaluationOfLambda_2 {

  static void printGreetings(String greeting, GreetingInterface greetingInterface) {
    greetingInterface.sayGreeting(greeting);
  }

  public static void main(String ar[]) {

    printGreetings("Good morning", new GreetingInterface() {
      @Override
      public void sayGreeting(String greeting) {
        System.out.println(greeting + "  Ali");
      }
    });

    new EvaluationOfLambda_2().printGreetings("Good morning",
        greeting -> System.out.println(greeting + " sfd"));
  }

  interface GreetingInterface {

    void sayGreeting(String greeting);
  }
}
