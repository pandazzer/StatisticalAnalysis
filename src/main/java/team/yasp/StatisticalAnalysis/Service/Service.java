package team.yasp.StatisticalAnalysis.Service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;
import team.yasp.StatisticalAnalysis.TopHits;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class Service {

    public Service() throws FileNotFoundException {
        loadCSV();
    }

    private void loadCSV() throws FileNotFoundException {
        List reader = new CsvToBeanBuilder(new FileReader("songs_normalize.csv"))
                .withType(TopHits.class)
                .build().parse();
    }

    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();

        return data;
    }
}
