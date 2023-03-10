package domain;

public enum CarRaceDifficulty {

	EASY(1, 9),
	NORMAL(4, 9),
	HARD(7, 10);

	int moveCondition;
	int randomRange;

	CarRaceDifficulty(int moveCondition, int randomRange) {
		this.moveCondition = moveCondition;
		this.randomRange = randomRange;
	}

	public int getMoveCondition() {
		return this.moveCondition;
	}

	public int getRandomRange() {
		return this.randomRange;
	}
}
