package br.com.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dslist.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    
}
