/**
 * ITE 012 - Java Project
 *
 * @author Ashleigh Nelson L. Milana
 * @version Prototype
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class AccountController
{
    HashMap <String, String> credentials = new HashMap <String, String>();
    private final String database_path = ".\\account.db";
    private String user = "";
    private void getAccountsFromDB() {
        File f = new File(database_path);
        Scanner sc;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("invalid file: " + database_path);
            return;
        }
        String line;
        do {
            try {
                line = sc.nextLine();
            } catch (Exception e) {
                break;
            }
            String[] parts = line.split("   ");
            if (parts.length != 2) 
                continue;

            credentials.put(parts[0], parts[1]);
        } while(line != null);
        
        sc.close();
    }
    private void initDefaults() {
        credentials.put("Antonio", "AGA");
        credentials.put("Sons", "SJG");
        credentials.put("Ashleigh", "ANM");
        credentials.put("Jean", "JCSJ");
        credentials.put("Earl", "LET");
    }
    public AccountController()
    {
        initDefaults();
        getAccountsFromDB();
    }

    public boolean login(String name, String phrase) {
        final String correctPhrase = credentials.get(name);
        boolean verified = correctPhrase != null && phrase.compareTo(correctPhrase) == 0;
    
        if (verified) {
            this.user = name;
        }

        return verified;
    }

    public void logout() {
        this.user = "";
    }
    public String getUser() {
        return this.user;
    }
}