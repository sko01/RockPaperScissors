package ua.lviv.sko01.rockpaperscissors.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.sko01.rockpaperscissors.constants.Constants;
import ua.lviv.sko01.rockpaperscissors.core.GameBuilder;
import ua.lviv.sko01.rockpaperscissors.models.Game;
import ua.lviv.sko01.rockpaperscissors.services.GameService;
import ua.lviv.sko01.rockpaperscissors.utils.ConsoleUtils;

@Service
public class GameServiceImpl implements GameService {
    private static final Logger LOG = LoggerFactory.getLogger(GameServiceImpl.class);

    @Autowired
    GameBuilder gameBuilder;

    @Override
    public void playGame() {
        boolean newGame = true;
        LOG.info("************** Welcome ****************");
        while(newGame) {
            Game game = gameBuilder.buildGame();
            game.playGame();
            newGame = ConsoleUtils.isContinueGame(System.in, Constants.CREATE_NEW_GAME_MSG);
        }
    }
}
