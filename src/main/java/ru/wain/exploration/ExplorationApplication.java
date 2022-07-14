package ru.wain.exploration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // exclude - отключение автоконфигурации подключения к БД. Иначе ошибка
public class ExplorationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExplorationApplication.class, args);
	}

}
