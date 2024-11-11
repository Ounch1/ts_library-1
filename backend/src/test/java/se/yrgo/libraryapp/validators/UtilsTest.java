package se.yrgo.libraryapp.validators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    @ParameterizedTest
    @CsvSource({
            "'Hello World', 'hello world'",
            "'Hello_World', 'helloworld'",
            "'Hello World123', 'hello world'",
            "'Hello!@#$%^&*World', 'helloworld'",
            "'Hello1    World2  Test3', 'hello    world  test'",
            "'', ''" // empty string case
    })
    void testOnlyLettersAndWhitespaces(String text, String expected) {
        assertEquals(expected, Utils.onlyLettersAndWhitespace(text));
    }

    @ParameterizedTest
    @CsvSource({
            "'Us3r', 'user'",
            "'H3ll0 W0rld', 'hello world'",
            "'J4v4   14ng', 'java   lang'",
            "'*/+H3llo@#$%^&()#_!+<>,', 'hello'",
            "'*****', ''",
            "'', ''",
            "'   ', '   '",
            "'Hello1 23World 45', 'hellol eworld as'",
            "'L337 C0d3', 'leet code'",
            "'b4d c0de @#$%', 'bad code '"
    })
    void testCleanAndUnLeet(String text, String expected) {
        assertEquals(expected, Utils.cleanAndUnLeet(text));
    }
}

