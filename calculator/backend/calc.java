package com.example.calculator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cal")
public class calc  {

    private parsing parse;

    @Autowired
    public calc(parsing parse) {
        this.parse = parse;
    }

    @GetMapping(value = "/ev")
    public String caclulationexp(@RequestParam String exp) {
        String nexp = exp.replaceAll(" ", "+");
        if (nexp.contains("/0") && !nexp.contains("/0.")) {
            return "E";
        }
        try{
            double x = parse.evaluate(nexp);
            if (Double.toString(x) == "nan") {
                return "E";
            }
            return Double.toString(x);
        }
        catch(Exception e){
            return "Error";
}

}

}
