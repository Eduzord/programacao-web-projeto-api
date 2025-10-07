package com.senac.projeto2.repository;

import com.senac.projeto2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository {
    Optional<Role> findByRoleName(String roleName);
}
