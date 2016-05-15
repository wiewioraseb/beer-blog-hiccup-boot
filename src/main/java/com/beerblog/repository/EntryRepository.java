package main.java.com.beerblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.beerblog.entity.BlogEntry;



public interface EntryRepository extends JpaRepository<BlogEntry, Integer> {

	
	
}
