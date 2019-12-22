package com.security.demospringsecurity;

import com.security.demospringsecurity.security.service.Impl.LearningActivityServiceImpl;
import com.security.demospringsecurity.security.service.Impl.LearningOutcomeServiceImpl;
import com.security.demospringsecurity.security.service.Impl.LearningProgramServiceImpl;
import com.security.demospringsecurity.security.service.Impl.ObjectiveServiceImpl;
import com.security.demospringsecurity.security.service.LearningActivityService;
import com.security.demospringsecurity.security.service.LearningOutcomeService;
import com.security.demospringsecurity.security.service.LearningProgramService;
import com.security.demospringsecurity.security.service.ObjectiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringSecurityApplication.class, args);
	}

	@Bean
	public LearningProgramService learningProgramService(){return new LearningProgramServiceImpl();
	}

	@Bean
	public LearningActivityService learningActivityService(){return new LearningActivityServiceImpl();
	}

	@Bean
	public LearningOutcomeService learningOutcomeService(){return new LearningOutcomeServiceImpl();
	}

	@Bean
	public ObjectiveService objectiveService(){return new ObjectiveServiceImpl();
	}

}
