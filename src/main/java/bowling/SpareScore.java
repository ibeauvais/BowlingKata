package bowling;

public class SpareScore implements Score {
    private final Frame frame;
    private final Score nextScore;

    public SpareScore(Frame frame, Score nextScore) {
        this.frame = frame;
        if (nextScore == null) {
            nextScore = new SimpleScore(frame.thirdLaunch.getAsInt(), 0);
        }
        this.nextScore = nextScore;
    }

    @Override
    public int compute() {
        return 10 + nextScore.firstBonus();
    }

    @Override
    public int firstBonus() {
        return frame.firstLaunch;
    }

    @Override
    public int secondBonus() {
        return frame.secondLaunch;
    }
}
