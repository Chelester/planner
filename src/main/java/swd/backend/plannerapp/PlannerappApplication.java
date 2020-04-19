package swd.backend.plannerapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import swd.backend.plannerapp.domain.Plan;
import swd.backend.plannerapp.domain.PlanRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@SpringBootApplication
public class PlannerappApplication {
	private static final Logger log = LoggerFactory.getLogger(PlannerappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PlannerappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner planner(PlanRepository pRepository) {
		return (args) -> {
			log.info("save few placeholder plans");
			pRepository.save(new Plan("Kauppareissu", "Kotiaskareet", "ostoslista", "17.4."));
			pRepository.save(new Plan("Siivoa", "Kotiaskareet", "imuroi ja tiskaa", "Tällä viikolla"));
			pRepository.save(new Plan("Synttärit", "Kotiaskareet", "muista siivota ja leipoa kakku", "28.4."));
			pRepository.save(new Plan("Afterparty", "Party", "muista kalja", "29.4."));
		};
	}
}
