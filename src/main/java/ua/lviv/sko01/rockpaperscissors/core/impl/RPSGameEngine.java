package ua.lviv.sko01.rockpaperscissors.core.impl;

import org.springframework.stereotype.Component;
import ua.lviv.sko01.rockpaperscissors.core.GameEngine;
import ua.lviv.sko01.rockpaperscissors.models.Variants;
import ua.lviv.sko01.rockpaperscissors.models.Result;

import java.util.Arrays;
import java.util.List;

import static ua.lviv.sko01.rockpaperscissors.models.Variants.*;

@Component
public class RPSGameEngine implements GameEngine{

    @Override
    public List<Variants> getChoiceList() {
        Variants[] items = values();
        return Arrays.asList((Variants[]) items);
    }

    @Override
    public Result getResult(Variants player1, Variants player2) {
        if(player1 == player2) return Result.DRAW;
        else if (player1.isBetterThen(player2)) return Result.WIN;
        else return Result.LOOSE;
    }

}
