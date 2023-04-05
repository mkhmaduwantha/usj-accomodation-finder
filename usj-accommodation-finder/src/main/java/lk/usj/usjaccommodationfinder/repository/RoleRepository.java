package lk.usj.usjaccommodationfinder.repository;

import lk.usj.usjaccommodationfinder.model.Role;
import lk.usj.usjaccommodationfinder.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByRoleName(RoleName roleName);
}
