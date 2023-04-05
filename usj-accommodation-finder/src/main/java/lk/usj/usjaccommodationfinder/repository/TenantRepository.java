package lk.usj.usjaccommodationfinder.repository;

import lk.usj.usjaccommodationfinder.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Optional<Tenant> findTenantByUserId(String userId);
    Boolean existsTenantByUserId(String userId);
}
