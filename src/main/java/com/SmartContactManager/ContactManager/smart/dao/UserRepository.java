package com.SmartContactManager.ContactManager.smart.dao;

import com.SmartContactManager.ContactManager.Entities.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends JpaRepository<User,Integer>
{

    @Query("select u from user u where u.email=:email")
    public  User getUserByUserName(@Param("email") String email);
}
