package swd.backend.plannerapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import swd.backend.plannerapp.domain.Plan;
import swd.backend.plannerapp.domain.PlanRepository;
import swd.backend.plannerapp.domain.User;
import swd.backend.plannerapp.domain.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@SpringBootApplication
public class PlannerappApplication {
	private static final Logger log = LoggerFactory.getLogger(PlannerappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PlannerappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner planner(PlanRepository pRepository, UserRepository uRepo) {
		return (args) -> {
			log.info("save few placeholder plans");
			pRepository.save(new Plan("Kauppareissu", "Kotiaskareet", "ostoslista", "17.4."));
			pRepository.save(new Plan("Siivoa", "Kotiaskareet", "imuroi ja tiskaa", "Tällä viikolla"));
			pRepository.save(new Plan("Synttärit", "Kotiaskareet", "muista siivota ja leipoa kakku", "28.4."));
			pRepository.save(new Plan("Afterparty", "Party", "muista kalja", "29.4."));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			uRepo.save(user1);
			uRepo.save(user2);
		};
	}
}
