package com.anfinogenov.jwtappdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Stepan Anfinogenov
 */

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity {

  @Column(name = "name")
  private String name;

  @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
  private List<User> users;

  @Override
  public String toString() {
    return "Role{" +
            "id: " + super.getId() + ", " +
            "name: " + name + "}";
  }
}
