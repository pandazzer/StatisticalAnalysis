package team.yasp.StatisticalAnalysis.Service;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import team.yasp.StatisticalAnalysis.Json.ResponseJson;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class CounterService {

    public ResponseEntity intCounter(int[] array){

        int maxGlobal = Arrays.stream(array).max().getAsInt();
        int minGlobal = Arrays.stream(array).min().getAsInt();
        ArrayList<ResponseJson> responseJsonArrayList = new ArrayList<>();
        System.out.println(minGlobal + " " + maxGlobal);
        int max;
        int min = minGlobal;
        for (int i = 1; i <= 10; i++) {
            int step = Math.round((float)( maxGlobal - minGlobal)*i/10);
            max = minGlobal + step;

            int finalMin = min;
            int finalMax = max;
            long count = Arrays.stream(array).filter((p)-> p >= finalMin && p <= finalMax).count();
            responseJsonArrayList.add(new ResponseJson(String.valueOf(min), String.valueOf(max), String.valueOf(count)));

            System.out.println(min + " " + max + " " + count);
            min = max + 1;
        }
        Gson gson = new Gson();
        String response = gson.toJson(responseJsonArrayList);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    public ResponseEntity doubleCounter(double[] array){
        BigDecimal maxGlobal = BigDecimal.valueOf(Arrays.stream(array).max().getAsDouble()).setScale(3, RoundingMode.HALF_UP);
        BigDecimal minGlobal = BigDecimal.valueOf(Arrays.stream(array).min().getAsDouble()).setScale(3, RoundingMode.HALF_UP);
        ArrayList<ResponseJson> responseJsonArrayList = new ArrayList<>();
        System.out.println(minGlobal + " " + maxGlobal);
        BigDecimal max;
        BigDecimal min = minGlobal;
        for (int i = 1; i <= 10; i++) {
            BigDecimal step = (maxGlobal.subtract(minGlobal)).multiply(BigDecimal.valueOf(i/10.0)).setScale(3, RoundingMode.HALF_UP);
            max = minGlobal.add(step);

            double finalMin = min.doubleValue();
            double finalMax = max.doubleValue();
            long count = Arrays.stream(array).filter((p)-> p >= finalMin && p <= finalMax).count();
            responseJsonArrayList.add(new ResponseJson(String.valueOf(min), String.valueOf(max), String.valueOf(count)));

            System.out.println(min + " " + max + " " + count);
            min = max.add(BigDecimal.valueOf(0.001));
        }
        Gson gson = new Gson();
        String response = gson.toJson(responseJsonArrayList);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
