package team.yasp.StatisticalAnalysis.Service;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import team.yasp.StatisticalAnalysis.TopHits;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
public class Service {

    List<TopHits> topHits;
    @Autowired
    CounterService counterService;

    public Service() throws FileNotFoundException {
        topHits = loadCSV();
    }

    private List<TopHits> loadCSV() throws FileNotFoundException {   // метод загружет данные и парсит в лист
        List<TopHits> topHits = new CsvToBeanBuilder(new FileReader("src/main/resources/songs_normalize.csv"))
                .withType(TopHits.class)
                .build().parse();
        return topHits;
    }

    public ResponseEntity getDuration_ms(String year){      //методы обрабатывают
        int[] duration_msArray;
        if (year == null){
            duration_msArray = topHits.stream()
                    .skip(1)
                    .mapToInt((p)->Integer.parseInt(p.getDuration_ms())).toArray();
        }else {
            duration_msArray = topHits.stream()
                    .skip(1)
                    .filter((p)->p.getYear().equals(year))
                    .mapToInt((p)->Integer.parseInt(p.getDuration_ms())).toArray();
        }
        return counterService.intCounter(duration_msArray);
    }

    public ResponseEntity getYear(String year) {
        int[] yearArray;
        if (year == null){
            yearArray = topHits.stream()
                    .skip(1)
                    .mapToInt((p)->Integer.parseInt(p.getYear())).toArray();
        }else {
            yearArray = topHits.stream()
                    .skip(1)
                    .filter((p)->p.getYear().equals(year))
                    .mapToInt((p)->Integer.parseInt(p.getYear())).toArray();
        }
        return counterService.intCounter(yearArray);
    }

    public ResponseEntity getPopularity(String year) {
        int[] popularityArray;
        if (year == null){
            popularityArray = topHits.stream()
                    .skip(1)
                    .mapToInt((p)->Integer.parseInt(p.getPopularity())).toArray();
        }else {
            popularityArray = topHits.stream()
                    .skip(1)
                    .filter((p)->p.getYear().equals(year))
                    .mapToInt((p)->Integer.parseInt(p.getPopularity())).toArray();
        }
        return counterService.intCounter(popularityArray);
    }

    public ResponseEntity getKey(String year) {
        int[] keyArray;
        if (year == null){
            keyArray = topHits.stream()
                    .skip(1)
                    .mapToInt((p)->Integer.parseInt(p.getKey())).toArray();
        }else {
            keyArray = topHits.stream()
                    .skip(1)
                    .filter((p)->p.getYear().equals(year))
                    .mapToInt((p)->Integer.parseInt(p.getKey())).toArray();
        }
        return counterService.intCounter(keyArray);
    }

    public ResponseEntity getDanceability(String year) {
        double[] danceabilityArray;
        if (year == null){
            danceabilityArray = topHits.stream()
                    .skip(1)
                    .mapToDouble((p)->Double.parseDouble(p.getDanceability())).toArray();
        }else {
            danceabilityArray = topHits.stream()
                    .skip(1)
                    .filter((p)->p.getYear().equals(year))
                    .mapToDouble((p)->Double.parseDouble(p.getDanceability())).toArray();
        }
        return counterService.doubleCounter(danceabilityArray);
    }

    public ResponseEntity getEnergy(String year) {
        double[] energyArray;
        if (year == null){
            energyArray = topHits.stream()
                    .skip(1)
                    .mapToDouble((p)->Double.parseDouble(p.getEnergy())).toArray();
        }else {
            energyArray = topHits.stream()
                    .skip(1)
                    .filter((p)->p.getYear().equals(year))
                    .mapToDouble((p)->Double.parseDouble(p.getEnergy())).toArray();
        }
        return counterService.doubleCounter(energyArray);
    }
}
