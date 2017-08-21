package ua.lviv.sko01.rockpaperscissors.models;


public enum Variants{
    ROCK {
        @Override
        public boolean isBetterThen(Variants variants) {
            return (SCISSORS == variants);
        }
    },

    PAPER {
        @Override
        public boolean isBetterThen(Variants variants) {
            return (ROCK == variants);
        }
    },

    SCISSORS {
        @Override
        public boolean isBetterThen(Variants variants) {
            return (PAPER == variants);
        }
    };

    public abstract boolean isBetterThen(Variants variants);
}
