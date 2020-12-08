package kata5.main;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReader;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us500.db");
                Statement statement = connection.createStatement()) {
            
            ResultSet result = statement.executeQuery("SELECT * FROM people");
            List<Mail> mailList = MailListReader.read(result);
        
            Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        
            HistogramDisplay histogramDisplay = new HistogramDisplay("Emails",histogram);
            histogramDisplay.execute();
            
        }
        
    }
    
}