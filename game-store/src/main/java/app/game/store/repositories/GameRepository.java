package app.game.store.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.game.store.model.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {


}