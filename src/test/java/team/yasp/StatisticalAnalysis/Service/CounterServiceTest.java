package team.yasp.StatisticalAnalysis.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CounterServiceTest {
    CounterService counterService;
    int[] intArray;
    double[] doubleArray;

    @BeforeEach
    void setUp() {
        counterService = new CounterService();
        intArray = new int[13];
        for (int i = 0; i < 13; i++) {
            intArray[i] = i;
        }
        doubleArray = new double[13];
        for (int i = 0; i < 13; i++) {
            doubleArray[i] = i*0.001;
        }
    }

    @Test
    void intCounter() {
        assertThat(counterService.intCounter(intArray)).isNotNull();
    }

    @Test
    void doubleCounter() {
       assertThat(counterService.doubleCounter(doubleArray)).isNotNull();
    }
}