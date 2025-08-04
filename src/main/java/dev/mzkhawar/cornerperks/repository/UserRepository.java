package dev.mzkhawar.cornerperks.repository;

import dev.mzkhawar.cornerperks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
