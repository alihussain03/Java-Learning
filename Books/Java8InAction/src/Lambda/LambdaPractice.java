package Lambda;


import functionalInterface.LengthOfString;
import functionalInterface.MathOperation;
import functionalInterface.Name;

public class LambdaPractice {

    public static void main(String arg[]) {

        /**
         * Lambda without any parameter
         * there is no need to add parenthesis if statement only one line statement
         */
        Name name = () -> System.out.println("My Name");

        /**
         * Lambda with parameters
         */
        MathOperation mathOperation = (a, b) -> System.out.println(a + b);
        mathOperation.operation(89, 100);

        /**
         * Lambda with parameters and return type
         */
        LengthOfString lengthOfString = s -> s.length();
        lengthOfString.length("ali");

        /**
         * Lambda with multiline
         */
        LengthOfString lengthOfString1 = s -> {
            int l = s.length();
            System.out.println("The length of the given String is " + l);
            return s.length();
        };
        lengthOfString1.length("ali");

    }
}
