package chapter11;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Optional.empty;
import static java.util.Optional.of;

import static java.util.Collections.max;
import static java.util.stream.Collectors.toSet;

public class OptionalMain {

    public static void main(String[] args) {
        Insurance insurance = new Insurance("Insurance");
        Car car = new Car(Optional.of(insurance));
        Person person = new Person(Optional.of(car), 30);

        System.out.println("---------------------------");
        System.out.println("Use of Optional using Flat map");
        System.out.println(getCarInsuranceName(Optional.of(person)));

        System.out.println("---------------------------");
        System.out.println("Use of Optional using Streams");
        System.out.println(getCarInsuranceNames(List.of(new Person(Optional.of(car), 28),
                new Person(Optional.of(car), 29))));

        System.out.println("---------------------------");
        System.out.println("Use of isPresent");
        nullSafeFindCheapestInsurance(Optional.of(person), Optional.of(car)).ifPresentOrElse(insurance1 ->
                System.out.println(insurance1.getName()), () -> System.out.println("No element"));

        System.out.println("---------------------------");
        System.out.println("Use of filter");
        System.out.println(getCarInsuranceName(Optional.of(person), 28));

        System.out.println("---------------------------");
        System.out.println("Use of OperationsWithOptional");
        System.out.println(getCarInsuranceName(Optional.of(person), 28));
    }

    static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    static Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optInsurance -> optInsurance.map(Insurance::getName))
                .flatMap(Optional::stream)
                .collect(toSet());
    }

    static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
    }

    static Insurance findCheapestInsurance(Person person, Car car) {
        // queries services provided by the different insurance companies
        // compare all those data
        Insurance cheapestCompany = new Insurance("New insurance");
        return cheapestCompany;
    }

    static Optional<Insurance> nullSafeFindCheapestInsuranceQuiz(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    static String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
