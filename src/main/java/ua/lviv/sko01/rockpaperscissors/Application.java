package ua.lviv.sko01.rockpaperscissors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.lviv.sko01.rockpaperscissors.services.GameService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application{

    @Autowired
    GameService gameService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @PostConstruct
    public void startGame() {
        gameService.playGame();
    }
}
