package team.yasp.StatisticalAnalysis;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping(path = "/")
    public ResponseEntity analysis(@RequestParam("colname") String colName, @RequestParam(value = "year", required = false) String year){
        System.out.println(colName);
        System.out.println(year);
        return null;
    }
}
