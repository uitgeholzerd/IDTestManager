package be.ua.iw.ei.se.repository;

import be.ua.iw.ei.se.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by seb on 10/8/2015.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByLastName(String lastName);
    User findByUserName(String userName);
}



