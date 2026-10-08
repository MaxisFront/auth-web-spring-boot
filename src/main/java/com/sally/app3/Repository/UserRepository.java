package com.sally.app3.Repository;

import com.sally.app3.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data genera un método para buscar mediante el username
    User findByNombre(String nombre);
}
