package chapter3.lambda.predefinedfunctionalinterface;

interface FIGenerics<T, R> {

    R helloWorld(T a);
}

public class FunctionalInterfaceGenerics {

    public static void main(String[] arg) {
        FIGenerics<String, String> fiGenerics = s -> s.substring(1, 4);
        System.out.println(fiGenerics.helloWorld("Hello World"));
    }

}
