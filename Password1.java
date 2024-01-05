import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Password1 {
    protected static final String defaultPassword = "Def@u1tPa$$w0rd";
    protected static final int length = 8;
    protected final int numSymbols;
    protected final int numCap;
    protected final int numLowCase;
    protected final int numDigits;
    protected String password;

    Password1() {
        this(1, 1, 1, 1);
        this.password = defaultPassword;
    }

    Password1(int numSymbols, int numCap, int numLowCase, int numDigits) {
        this.numSymbols = numSymbols;
        this.numCap = numCap;
        this.numLowCase = numLowCase;
        this.numDigits = numDigits;
    }

    public boolean validLength(String password) {
        return password.length() >= length;
    }

    public boolean validSymbol(String password) {
        int symbolCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 32 && password.charAt(i) <= 47 || password.charAt(i) >= 58 && password.charAt(i) <= 64) {
                if (this.numSymbols > symbolCount) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean validDigits(String password) {
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                if (this.numDigits > digitCount) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validCaps(String password){
        int capCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
                if (this.numCap > capCount) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validLow(String password){
        int lowCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
                if (this.numLowCase > lowCount) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(){
        Scanner scan = new Scanner(System.in);
        String newPassword;
        boolean result = true;

        do {
            System.out.println("Enter a password that meets the following requirements:");
            System.out.println("1. Required password length of at least 8 characters");
            System.out.println("2. Required number of symbols: " + numSymbols);
            System.out.println("3. Required number of capital letters: " + numCap);
            System.out.println("4. Required number of lowercase letters: " + numLowCase);
            System.out.println("5. Required number of digits: " + numDigits);

            newPassword = scan.nextLine();

            if (!validLength(newPassword)) {
                System.out.println("Invalid password length.");
                result = false;
            } else if (!validSymbol(newPassword)) {
                System.out.println("Invalid number of symbols.");
                result = false;
            } else if (!validCaps(newPassword)) {
                System.out.println("Invalid number of capital letters.");
                result = false;
            } else if (!validLow(newPassword)) {
                System.out.println("Invalid number of lowercase letters>");
                result = false;
            } else if (!validDigits(newPassword)) {
                System.out.println("Invalid number of digits.");
                result = false;
            } else {
                password = newPassword;
            }
        }
        while(!result);
    }

    public static void main(String[] args){
        Password1 firstPassword = new Password1();
        System.out.println("Default Password: " + firstPassword.getPassword());
        firstPassword.setPassword();
        System.out.println("First Password: " + firstPassword.getPassword());

        Password1 secondPassword = new Password1(2,2,2,2);
        secondPassword.setPassword();
        System.out.println("Second password: " + secondPassword.getPassword());
    }
}



public class Password2 extends Password1 {
    private int minSettings;

    Password2() {
        super(Password1());
        this.minSettings = actualLength();
    }

    Password2(int numSymbols, int numCap, int numLowCase, int numDigits) {
        super(numSymbols, numCap, numLowCase, numDigits);
        this.minSettings = actualLength();
    }

    public int actualLength() {
        return (numSymbols + numCap + numLowCase + numDigits) < length ? length : (numLowCase + numDigits + numCap + numSymbols);
    }

    public static boolean checkRange(String pass, int required, char start, char end) {

    }

    @Override
    public void setPassword() {
        Scanner scan = new Scanner(System.in);
        String newPassword;
        boolean result = true;

        do {
            System.out.println("Enter a password that meets the following requirements:");
            System.out.println("1. Required password length of at least" + length + " characters");
            System.out.println("2. Required number of symbols: " + numSymbols);
            System.out.println("3. Required number of capital letters: " + numCap);
            System.out.println("4. Required number of lowercase letters: " + numLowCase);
            System.out.println("5. Required number of digits: " + numDigits);

            newPassword = scan.nextLine();

            if (!minSettings(newPassword)) {
                System.out.println("Invalid password length.");
                result = false;
            }
        } while (!result);
    }
}