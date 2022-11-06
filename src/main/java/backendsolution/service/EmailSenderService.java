package backendsolution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	

    @Autowired
    private JavaMailSender mailSender ;


    public void sendSimpleEmail (String toEmail , String content , String subject ){

        SimpleMailMessage message =  new SimpleMailMessage();
        //Message message = new MimeMessage();

        message.setFrom("sami.riahi@esprit.tn");
        message.setTo(toEmail) ;
        message.setText(content) ;
        message.setSubject(subject) 	;
        
        


        mailSender.send(message);
        System.out.println("Mail send ...");
        

    }

}
