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
}