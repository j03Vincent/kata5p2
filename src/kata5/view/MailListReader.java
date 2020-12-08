package kata5.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;

public class MailListReader {
    public static List<Mail> read(ResultSet result) throws SQLException {
        List<Mail> list = new ArrayList<>();
        
        while (result.next()) {
            list.add(new Mail(result.getString("email")));
        }
        return list;
    }
    
}
