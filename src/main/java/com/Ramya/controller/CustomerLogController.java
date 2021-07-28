package com.Ramya.controller;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ramya.dao.CustomerLogRepo;
import com.Ramya.model.CustomerLog;

@RestController
public class CustomerLogController {
	
	@Autowired
	CustomerLogRepo repo;
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/checkIn")
	public String checkIn(@RequestParam("name") String name) {
		
		CustomerLog log=new CustomerLog();
		
		LocalTime time=LocalTime.now();
		LocalDate date=LocalDate.now();
		
		log.setLogType("IN");
		log.setDate(date);
		log.setTime(time);
		log.setId(name+time);
		repo.save(log);
		return "added: "+name+"checkIn log";
	} 
	
	@GetMapping("/checkOut")
	public String checkOut(@RequestParam("name") String name) {
		CustomerLog log=new CustomerLog();
		LocalTime time=LocalTime.now();
		LocalDate date=LocalDate.now();
		
		log.setLogType("OUT");
		log.setDate(date);
		log.setTime(time);
		log.setId(name+time);
		repo.save(log);
		return "added: "+name+"checkOut log";
	} 
	
	@GetMapping("/getLog")
	public List<CustomerLog> getLogByDate(@RequestParam("date") String date){
		
		LocalDate localDate = LocalDate.parse(date);
		return repo.findByDate(localDate);
		
	}
	@GetMapping("/getAllLogs")
	public List<CustomerLog> getAllLogs(){
		return repo.findAll();
	}
}
