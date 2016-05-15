package main.java.com.beerblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beerblog.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
