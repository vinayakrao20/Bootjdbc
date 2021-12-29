package com.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdbc.dao.Userdao;

@SpringBootApplication
public class BootjdbcApplication implements CommandLineRunner
{

	@Autowired
	private Userdao userdao;
	public static void main(String[] args) {
		SpringApplication.run(BootjdbcApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception 
	{
	System.out.println(this.userdao.createTable());
	this.createuser();
		
	}
	public void createuser() throws IOException
	{
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   System.out.println("Enter email");
	   String email=br.readLine();
	   System.out.println("Enter Password");
	   String password=br.readLine();
	   int i = this.userdao.insertuser(email, password);
	   System.out.println(i+"  user added");
	}

	
}
