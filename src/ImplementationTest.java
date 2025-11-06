import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementationTest {

    private NumberRangeSummarizer summarizer;

    @BeforeEach
    public void setUp() {
        summarizer = new Implementation();
    }

    // Tests for collect() method

    @Test
    public void testCollect_BasicInput() {
        String input = "1,3,6,7,8";
        Collection<Integer> result = summarizer.collect(input);

        List<Integer> expected = Arrays.asList(1, 3, 6, 7, 8);
        assertEquals(expected, new ArrayList<>(result));
    }

    @Test
    public void testCollect_SingleNumber() {
        String input = "5";
        Collection<Integer> result = summarizer.collect(input);

        List<Integer> expected = Arrays.asList(5);
        assertEquals(expected, new ArrayList<>(result));
    }

    @Test
    public void testCollect_WithSpaces() {
        String input = "1, 3, 6, 7, 8";
        Collection<Integer> result = summarizer.collect(input);

        List<Integer> expected = Arrays.asList(1, 3, 6, 7, 8);
        assertEquals(expected, new ArrayList<>(result));
    }

    @Test
    public void testCollect_NegativeNumbers() {
        String input = "-3,-2,-1,0,1";
        Collection<Integer> result = summarizer.collect(input);

        List<Integer> expected = Arrays.asList(-3, -2, -1, 0, 1);
        assertEquals(expected, new ArrayList<>(result));
    }

    // Tests for summarizeCollection() method

    @Test
    public void testSummarizeCollection_SampleInput() {
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String result = summarizer.summarizeCollection(input);

        assertEquals("1,3,6-8,12-15,21-24,31", result);
    }

    @Test
    public void testSummarizeCollection_SingleNumber() {
        Collection<Integer> input = Arrays.asList(5);
        String result = summarizer.summarizeCollection(input);

        assertEquals("5", result);
    }

    @Test
    public void testSummarizeCollection_AllSequential() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        String result = summarizer.summarizeCollection(input);

        assertEquals("1-5", result);
    }

    @Test
    public void testSummarizeCollection_NoSequential() {
        Collection<Integer> input = Arrays.asList(1, 3, 5, 7, 9);
        String result = summarizer.summarizeCollection(input);

        assertEquals("1,3,5,7,9", result);
    }

    @Test
    public void testSummarizeCollection_TwoNumberRange() {
        Collection<Integer> input = Arrays.asList(1, 2);
        String result = summarizer.summarizeCollection(input);

        assertEquals("1-2", result);
    }

    @Test
    public void testSummarizeCollection_EmptyCollection() {
        Collection<Integer> input = new ArrayList<>();
        String result = summarizer.summarizeCollection(input);

        assertEquals("", result);
    }

    @Test
    public void testSummarizeCollection_NullCollection() {
        String result = summarizer.summarizeCollection(null);

        assertEquals("", result);
    }

    @Test
    public void testSummarizeCollection_NegativeNumbers() {
        Collection<Integer> input = Arrays.asList(-3, -2, -1, 0, 1, 2);
        String result = summarizer.summarizeCollection(input);

        assertEquals("-3-2", result);
    }

    @Test
    public void testSummarizeCollection_MixedRanges() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 5, 7, 8, 10);
        String result = summarizer.summarizeCollection(input);

        assertEquals("1-3,5,7-8,10", result);
    }

    // Integration tests

    @Test
    public void testEndToEnd_SampleInput() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);

        assertEquals("1,3,6-8,12-15,21-24,31", result);
    }

    @Test
    public void testEndToEnd_WithSpaces() {
        String input = "1, 3, 6, 7, 8";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);

        assertEquals("1,3,6-8", result);
    }
}