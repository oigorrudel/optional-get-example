package br.xksoberbado;

import java.util.List;
import java.util.Optional;

public class Good {

    public static void main(String[] args) {
        var numberOptional = getNumberOptional();

        //#1
        numberOptional.ifPresent(System.out::println);

        //#2
        var result = numberOptional
            .map(number -> number * 5)
            .orElse(5);
        System.out.println(result);

        //#3
        var result2 = numberOptional
            .map(number -> number * 5)
            .orElse(99 * 5);
        System.out.println(result2);

        //#4
        numberOptional
            .map(number -> number % 2 == 0)
            .filter(Boolean::booleanValue)
            .ifPresentOrElse(
                pair -> System.out.println("Par!"),
                () -> System.out.println("Impar!")
            );

        //#5
        final var message = numberOptional
            .map(number -> number % 2 == 0 ? "Par!" : "Impar!")
            .orElse("");
        System.out.println(message);

        final var listOfOptionals = List.of(
            Optional.of(1),
            Optional.of(2),
            Optional.empty(),
            Optional.of(3)
        );

        listOfOptionals.stream()
            .filter(Optional::isPresent)
            .map(Optional::get) //ALWAYS AFTER Optional::isPresent
            .forEach(System.out::println);

            var opNumber = getNumberOptional();

        while (opNumber.isPresent()) {
            final var number = opNumber.get();

            System.out.println(number);

            opNumber = getNumberOptional();
        }
    }

    private static Optional<Integer> getNumberOptional() {
        return Optional.of(2);
    }
}
