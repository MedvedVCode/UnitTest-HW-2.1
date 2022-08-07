import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShortWordsTest {
    private static ShortWords sut;

    @BeforeEach
    public void init() {
        System.out.println("Test starts!");
        sut = new ShortWords();
    }

    @BeforeAll
    public static void started() {
        System.out.println("All tests are started! Yooo - Hoooo!");
    }

    @Test
    public void testFindShortWords() {
        String[] input = {"aa", "bb", "c", "bb", "v"};
        int expected = 2;
        int result = sut.findShortWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void testHamcrestFindShortWords() {
        String[] input = {"aa", "", "bb", "", "c"};
        int expected = 2;
        assertThat(expected, equalTo(sut.findShortWords(input)));
        assertThat(input,hasItemInArray(""));
    }

    @Test
    public void testFindShortWordsOnlyOne() {
        String[] input = {"aaaa"};
        int expected = 1;
        int result = sut.findShortWords(input);
        assertEquals(expected, result);
    }

    @Test
    public void testHamcrestFindShortWordsOnlyOne() {
        String[] input = {"aaaa"};
        int result = sut.findShortWords(input);
        assertThat(result, not(0));
        assertThat(result, allOf(greaterThan(0), lessThan(1000), not(100)));
    }

    @Test
    public void testFindShortWordsIfNull() {
        String[] input = null;
        int result = sut.findShortWords(input);
        assertNotNull(result);
    }

    @Test
    public void testHamcrestZipStrIfNull() {
        String input = "AAABB";
        String result = sut.zipStr(input);
        assertThat(result, notNullValue());
    }

    @Test
    public void testFindShortWordsNoThrows() {
        String[] input = null;
        // assertThrows(RuntimeException.class, () -> sut.findShortWords(input));
        assertDoesNotThrow(() -> sut.findShortWords(input));
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testZipStr(String input, String expected) {
        String result = sut.zipStr(input);
        assertEquals(expected, result);
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("We completed all tests! Congratulations!");
    }

    @AfterEach
    public void finished() {
        sut = null;
        System.out.println("Test finished successfully!");
        System.out.println();
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of("AACBBBD", "A2CB3D"), Arguments.of("", ""));
    }
}
