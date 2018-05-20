package App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import App.controller.TaskController;

@SpringBootApplication
public class ToDoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}

}
