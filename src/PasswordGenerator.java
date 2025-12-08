import java.util.ArrayList;
import java.util.Random;



public class PasswordGenerator {

    Random r = new Random();

    private int numChars = 20; // default number of characters
    private String password = "";



    char[] characters = {
            // Uppercase
            'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            // Lowercase
            'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z',
            // Numbers
            '0','1','2','3','4','5','6','7','8','9',
            // Symbols
            '!','@','#','$','%','^','&','*',';',':',',','.','?',

    };

    public int randomNum(){
        int r1 = r.nextInt(75);

        return r1;
    }


    public String generatePassword(){
        for(int i = 0; i < numChars; i++){

            char randomChar = characters[randomNum()];
            password += randomChar;

        }

        return password;
    }



}
