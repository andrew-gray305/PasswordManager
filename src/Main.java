public class Main{
    public static void main(String[] args){
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        System.out.println(passwordGenerator.generatePassword());

        PasswordView passwordView = new PasswordView();
        passwordView.initializeUI();

        PasswordController passwordController = new PasswordController(passwordView);


    }
}