public class PasswordStrength {
    int score = 0;
    String recommendations = "";

    // record to allow two returns
    public record PasswordResult(String recommendations, int score) {}


    public PasswordResult checkPasswordStrength(String password){
        if(password == null || password.isEmpty()){
            recommendations += "Invalid Password\n";
            return new PasswordResult(recommendations, score);
        }

        //length
        if(password.length() < 16){
            recommendations += "Increase password length\n";
        }
        if(password.length() >= 8){
            score++;
        }
        if(password.length() >= 12){
            score++;
        }
        if(password.length() >= 16){
            score++;
        }

        //char type

        if(password.matches(".*[A-Z].*")){
            score++;
        }else{
            recommendations += "Include a capitol letter\n";
        }
        if(password.matches(".*[a-z].*")){
            score++;
        }else{
            recommendations += "Include a lowercase letter\n";
        }
        if(password.matches(".*[0-9].*")){
            score++;
        }else{
            recommendations += "Include a number\n";
        }
        if(password.matches(".*[^A-Za-z0-9].*")){
            score++;
        }else{
            recommendations += "Include a special character\n";
        }


        return new PasswordResult(recommendations, score);


    }



    public String scoreCalc(int score){

        if(score <= 2){
            return "Weak";
        }else if(score <= 4){
            return "Medium";
        }else if(score < 7){
            return "Strong";
        } else{
            return "Very Strong";
        }
    }

}
