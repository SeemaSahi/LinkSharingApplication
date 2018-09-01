package com.seema.LinkSharingWeb.LinkSharingWeb.repository;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

}
