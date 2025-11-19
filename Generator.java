import java.util.Scanner;

public class Generator {
    private Alphabet alphabet;
    private Scanner scanner;
    
    public Generator(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void run() {
        System.out.println("Password Generator");
        while (true) {
            printMenu();
            String choice = scanner.next();
            
            switch (choice) {
                case "1": generatePassword(); break;
                case "2": checkPassword(); break;
                case "3": showTips(); break;
                case "4": 
                    System.out.println("Goodbye!");
                    return;
                default: 
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    
    private void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Generate Password");
        System.out.println("2. Check Password Strength");
        System.out.println("3. Show Password Tips");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
    
    private void generatePassword() {
        System.out.println("\nPassword Generator");
        
        boolean includeUpper = askYesNo("Include uppercase letters? (yes/no): ");
        boolean includeLower = askYesNo("Include lowercase letters? (yes/no): ");
        boolean includeNumbers = askYesNo("Include numbers? (yes/no): ");
        boolean includeSymbols = askYesNo("Include symbols? (yes/no): ");
        
        if (!includeUpper && !includeLower && !includeNumbers && !includeSymbols) {
            System.out.println("You must include at least one character type.");
            return;
        }
        
        System.out.print("Enter password length: ");
        int length = scanner.nextInt();
        
        alphabet = new Alphabet(includeUpper, includeLower, includeNumbers, includeSymbols);
        Password password = generateRandomPassword(length);
        
        System.out.println("\nGenerated Password: " + password);
    }
    
    private Password generateRandomPassword(int length) {
        String chars = alphabet.getCharacters();
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            password.append(chars.charAt(index));
        }
        
        return new Password(password.toString());
    }
    
    private void checkPassword() {
        System.out.print("\nEnter password to check: ");
        String input = scanner.next();
        Password password = new Password(input);
        
        System.out.println(password.getStrengthFeedback());
    }
    
    private void showTips() {
        System.out.println("\nPassword Tips:");
        System.out.println("- Use at least 12 characters");
        System.out.println("- Include uppercase, lowercase, numbers, and symbols");
        System.out.println("- Avoid common words and personal information");
        System.out.println("- Don't reuse passwords across different sites");
    }
    
    private boolean askYesNo(String question) {
        while (true) {
            System.out.print(question);
            String answer = scanner.next().toLowerCase();
            if (answer.equals("yes")) return true;
            if (answer.equals("no")) return false;
            System.out.println("Please answer 'yes' or 'no'");
        }
    }
}