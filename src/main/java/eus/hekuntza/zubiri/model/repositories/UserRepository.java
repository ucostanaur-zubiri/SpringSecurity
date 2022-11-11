package eus.hekuntza.zubiri.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.hekuntza.zubiri.model.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findUserByUsername(String u);
}