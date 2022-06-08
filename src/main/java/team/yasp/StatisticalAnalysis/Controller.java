package team.yasp.StatisticalAnalysis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.yasp.StatisticalAnalysis.Service.Service;

@RestController
@RequestMapping
public class Controller {

    Service service = new AnnotationConfigApplicationContext(Config.class).getBean(Service.class);

    @GetMapping(path = "/")
    public ResponseEntity analysis(@RequestParam("colname") String colName, @RequestParam(value = "year", required = false) String year){
        switch (colName){
            case "duration_ms":
                return service.getDuration_ms(year);
            case "year":
                return service.getYear(year);
            case "popularity":
                return service.getPopularity(year);
            case "danceability":
                return service.getDanceability(year);
            case "energy":
                return service.getEnergy(year);
            case "key":
                return service.getKey(year);
        }
        return null;
    }
}
