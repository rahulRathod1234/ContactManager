package com.SmartContactManager.ContactManager.smartConfiguration;

import com.SmartContactManager.ContactManager.Entities.User;
import com.SmartContactManager.ContactManager.smart.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService
{

        @Autowired
        private UserRepository userRepository;
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         User user = userRepository.getUserByUserName(username);
         if(user == null)
        {
          throw new UsernameNotFoundException("could not found user!!");
        }

      CustomUserDetails customUserDetails = new CustomUserDetails(User);
        return customUserDetails;
    }
}