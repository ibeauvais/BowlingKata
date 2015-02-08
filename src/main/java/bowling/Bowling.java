package bowling;

import java.util.LinkedList;

public class Bowling {
    public int computeScore(Frame... frames) {
        if (frames.length > 10) {
            throw new IllegalArgumentException("Frame cannot be > 10");
        }

        LinkedList<Score> scores = new LinkedList<>();

        for (int i = frames.length - 1; i >= 0; i--) {
            Frame frame = frames[i];
            scores.addFirst(frameToScore(frame, scores.peekFirst()));
        }

        return scores.stream().
                map(Score::compute)
                .reduce(0, Integer::sum);

    }

    private Score frameToScore(Frame frame, Score nextScore) {
        if (frame.isStrike()) {
            return new StrikeScore(frame, nextScore);
        } else if (frame.isSpare()) {
            return new SpareScore(frame, nextScore);
        } else {
            return new SimpleScore(frame.firstLaunch, frame.secondLaunch);
        }
    }
}
