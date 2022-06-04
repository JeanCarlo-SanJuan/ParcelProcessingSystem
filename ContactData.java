import java.util.Date;
import javax.swing.*;

public class ContactData{
    /* public final String name,
    street_location,
    city,
    zip_code,
    region,
    country_code,
    phone_number; */

    private Window w;
    //public final Date date;
    private static final String[] s_fields= {
        "Name",
        "Street",
        "City",
        "ZIP Code",
        "Region",
        "Country Code",
        "Phone Number"
    };
    private JTextField[] fields = new JTextField[s_fields.length];

    ContactData() {
        int y = 50;
        w = new Window();
        for (int i = 0; i < s_fields.length; i++) {
            JTextField f = new JTextField(s_fields[i]);
            f.setBounds(50, y + i * y, 200, 30);
            fields[i] = f;
            w.add(f);
        }
        w.paint();
    }
}