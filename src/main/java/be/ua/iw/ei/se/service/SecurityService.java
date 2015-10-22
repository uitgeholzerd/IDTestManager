package be.ua.iw.ei.se.service;

import be.ua.iw.ei.se.model.Permission;
import be.ua.iw.ei.se.model.Role;
import be.ua.iw.ei.se.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by seb on 10/22/2015.
 */
@Service
public class SecurityService implements UserDetailsService {
    @Autowired

    UserService userService;
    @Autowired
    PermissionService permissionService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails ud = null;
        for (User user : userService.findAll()){
            if (userName.equals(user.getUserName())){
                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                for (Role role : user.getRoles()) {
                    for (Permission perm : role.getPermissions()){
                        authorities.add(new SimpleGrantedAuthority(perm.getName()));
                    }
                }

                ud = new org.springframework.security.core.userdetails.User(userName, user.getPassword(), true, true, true, true,authorities);
            }
        }
        if (ud == null) throw new UsernameNotFoundException("No user with username '" + userName + "' found!");
        return ud;

    }
}

