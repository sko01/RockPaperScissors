package ua.lviv.sko01.rockpaperscissors.models.impl;

import ua.lviv.sko01.rockpaperscissors.models.Player;
import ua.lviv.sko01.rockpaperscissors.models.Variants;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class ComputerPlayer implements Player {

    private String name = "Computer";

    @Override
    public Variants makeChoice(List<Variants> options) {
        int random = ThreadLocalRandom.current().nextInt(options.size());
        return options.get(random);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
