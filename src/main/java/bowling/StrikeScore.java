package bowling;

public class StrikeScore implements Score {

    private final Score nextScore;

    public StrikeScore(Frame frame, Score nextScore) {
        if (nextScore == null) {
            nextScore = new SimpleScore(frame.secondLaunch, frame.thirdLaunch.getAsInt());
        }
        this.nextScore = nextScore;
    }

    @Override
    public int compute() {
        return 10 + nextScore.firstBonus() + nextScore.secondBonus();
    }

    @Override
    public int firstBonus() {
        return 10;
    }

    @Override
    public int secondBonus() {
        return nextScore.firstBonus();
    }
}
