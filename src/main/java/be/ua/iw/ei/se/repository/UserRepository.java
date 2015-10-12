package be.ua.iw.ei.se.repository;

import be.ua.iw.ei.se.model.Permission;
import be.ua.iw.ei.se.model.Role;
import be.ua.iw.ei.se.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seb on 10/8/2015.
 */
@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private final List<Role> roles = new ArrayList<>();

    public UserRepository() {
        super();
        Permission p1 = new Permission("logon");
        Permission p2 = new Permission("secret-message");
        Role administrator = new Role("Administrator");
        Role tester = new Role("Tester");
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(p1);
        tester.setPermissions(permissions);
        permissions = new ArrayList<Permission>();
        permissions.add(p1);
        permissions.add(p2);
        administrator.setPermissions(permissions);

        User u1 = new User("ewalsh", "1234", "Edwin", "Walsh");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(administrator);
        u1.setRoles(userRoles);
        User u2 = new User("fvds", "4321", "Filip", "Van der Schueren");
        userRoles = new ArrayList<>();
        userRoles.add(tester);
        u2.setRoles(userRoles);

        users.add(u1);
        users.add(u2);
    }

    public List<User> findAll() {
        return new ArrayList<User>(this.users);
    }
    public List<Role>  getRoles() { return new ArrayList<Role>(this.roles); }
    public void addUser(final User user) {
        this.users.add(user);
    }

    public void addRole(final Role role) {
        this.roles.add(role);
    }
}


