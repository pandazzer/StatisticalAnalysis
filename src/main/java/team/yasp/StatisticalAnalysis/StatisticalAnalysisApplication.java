package team.yasp.StatisticalAnalysis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatisticalAnalysisApplication {
static Logger log =  LogManager.getLogger();
	public static void main(String[] args) {
		log.info("start");
		SpringApplication.run(StatisticalAnalysisApplication.class, args);
	}

}
