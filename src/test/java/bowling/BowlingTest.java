package bowling;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingTest {

    private Bowling bowling;

    @Before
    public void setUp() {
        bowling = new Bowling();
    }

    @Test
    public void should_compute_score_for_one_simple_frame() {
        //Given
        Frame[] frames = {Frame.of(3, 4)};

        //When
        int score = bowling.computeScore(frames);

        //Then
        assertThat(score).isEqualTo(7);
    }

    @Test
    public void should_compute_score_for_10_simple_frame() {
        //Given
        Frame[] frames = createFrames(10, 3, 2);

        //When
        int score = bowling.computeScore(frames);

        //Then
        assertThat(score).isEqualTo(50);
    }

    @Test
    public void should_compute_score_with_one_spare() {
        //Given
        Frame[] frames = {Frame.of(3, 7), Frame.of(3, 4)};

        //When
        int score = bowling.computeScore(frames);

        //Then
        assertThat(score).isEqualTo(20);
    }

    @Test
    public void should_compute_score_with_one_strike() {
        //Given
        Frame[] frames = {Frame.strike(), Frame.of(3, 4)};

        //When
        int score = bowling.computeScore(frames);

        //Then
        assertThat(score).isEqualTo(24);
    }

    @Test
    public void should_compute_score_with_two_spare() {
        //Given
        Frame[] frames = {Frame.of(3, 7), Frame.of(4, 6), Frame.of(2, 3)};

        //When
        int score = bowling.computeScore(frames);

        //Then
        assertThat(score).isEqualTo(31);
    }

    @Test
    public void should_compute_score_with_multiple_spare_and_strike() {
        //Given
        Frame[] frames = {Frame.strike(), Frame.strike(), Frame.strike(),
                Frame.strike(), Frame.of(3, 7), Frame.of(8, 2),
                Frame.strike(), Frame.of(3, 4), Frame.of(4, 4), Frame.of(3, 6)};

        //When
        int score = bowling.computeScore(frames);

        //Then
        assertThat(score).isEqualTo(182);
    }

    @Test
    public void should_compute_score_when_final_frame_contains_strike() {
        //Given
        List<Frame> frames = new ArrayList<>(Arrays.asList(createFrames(9, 1, 1)));
        frames.add(Frame.lastFrame(10, 10, 10));

        //When
        int score = bowling.computeScore(frames.toArray(new Frame[frames.size()]));

        //Then
        assertThat(score).isEqualTo(48);
    }

    @Test
    public void should_compute_score_when_final_frame_contains_spare_then_strike() {
        //Given
        List<Frame> frames = new ArrayList<>(Arrays.asList(createFrames(9, 1, 1)));
        frames.add(Frame.lastFrame(3, 7, 10));

        //When
        int score = bowling.computeScore(frames.toArray(new Frame[frames.size()]));

        //Then
        assertThat(score).isEqualTo(38);
    }

    @Test
    public void should_compute_score_when_final_frame_contains_strike_then_spare() {
        //Given
        List<Frame> frames = new ArrayList<>(Arrays.asList(createFrames(9, 1, 1)));
        frames.add(Frame.lastFrame(10, 3, 7));

        //When
        int score = bowling.computeScore(frames.toArray(new Frame[frames.size()]));

        //Then
        assertThat(score).isEqualTo(38);
    }

    private Frame[] createFrames(int count, int firstLaunch, int secondLaunch) {
        Frame[] frames = new Frame[count];
        Arrays.fill(frames, Frame.of(firstLaunch, secondLaunch));
        return frames;
    }
}