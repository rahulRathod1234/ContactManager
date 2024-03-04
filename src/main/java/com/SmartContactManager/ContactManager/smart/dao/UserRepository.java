package com.SmartContactManager.ContactManager.smart.dao;

import com.SmartContactManager.ContactManager.Entities.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User,Integer>
{


}
