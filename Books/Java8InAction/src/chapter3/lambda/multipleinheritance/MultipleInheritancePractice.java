package chapter3.lambda.multipleinheritance;

interface Engine {

    default String getModel() {
        return "Default model";
    }
}

interface Model {

    default String getModel() {
        return "Default model";
    }
}

class Car implements Engine, Model {

    // when two classes have the same implementation, it is better to declare the function inside the class
    // compiler will take the class level function

    // return Engine.super.getModel(); // this is the second solution to use the Super
    public String getModel() {

        return "Default model";
    }

    String getModelForCar() {
        return getModel();
    }
}


public class MultipleInheritancePractice {


    public static void main(String arg[]) {
    }
}
