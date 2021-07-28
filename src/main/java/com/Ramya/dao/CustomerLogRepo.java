package com.Ramya.dao;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Ramya.model.CustomerLog;
public interface CustomerLogRepo extends JpaRepository<CustomerLog, String> 
{
	
	List<CustomerLog> findByDate(LocalDate date);

}
