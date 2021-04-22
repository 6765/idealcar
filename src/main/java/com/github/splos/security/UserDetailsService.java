package com.github.splos.security;

import com.github.splos.user.User;
import com.github.splos.user.UserRepository;
import java.util.ArrayList;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements
    org.springframework.security.core.userdetails.UserDetailsService {

  private final UserRepository userRepository;

  public UserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email).orElse(null);
    if (user == null) {
      throw new UsernameNotFoundException("Email does not exists");
    }

    return new org.springframework.security.core.userdetails.User(email, user.getPassword(),
        new ArrayList<>());
  }
}
