package ua.lviv.sko01.rockpaperscissors.models;

import java.util.List;

public interface Player {
    Variants makeChoice(List<Variants> moveOptions);
    String getName();
    void setName(String name);
}
