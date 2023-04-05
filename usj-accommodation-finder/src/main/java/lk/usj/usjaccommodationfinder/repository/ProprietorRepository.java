package lk.usj.usjaccommodationfinder.repository;

import lk.usj.usjaccommodationfinder.model.Proprietor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProprietorRepository extends JpaRepository<Proprietor, Long> {
    Optional<Proprietor> findProprietorByUserId(String userId);
    Boolean existsProprietorByUserId(String userId);
}
