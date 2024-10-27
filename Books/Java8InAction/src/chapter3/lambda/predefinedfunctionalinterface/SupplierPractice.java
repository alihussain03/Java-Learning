package chapter3.lambda.predefinedfunctionalinterface;

import java.util.function.Supplier;

public class SupplierPractice {

    public static void main(String[] arg) {
        Supplier<String> supplierForString = () -> "Hello world";
        System.out.println(supplierForString.get());

        Supplier<Double> supplierForDouble = Math::random;
        System.out.println(supplierForDouble.get());

    }


}
