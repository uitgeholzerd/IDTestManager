package be.ua.iw.ei.se.service;

import be.ua.iw.ei.se.model.Permission;
import be.ua.iw.ei.se.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by seb on 10/22/2015.
 */
@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;
    public Iterable<Permission> findAll() {
        return this.permissionRepository.findAll();
    }

}
