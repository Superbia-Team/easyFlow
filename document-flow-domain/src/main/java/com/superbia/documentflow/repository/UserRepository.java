package com.superbia.documentflow.repository;

import com.superbia.documentflow.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dmorozov on 6/23/15.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>, UserRepositoryCustom {

  public User findByEmail(String email);
}
