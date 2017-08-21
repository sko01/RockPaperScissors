package ua.lviv.sko01.rockpaperscissors.core;

import ua.lviv.sko01.rockpaperscissors.models.Result;
import ua.lviv.sko01.rockpaperscissors.models.Variants;

import java.util.List;

public interface GameEngine {
    List<Variants> getChoiceList();
    Result getResult(Variants player1, Variants player2);
}
