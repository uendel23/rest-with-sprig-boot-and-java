package br.com.del.rest_with_sprig_boot_and_java.controller;

import br.com.del.rest_with_sprig_boot_and_java.converters.NumberConverter;
import br.com.del.rest_with_sprig_boot_and_java.exceptions.UnsupportedMathOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.del.rest_with_sprig_boot_and_java.math.SimpleMath;

import java.util.concurrent.atomic.AtomicLong;

//import static br.com.del.rest_with_sprig_boot_and_java.converters.NumberConverter.isNumeric;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private SimpleMath simpleMath;
    @Autowired
    private NumberConverter numberConverter;


    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

    }


    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {


        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return simpleMath.subtract(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

    }


    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return simpleMath.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping()
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return simpleMath.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }


    @GetMapping()
    @RequestMapping(value = "/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return simpleMath.average(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }


    @GetMapping()
    @RequestMapping(value = "/squareRoot/{number}")
    public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {

        if (!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return simpleMath.squareRoot(NumberConverter.convertToDouble(number));

    }


}
