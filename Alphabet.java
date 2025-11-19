public class Alphabet {
    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
    
    private final StringBuilder characters;
    
    public Alphabet(boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSymbols) {
        characters = new StringBuilder();
        
        if (includeUpper) characters.append(UPPERCASE);
        if (includeLower) characters.append(LOWERCASE);
        if (includeNumbers) characters.append(NUMBERS);
        if (includeSymbols) characters.append(SYMBOLS);
    }
    
    public String getCharacters() {
        return characters.toString();
    }
}