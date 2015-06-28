package com.superbia.documentflow.repository;

import com.superbia.documentflow.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by dmorozov on 6/23/15.
 */
public interface UserRepositoryCustom {

  public Optional<User> findByLogin(String login);

  public List<User> findActive();

}
