public class Main{
    public static void main(String[] args){
        PasswordView passwordView = new PasswordView();
        passwordView.initializeUI();

        PasswordController passwordController = new PasswordController(passwordView);


    }
}