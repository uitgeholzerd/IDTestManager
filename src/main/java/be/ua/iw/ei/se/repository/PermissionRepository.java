package be.ua.iw.ei.se.repository;

import be.ua.iw.ei.se.model.Permission;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by seb on 10/22/2015.
 */
public interface PermissionRepository extends CrudRepository<Permission, Long> {
    List<Permission> findByName(String name);

}
