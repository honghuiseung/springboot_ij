package com.example.Project06;

import com.example.Project06.repository.BoardCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Member;

@SpringBootApplication
public class Project06Application {

	public static void main(String[] args) {

		SpringApplication.run(Project06Application.class, args)
				.getBean(Project06Application.class).execute();
	}
	@Autowired
	BoardCrudRepository repository; //1)

	private void execute(){
		//등록
		//executeInsert();
		//모든 데이터 취득
		//executeSelect();
	}




}
