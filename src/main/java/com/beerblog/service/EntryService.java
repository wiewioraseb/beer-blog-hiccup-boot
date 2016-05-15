package main.java.com.beerblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import main.java.com.beerblog.entity.BlogEntry;
import main.java.com.beerblog.repository.EntryRepository;

@Service
public class EntryService {

	@Autowired
	private EntryRepository entryRepository;
	
	public List<BlogEntry> findAll(){
		return entryRepository.findAll();
	}

	public BlogEntry findOne(int id) {
		return entryRepository.findOne(id);
	}
	
	public void save(BlogEntry entry) {
		entryRepository.save(entry);
	}
	
	public List<BlogEntry> findAllReversed(){
		return entryRepository.findAll(new Sort(Sort.Direction.DESC, "Id"));
	}
	
	public void delete(int id){
		entryRepository.delete(id);
	}

}