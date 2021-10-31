package eu.portunus.util.passwordgenerator;

import java.util.*;

public class PasswordGenerator implements IPasswordGenerator {

    Map<CharacterSet, String[]> characterSetMap;

    public PasswordGenerator() {
        characterSetMap = new HashMap<>();
        characterSetMap.put(
            CharacterSet.UPPER_CASE,
            new String[] {
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G",
                "H",
                "I",
                "J",
                "K",
                "L",
                "M",
                "N",
                "O",
                "P",
                "Q",
                "R",
                "S",
                "T",
                "U",
                "V",
                "W",
                "X",
                "Y",
                "Z",
            }
        );
        characterSetMap.put(
            CharacterSet.LOWER_CASE,
            new String[] {
                "a",
                "b",
                "c",
                "d",
                "e",
                "f",
                "g",
                "h",
                "i",
                "j",
                "k",
                "l",
                "m",
                "n",
                "o",
                "p",
                "q",
                "r",
                "s",
                "t",
                "u",
                "v",
                "w",
                "x",
                "y",
                "z",
            }
        );
        characterSetMap.put(
            CharacterSet.DIGITS,
            new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }
        );
        characterSetMap.put(CharacterSet.MINUS, new String[] { "-" });
        characterSetMap.put(CharacterSet.UNDERSCORE, new String[] { "_" });
        characterSetMap.put(CharacterSet.SPACE, new String[] { " " });
    }

    @Override
    public String generatePassword(
        int length,
        Collection<CharacterSet> characterSets
    ) {
        if (characterSets == null || characterSets.isEmpty() || length < 1) {
            return "";
        }

        // Remove duplicate character sets.
        List<CharacterSet> characterSetsArray = new ArrayList<>(
            new HashSet<>(characterSets)
        );

        Random random = new Random();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // Get a random character set.
            CharacterSet characterSet = characterSetsArray.get(
                random.nextInt(characterSetsArray.size())
            );

            // Get the characters from the random character set.
            String[] characters = characterSetMap.get(characterSet);

            // Get a random character and append it to the password.
            String character = characters[random.nextInt(characters.length)];
            password.append(character);
        }

        return password.toString();
    }
}
