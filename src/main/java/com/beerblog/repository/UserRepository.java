package main.java.com.beerblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.beerblog.entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {

}
