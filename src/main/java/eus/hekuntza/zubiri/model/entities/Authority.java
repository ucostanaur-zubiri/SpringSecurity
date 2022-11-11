package eus.hekuntza.zubiri.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;


@Entity
public class Authority {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private Long id;
  
  private String name;
  
  public Authority(String name) {
    this.name = name;
  }

  public Authority() {
  }
 
  public String getName() {
    return name;
  }
  
  @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  private User user;

}
