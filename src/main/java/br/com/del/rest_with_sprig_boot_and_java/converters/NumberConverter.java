package br.com.del.rest_with_sprig_boot_and_java.converters;


import org.springframework.stereotype.Component;

@Component
public class NumberConverter {

    public static boolean isNumeric(String strnumber) {
        if (strnumber == null) return false;

        String number = strnumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }


    public static Double convertToDouble(String stringnumberOne) {
        if (stringnumberOne == null) return 0D;

        //converter a virgula em ponto padrão americano
        String number = stringnumberOne.replaceAll(",", ".");

        if (isNumeric(number)) return Double.parseDouble(number);

        return 0D;
    }
}
