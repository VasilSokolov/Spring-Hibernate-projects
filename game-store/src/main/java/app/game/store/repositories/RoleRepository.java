package app.game.store.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.game.store.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


}