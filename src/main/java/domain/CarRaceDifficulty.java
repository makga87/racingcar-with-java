package domain;

public enum CarRaceDifficulty {

    EASY(1),
    NORMAL(4),
    HARD(7);

    int moveCondition;

    CarRaceDifficulty(int moveCondition) {
        this.moveCondition = moveCondition;
    }

    public boolean isMoveOk(int randomValue) {
        return this.moveCondition >= randomValue;
    }
}
