package telephoneDialPad;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneDialPadTest {

    @Description("High - This tests the most basic functionality of the dial pad mapping.")
    @Test
    public void testSingleDigit() {
        List<String> combinations = TelephoneDialPad.retrieveCombinations("2");
        List<String> expectedCombinations = List.of("A", "B", "C");
        assertEquals(expectedCombinations, combinations);
    }

    @Description("High - Ensures the program handles case with no input.")
    @Test
    public void testEmpty() {
        List<String> combinations = TelephoneDialPad.retrieveCombinations("");
        assertTrue(combinations.isEmpty());
    }

    @Description("High - Tests the program's ability to handle multiple digits.")
    @Test
    public void testMultipleDigits() {
        List<String> combinations = TelephoneDialPad.retrieveCombinations("23");
        List<String> expectedCombinations = List.of("AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF");
        assertEquals(expectedCombinations, combinations);
    }

    @Description("Middle - Tests if the program correctly handles the digit 0 with digit with letters")
    @Test
    public void testInputWithZero() {
        List<String> combinations = TelephoneDialPad.retrieveCombinations("40");
        List<String> expectedCombinations = List.of("G0", "H0", "I0");
        assertEquals(expectedCombinations, combinations);
    }

    @Description("Middle - Handling only digits without letters")
    @Test
    public void testWithOne() {
        List<String> combinations = TelephoneDialPad.retrieveCombinations("11");
        List<String> expectedCombinations = List.of("11");
        assertEquals(expectedCombinations, combinations);
    }

    @Description("Middle -  Evaluates the program's performance with a large input.")
    @Test
    public void testWithLongSequenceOfDigits() {
        List<String> combinations = TelephoneDialPad.retrieveCombinations("5555555555");
        List<String> expectedCombinations = List.of("JJJJJJJJJJ", "JJJJJJJJJK", "JJJJJJJJJL", "JJJJJJJJKJ", "JJJJJJJJKK",
                "JJJJJJJJKL", "JJJJJJJJLJ", "JJJJJJJJLK", "JJJJJJJJLL", "JJJJJJJKJJ", "JJJJJJJKJK", "JJJJJJJKJL", "JJJJJJJKKJ");
        assertTrue(combinations.containsAll(expectedCombinations));
    }

    @Description("Low - Tests if the program handles spaces in the input.")
    @Test
    public void testDigitsWithSpaces() {
        List<String> combinations = TelephoneDialPad.retrieveCombinations("5 6 ");
        List<String> expectedCombinations = List.of("JM", "JN", "JO", "KM", "KN", "KO", "LM", "LN", "LO");
        assertEquals(expectedCombinations, combinations);
    }

    @Description("Low - Tests how the program handles repetitive digits.")
    @Test
    public void testRepetitiveDigits() {
        List<String> combinations = TelephoneDialPad.retrieveCombinations("77");
        List<String> expectedCombinations = List.of("PP", "PQ", "PR", "PS", "QP", "QQ", "QR", "QS", "RP", "RQ", "RR",
                "RS", "SP", "SQ", "SR", "SS");
        assertEquals(expectedCombinations, combinations);
    }

    @Description("Low -  Tests if the program handles a combination of digits and special characters.")
    @Test
    public void testWithSpecialCharacters() {
        List<String> combinations = TelephoneDialPad.retrieveCombinations("~!7#8");
        List<String> expectedCombinations = List.of("PT", "PU", "PV", "QT", "QU", "QV", "RT", "RU", "RV", "ST", "SU", "SV");
        assertEquals(expectedCombinations, combinations);
    }

    @Description("Low - Tests if the program handles input with letters")
    @Test
    public void testInputWithLetters() {
        List<String> combinations = TelephoneDialPad.retrieveCombinations("8a39");
        List<String> expectedCombinations = List.of("TW", "TX", "TY", "TZ", "UW", "UX", "UY", "UZ", "VW", "VX", "VY", "VZ");
        assertEquals(expectedCombinations, combinations);
    }
}
