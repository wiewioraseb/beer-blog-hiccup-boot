package main.java.com.beerblog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.beerblog.entity.BlogEntry;
import main.java.com.beerblog.entity.Role;
import main.java.com.beerblog.entity.User;
import main.java.com.beerblog.repository.EntryRepository;
import main.java.com.beerblog.repository.RoleRepository;
import main.java.com.beerblog.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EntryRepository entryRepository;
	
	@PostConstruct // called after the spring context creation. automatically during deployment 
	public void init(){
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setEmail("admin@mail.com");
		userAdmin.setPassword("admin"); // to simplify
		userAdmin.setRegistrationDate(new Date());
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		User userUser = new User();
		userUser.setName("user");
		userUser.setEmail("user@mail.com");
		userUser.setPassword("user");
		userUser.setRegistrationDate(new Date());
		List<Role> userRoles = new ArrayList<Role>();
		userRoles.add(roleUser);
		userUser.setRoles(userRoles);
		userRepository.save(userUser);
		
		BlogEntry entry1 = new BlogEntry();
		entry1.setTitle("First entry title");
		entry1.setPublishedDate(new Date());
		entry1.setEntryContent("First news about beer. Don't drink and drive.");
		entryRepository.save(entry1);
		
		BlogEntry entry2 = new BlogEntry();
		entry2.setTitle("Two title");
		entry2.setPublishedDate(new Date());
		entry2.setEntryContent("Second entry content. ");
		entryRepository.save(entry2);
		
	}
	
}
