package ua.lviv.sko01.rockpaperscissors.models.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.lviv.sko01.rockpaperscissors.models.Player;
import ua.lviv.sko01.rockpaperscissors.models.Variants;
import ua.lviv.sko01.rockpaperscissors.utils.ConsoleUtils;

import java.util.List;

public class HumanPlayer implements Player {
    private static final Logger LOG = LoggerFactory.getLogger(HumanPlayer.class);

    private String name;

    @Override
    public Variants makeChoice(List<Variants> variantsList) {
        LOG.info("******** Available moves *******");
        int count = 1;
        for (Variants variant: variantsList) {
            LOG.info("For {} enter {}", variant, count);
            count++;
        }
        int selected = ConsoleUtils.getSelectedVariantInput(System.in, variantsList.size());
        return variantsList.get(selected - 1);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
