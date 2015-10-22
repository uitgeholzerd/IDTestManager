package be.ua.iw.ei.se.service;

import be.ua.iw.ei.se.model.Permission;
import be.ua.iw.ei.se.model.Role;
import be.ua.iw.ei.se.model.User;
import be.ua.iw.ei.se.repository.PermissionRepository;
import be.ua.iw.ei.se.repository.RoleRepository;
import be.ua.iw.ei.se.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by seb on 10/22/2015.
 */
@Service
@Profile("default")
public class DatabaseLoader {

    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(PermissionRepository permissionRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void initDatabase() {
        Permission p1 = new Permission("logon");
        permissionRepository.save(p1);
        Permission p2 = new Permission("secret-message");
        permissionRepository.save(p2);
        Role administrator = new Role("Administrator");
        Role tester = new Role("Tester");
        List<Permission> permissions =  new ArrayList<Permission>();
        permissions.add(p1);
        tester.setPermissions(permissions);
        roleRepository.save(tester);
        permissions =  new ArrayList<Permission>();
        permissions.add(p1);
        permissions.add(p2);
        administrator.setPermissions(permissions);
        roleRepository.save(administrator);
        User u1 = new User("ewalsh", "1234", "Edwin","Walsh");
        List<Role> roles = new ArrayList<>();
        roles.add(administrator);
        u1.setRoles(roles);
        userRepository.save(u1);
        User u2 = new User("fvds","4321","Filip","Van der Schueren");
        roles = new ArrayList<>();
        roles.add(tester);
        u2.setRoles(roles);
        userRepository.save(u2);

    }
}

