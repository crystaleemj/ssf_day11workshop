package sg.nus.iss.visa.ssf.workshop11;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop11Application {

	// create a logger object to print statements, use this for springboot projects
	private static final Logger logger = LoggerFactory.getLogger
	(Workshop11Application.class); 

	// set default port-number variable
	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		logger.info("main method started!");
		
		// initialize the spring app object 
		SpringApplication app = new SpringApplication
		(Workshop11Application.class);

		// read args array and check for "port" parameter
		// DefaultApplicationArguments is a class for SpringBoot
		// it holds all arguments in the DefaultApplicationArguments variable 
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		// create a list 'opsValues' to store getOptionValues
		// getOptionValues will return key values from terminal which are port numbers
		List<String> opsValues = appArgs.getOptionValues("port");

		String portNumber = null;

			// if port number is not in argument, execute the below code
			if(opsValues == null || opsValues.get(0) == null){

				// read port number from env variables 
				portNumber = System.getenv("PORT");

				if (portNumber == null){
					portNumber = DEFAULT_PORT;
				}
			} else {

				// passing port number from terminal 
				portNumber = opsValues.get(0);
			} 

			if (portNumber != null){
				
				// setting port number in the spring-boot config
				app.setDefaultProperties(Collections.singletonMap
				("server.port", portNumber));
			}

			logger.info("Port number is " );

		// run/launch the application
		app.run(args);
	}
}	
