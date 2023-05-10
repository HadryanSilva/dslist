package br.com.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dslist.dto.GameDTO;
import br.com.dslist.dto.GameMinDTO;
import br.com.dslist.entities.Game;
import br.com.dslist.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        try {
            Game game = gameRepository.findById(id).get();
            if (game != null) {
                return new GameDTO(game);
            }
        } catch (RuntimeException e) {
            System.out.println("Nenhum Game Encontrado!");
        }

        return null;
       
    }
    
}
