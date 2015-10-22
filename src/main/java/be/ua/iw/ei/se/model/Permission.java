package be.ua.iw.ei.se.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

/**
 * Created by seb on 10/8/2015.
 */
@Entity
public class Permission extends AbstractPersistable<Long> {
    private String name;

    public Permission() {}
    public Permission(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
