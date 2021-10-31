package eu.portunus.util.passwordgenerator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.portunus.util.passwordgenerator.CharacterSet;
import eu.portunus.util.passwordgenerator.PasswordGenerator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordGeneratorTest {

    private PasswordGenerator passwordGenerator;
    private List<CharacterSet> characterSets;

    @BeforeEach
    void setUp() {
        passwordGenerator = new PasswordGenerator();
        characterSets = new ArrayList<>();
    }

    @Test
    void ReturnEmptyString_When_ZeroPasswordLength() {
        characterSets.add(CharacterSet.UPPER_CASE);
        String password = passwordGenerator.generatePassword(0, characterSets);
        assertEquals("", password);
    }

    @Test
    void ReturnEmptyString_When_NegativePasswordLength() {
        characterSets.add(CharacterSet.UPPER_CASE);
        String password = passwordGenerator.generatePassword(
            -42,
            characterSets
        );
        assertEquals("", password);
    }

    @Test
    void ReturnEmptyString_When_NullCharacterSet() {
        String password = passwordGenerator.generatePassword(42, null);
        assertEquals("", password);
    }

    @Test
    void ReturnEmptyString_When_EmptyCharacterSet() {
        String password = passwordGenerator.generatePassword(42, characterSets);
        assertEquals("", password);
    }

    @Test
    void PasswordIsNChars_When_LengthIsN() {
        characterSets.add(CharacterSet.UPPER_CASE);
        characterSets.add(CharacterSet.LOWER_CASE);
        characterSets.add(CharacterSet.DIGITS);
        String password = passwordGenerator.generatePassword(42, characterSets);
        assertEquals(42, password.length());
    }
}
