package com.stackSimplify.restServices.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.stackSimplify.restServices.entities.User;

@Repository
public interface UserRepositry extends JpaRepository<User, Long>{
	
	User findByUserName(String name);
	User findBySsn(String ssn);

}
