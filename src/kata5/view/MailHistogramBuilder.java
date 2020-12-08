package kata5.view;

import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;

public class MailHistogramBuilder {

    public static Histogram<String> build (List<Mail> mailList) {
        
        Histogram<String> histogram = new Histogram<>();
        
        for (Mail mail : mailList) {
            histogram.increment(mail.getDomain());
        }
        
        for (Mail mail : mailList){
            if(histogram.get(mail.getDomain()) == 1){
                histogram.increment("others");
                histogram.remove(mail.getDomain());
            }
        }
        
        return histogram;
    }
    
}