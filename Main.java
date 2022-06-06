public class Main {
    private static AccountController ac = new AccountController(); 
    //Global variable because the name field will be used later
    public static void main(String[] args) {
        
        LoginSection loginSection = new LoginSection(ac);
    }
}