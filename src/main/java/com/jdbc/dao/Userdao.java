package com.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class Userdao 
{
public Userdao() {
	
}
		@Autowired
		private JdbcTemplate jdbcTemplate;

	public int createTable()
	{
		String query="CREATE TABLE IF NOT EXISTS login(email varchar(200) primary key,password varchar(200))";
		int update = this.jdbcTemplate.update(query);
		return update;

	}
	public int insertuser(String email,String password)
	{
		String query="insert into login(email,password) values(?,?)";
		int update = this.jdbcTemplate.update(query,new Object[]{email,password});
		return update;
	}
}