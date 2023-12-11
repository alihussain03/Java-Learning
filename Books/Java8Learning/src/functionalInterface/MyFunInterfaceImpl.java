package functionalInterface;

public class MyFunInterfaceImpl {

  public static void main(String arg[]){
    MyFunInterface myFunInterface = () -> System.out.println("Hello hello");
    myFunInterface.firstFunction();

    runBehaviourOnFly(() -> System.out.println("On fly"));
  }

  static void runBehaviourOnFly(MyFunInterface myFunInterface){
    myFunInterface.firstFunction();
  }
}
