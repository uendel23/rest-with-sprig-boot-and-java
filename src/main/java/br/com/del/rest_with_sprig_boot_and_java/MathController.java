package br.com.del.rest_with_sprig_boot_and_java;

import br.com.del.rest_with_sprig_boot_and_java.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }


    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {


        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);

    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @GetMapping()
    @RequestMapping( value = "/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo){

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }




    private boolean isNumeric(String strnumber) {
        if (strnumber == null) return false;

        String number = strnumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }


    private Double convertToDouble(String stringnumberOne) {
        if (stringnumberOne == null) return 0D;

        //converter a virgula em ponto padrão americano
        String number = stringnumberOne.replaceAll(",", ",");

        if (isNumeric(number)) return Double.parseDouble(number);

        return 0D;
    }


}
