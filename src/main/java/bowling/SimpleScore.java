package bowling;

public class SimpleScore implements Score {
    private final int firstLaunch;
    private final int secondLaunch;

    public SimpleScore(int firstLaunch, int secondLaunch) {
        this.firstLaunch= firstLaunch;
        this.secondLaunch= secondLaunch;
    }

    @Override
    public int compute() {
        return firstLaunch + secondLaunch;
    }

    @Override
    public int firstBonus() {
        return firstLaunch;
    }

    @Override
    public int secondBonus() {
        return secondLaunch;
    }
}
