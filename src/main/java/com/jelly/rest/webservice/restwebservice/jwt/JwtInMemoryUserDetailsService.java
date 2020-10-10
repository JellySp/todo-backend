package com.jelly.rest.webservice.restwebservice.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "Jelly",
        "$2a$10$7wyImjwwaZhmfyMh8Uw.feMXDtPfFVP/VIoTrNDJRwMUpywpIw/rW", "ROLE_USER_2"));

    inMemoryUserList.add(new JwtUserDetails(1L, "Alex",
            "$2a$10$OTK9wx5TLkyFN7RmV54n0.X/uxJMMm6ohf4qyb6jUx.zG7ZDEunEu", "ROLE_USER_2"));

    inMemoryUserList.add(new JwtUserDetails(1L, "Eric",
            "$2a$10$NPTpjdAIGXIoX.lHdQ8B.uOo/6E8WyIK4m0xfRMIR5CXqjVIRDiy2", "ROLE_USER_2"));

    inMemoryUserList.add(new JwtUserDetails(1L, "Preche",
            "$2a$10$p5cko33m5xqiPUKgXyhhUO8dv/n20fTfa18K1qOVeTWiIVC3jE22S", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


