import java.util.Map;
import java.util.regex.Pattern;

public class Minimal {
    public static void main(String[] args) {
        Map<String, String> toMorse = Map.ofEntries( Map.entry("0", "-----"),  Map.entry("1", ".----"),  Map.entry("2", "..---"), Map.entry("3", "...--"),  Map.entry("4", "....-"),  Map.entry("5", "....."), Map.entry("6", "-...."),  Map.entry("7", "--..."),  Map.entry("8", "---.."), Map.entry("9", "----."),  Map.entry("a", ".-"),     Map.entry("b", "-..."), Map.entry("c", "-.-."),   Map.entry("d", "-.."),    Map.entry("e", "."), Map.entry("f", "..-."),   Map.entry("g", "--."),    Map.entry("h", "...."), Map.entry("i", ".."),     Map.entry("j", ".---"),   Map.entry("k", "-.-"), Map.entry("l", ".-.."),   Map.entry("m", "--"),     Map.entry("n", "-."), Map.entry("o", "---"),    Map.entry("p", ".--."),   Map.entry("q", "--.-"), Map.entry("r", ".-."),    Map.entry("s", "..."),    Map.entry("t", "-"), Map.entry("u", "..-"),    Map.entry("v", "...-"),   Map.entry("w", ".--"), Map.entry("x", "-..-"),   Map.entry("y", "-.--"),   Map.entry("z", "--.."), Map.entry(" ", " ") );
        Map<String, String> toLatin = Map.ofEntries( Map.entry("-----", "0"),  Map.entry(".----", "1"),  Map.entry("..---", "2"), Map.entry("...--", "3"),  Map.entry("....-", "4"),  Map.entry(".....", "5"), Map.entry("-....", "6"),  Map.entry("--...", "7"),  Map.entry("---..", "8"), Map.entry("----.", "9"),  Map.entry(".-", "a"),     Map.entry("-...", "b"), Map.entry("-.-.", "c"),   Map.entry("-..", "d"),    Map.entry(".", "e"), Map.entry("..-.", "f"),   Map.entry("--.", "g"),    Map.entry("....", "h"), Map.entry("..", "i"),     Map.entry(".---", "j"),   Map.entry("-.-", "k"), Map.entry(".-..", "l"),   Map.entry("--", "m"),     Map.entry("-.", "n"), Map.entry("---", "o"),    Map.entry(".--.", "p"),   Map.entry("--.-", "q"), Map.entry(".-.", "r"),    Map.entry("...", "s"),    Map.entry("-", "t"), Map.entry("..-", "u"),    Map.entry("...-", "v"),   Map.entry(".--", "w"), Map.entry("-..-", "x"),   Map.entry("-.--", "y"),   Map.entry("--..", "z"), Map.entry("", " ") );
        var sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("-1")) break;

            boolean validInput = true;
            StringBuilder output = new StringBuilder();

            if (Pattern.compile("[.\\- ]+").matcher(input).matches()) { // if input is Morse
                input = input.replaceAll("\\s{3,}","  "); // trim spaces in-between words
                for (String letter : input.split(" ")) { // split the sentence
                    output.append(toLatin.get(letter)); // append the translation of the letter
                    if (toLatin.get(letter) == null) { // if doesn't find the translation
                        validInput = false; // is not a valid input
                        break;
                    }
                }
            } else if (Pattern.compile("[a-z0-9 ]+").matcher(input).matches()) {
                input = input.replaceAll("\\s{2,}"," ");
                for (String letter : input.split("")) {
                    if (letter.equals(" ")) output.append(toMorse.get(letter));
                    else output.append(toMorse.get(letter)).append(" ");
                    if (toMorse.get(letter) == null) {
                        validInput = false;
                        break;
                    }
                }
            } else validInput = false;

            if (validInput) System.out.println(output.toString().trim());
            else System.out.println("Unexpected input");
        }
    }
}
