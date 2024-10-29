package chapter3;

import chapter2.PredicateExample;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/* Comparator example and default method call on lambda */
public class ChainLambdas {
    public static void main(String[] args) {
        chainComparators();
        chainPredicate();
        functions();
    }

    static void chainComparators() {
        System.out.println("Chaining Comparators");

        List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 35));
        /* default method call */
        people.sort(comparing(Person::getAge).reversed());
        System.out.println(people);

        /* chain multiple comparisons */
        people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 35));
        people.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        System.out.println(people);
    }

    /* negate, then, or */
    static void chainPredicate() {
        System.out.println("Chaining Predicate");

        /* default method call */
        // Predicate to check if a person is a minor (under 18)
        Predicate<Person> isMinor = person -> person.getAge() < 18;

        // Using negate() to check if a person is an adult (18 or older)
        Predicate<Person> isAdult = isMinor.negate();

        Person alice = new Person("Alice", 30);
        Person bob = new Person("Bob", 16);

        System.out.println(isMinor.test(alice));
        System.out.println(isAdult.test(bob));

        // Predicate to check if a person's name starts with 'A'
        Predicate<Person> nameStartsWithA = person -> person.getName().startsWith("A");

        // Using and() to combine predicates: is adult and name starts with 'A'
        Predicate<Person> adultAndNameStartsWithA = isAdult.and(nameStartsWithA);

        System.out.println("Is Alice an adult and has a name starting with 'A'? " + adultAndNameStartsWithA.test(alice)); // true

        // Using or() to combine predicates: is minor or name starts with 'A'
        Predicate<Person> minorOrNameStartsWithA = isMinor.or(nameStartsWithA);

        System.out.println("Is Alice a minor or has a name starting with 'A'? " + minorOrNameStartsWithA.test(alice)); // true
        System.out.println("Is Bob a minor or has a name starting with 'A'? " + minorOrNameStartsWithA.test(bob));


    }

    /* andThen, compose */
    static void functions() {
        System.out.println("Chaining Functions");
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        System.out.println(h.apply(2));

        Function<Integer, Integer> h1 = f.compose(g);
        System.out.println(h1.apply(3));

    }

}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}