package ua.lviv.sko01.rockpaperscissors.models;


public enum Variants{
    ROCK {
        @Override
        public boolean isBetterThan(Variants variants) {
            return (SCISSORS == variants);
        }
    },

    PAPER {
        @Override
        public boolean isBetterThan(Variants variants) {
            return (ROCK == variants);
        }
    },

    SCISSORS {
        @Override
        public boolean isBetterThan(Variants variants) {
            return (PAPER == variants);
        }
    };

    public abstract boolean isBetterThan(Variants variants);
}
