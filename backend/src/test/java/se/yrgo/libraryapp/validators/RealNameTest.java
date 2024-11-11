package se.yrgo.libraryapp.validators;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RealNameTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/bad_words.txt", numLinesToSkip = 0)
    void testContainsBadWord(String word)
    {
        assertFalse(RealName.validate(word), "Expected validation to fail for: " + word);
    }
}
