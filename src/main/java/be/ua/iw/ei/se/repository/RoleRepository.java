package be.ua.iw.ei.se.repository;

import be.ua.iw.ei.se.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by seb on 10/22/2015.
 */
public interface RoleRepository extends CrudRepository<Role, Long>{
    List<Role> findByName(String name);
}
