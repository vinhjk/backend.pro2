package com.security.demospringsecurity.repository;

import com.security.demospringsecurity.model.Role;
import com.security.demospringsecurity.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
