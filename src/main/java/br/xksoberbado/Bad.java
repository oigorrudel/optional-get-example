package br.xksoberbado;

import java.util.Optional;

public class Bad {
    public static void main(String[] args) {
        var numberOptional = getNumberOptional();

        //#1
        if (numberOptional.isPresent()) {
            final var number = numberOptional.get();
            System.out.println(number);
        }

        //#2
        var result = 5;
        if (numberOptional.isPresent()) { //fazer calculo caso exista valor
            final var number = numberOptional.get();
            result = number * result;
        }
        System.out.println(result);

        //#3
        var result2 = 5;
        if (numberOptional.isPresent()) { //fazer calculo caso exista valor
            final var number = numberOptional.get();
            result2 = number * result2;
        } else { //fazer outro calculo caso não exista
            result2 = 99 * result2;
        }
        System.out.println(result2);

        //#4
        if (numberOptional.isPresent()) {
            final var number = numberOptional.get();

            if (number % 2 == 0) { //aplicar uma condição caso exista valor
                System.out.println("Par!"); //fazer algo se SIM
            } else {
                System.out.println("Impar!"); //fazer algo se NÃO
            }
        }

        //#5
        var message = "";
        if (numberOptional.isPresent()) {
            final var number = numberOptional.get();

            //(retornando/alterando valor)
            if (number % 2 == 0) { //aplicar uma condição caso exista valor
                message = "Par!"; //fazer algo se SIM
            } else {
                message = "Impar!"; //fazer algo se NÃO
            }
        }
        System.out.println(message);
    }

    private static Optional<Integer> getNumberOptional() {
        return Optional.of(2);
    }
}