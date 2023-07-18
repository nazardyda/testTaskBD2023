import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    public static void main(String[] args) {
        String text = "The Tao gave birth to machine language. Machine language gave birth " +
                "to the assembler. The assembler gave birth to the compiler. Now there are ten thousand " +
                "languages. Each language has its purpose, however humble. Each language " +
                "expresses the Yin and Yang of software. Each language has its place within " +
                "the Tao. But do not program in COBOL if you can avoid it. " +
                "-- Geoffrey James, \"The Tao of Programming\"";

        char uniqueCharacter = findUniqueCharacter(text);
        System.out.println("The unique character is: " + uniqueCharacter);
    }

    public static char findUniqueCharacter(String text) {
        String[] words = text.split("[^a-zA-Z]+");
        List<Character> uniqueLowerCaseCharacters = new ArrayList<>();
        List<Character> uniqueUpperCaseCharacters = new ArrayList<>();

        for (String word : words) {
            char firstChar = word.charAt(0);

            if (word.lastIndexOf(firstChar) == word.indexOf(firstChar)) {
                addUniqueCharacter(firstChar, uniqueLowerCaseCharacters, uniqueUpperCaseCharacters);
            } else {
                for (int i = 1; i < word.length(); i++) {
                    char currentChar = word.charAt(i);
                    if (word.lastIndexOf(currentChar) == word.indexOf(currentChar)) {
                        addUniqueCharacter(currentChar, uniqueLowerCaseCharacters, uniqueUpperCaseCharacters);
                        break;
                    }
                }
            }
        }

        for (char c : uniqueLowerCaseCharacters) {
            if (!isCharacterRepeated(c, uniqueLowerCaseCharacters)) {
                return c;
            }
        }

        for (char c : uniqueUpperCaseCharacters) {
            if (!isCharacterRepeated(c, uniqueUpperCaseCharacters)) {
                return c;
            }
        }

        return '\0';
    }

    private static boolean isCharacterRepeated(char c, List<Character> characters) {
        int count = 0;
        for (char ch : characters) {
            if (ch == c) {
                count++;
            }
        }
        return count > 1;
    }

    private static void addUniqueCharacter(char c, List<Character> uniqueLowerCaseCharacters,
                                           List<Character> uniqueUpperCaseCharacters) {
        if (Character.isLowerCase(c)) {
            uniqueLowerCaseCharacters.add(c);
        } else if (Character.isUpperCase(c)) {
            uniqueUpperCaseCharacters.add(c);
        }
    }
}
