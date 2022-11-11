package eus.hekuntza.zubiri.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
  
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String username;
  private String password;
  
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  private List<Authority> authorities;
  
  public User(String username, String password) {
    super();
    this.username = username;
    this.password = password;
    this.authorities = new ArrayList<Authority>();
  }
  
  public User() {
    
  }
  
  
}
