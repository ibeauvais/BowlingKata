package bowling;

import java.util.OptionalInt;

public class Frame {
    public final int firstLaunch, secondLaunch;
    public final OptionalInt thirdLaunch;

    private Frame(int firstLaunch, int secondLaunch, OptionalInt thirdLaunch) {
        this.firstLaunch = firstLaunch;
        this.secondLaunch = secondLaunch;
        this.thirdLaunch = thirdLaunch;
    }

    public static Frame of(int firstLaunch, int secondLaunch) {
        return new Frame(firstLaunch, secondLaunch, OptionalInt.empty());
    }

    public boolean isStrike() {
        return firstLaunch == 10;
    }

    public boolean isSpare() {
        return firstLaunch < 10 && (firstLaunch + secondLaunch) == 10;
    }

    public static Frame strike() {
        return of(10, 0);
    }

    public static Frame lastFrame(int firstLaunch, int secondLaunch, int thirdLaunch) {
        return new Frame(firstLaunch, secondLaunch, OptionalInt.of(thirdLaunch));
    }
}
