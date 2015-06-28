package com.superbia.documentflow.service.impl;

import com.superbia.documentflow.domain.User;
import com.superbia.documentflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by dmorozov on 6/23/15.
 */
@Service
public class DomainUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> userOpt = userRepository.findByLogin(username);

    User user = userOpt.orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));

    List<GrantedAuthority> auth = AuthorityUtils.createAuthorityList("ROLE_USER");
    if (user.isAdmin()) {
      auth = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
    }
    String password = user.getPassword();

    return new org.springframework.security.core.userdetails.User(username, password, auth);
  }
}
