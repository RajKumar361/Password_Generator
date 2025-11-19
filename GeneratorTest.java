import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GeneratorTest {
    @Test
    void testPasswordCreation() {
        Password password = new Password("Test123!");
        assertEquals("Test123!", password.toString());
    }
    
    @Test
    void testAlphabetCreation() {
        Alphabet alphabet = new Alphabet(true, true, false, false);
        assertTrue(alphabet.getCharacters().contains("A"));
        assertTrue(alphabet.getCharacters().contains("a"));
        assertFalse(alphabet.getCharacters().contains("1"));
    }
    
    @Test
    void testPasswordStrength() {
        Password weak = new Password("abc");
        Password medium = new Password("Abc123");
        Password strong = new Password("Abc123!@#");
        
        assertTrue(weak.calculateStrength() < 3);
        assertTrue(medium.calculateStrength() >= 3);
        assertTrue(strong.calculateStrength() >= 4);
    }
}