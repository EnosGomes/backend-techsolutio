package com.enos.techsolutio.respository;

import com.enos.techsolutio.model.ERole;
import com.enos.techsolutio.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
