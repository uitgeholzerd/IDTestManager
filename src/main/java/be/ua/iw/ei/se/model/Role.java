package be.ua.iw.ei.se.model;

import java.util.List;

/**
 * Created by seb on 10/8/2015.
 */
public class Role {
    private String name;
    private List<Permission> permissions;

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
