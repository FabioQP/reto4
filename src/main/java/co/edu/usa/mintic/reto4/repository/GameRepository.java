package co.edu.usa.mintic.reto4.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.mintic.reto4.model.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
