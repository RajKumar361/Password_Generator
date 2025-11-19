public class Password {
    private final String value;
    
    public Password(String value) {
        this.value = value;
    }
    
    private int getCharType(char c) {
        if (Character.isUpperCase(c)) return 1;
        if (Character.isLowerCase(c)) return 2;
        if (Character.isDigit(c)) return 3;
        return 4; // Symbol
    }
    
    public int calculateStrength() {
        boolean hasUpper = false, hasLower = false, hasNumber = false, hasSymbol = false;
        int score = 0;
        
        for (char c : value.toCharArray()) {
            switch (getCharType(c)) {
                case 1: hasUpper = true; break;
                case 2: hasLower = true; break;
                case 3: hasNumber = true; break;
                case 4: hasSymbol = true; break;
            }
        }
        
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasNumber) score++;
        if (hasSymbol) score++;
        
        if (value.length() >= 8) score++;
        if (value.length() >= 16) score++;
        
        return score;
    }
    
    public String getStrengthFeedback() {
        int score = calculateStrength();
        
        if (score == 6) return "Excellent password! Very strong.";
        if (score >= 4) return "Good password, but could be stronger.";
        if (score >= 3) return "Medium strength. Consider improving it.";
        return "Weak password. Please choose a stronger one.";
    }
    
    @Override
    public String toString() {
        return value;
    }
}