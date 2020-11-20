package Clasees;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.ArrayList;


public class SendEmail {

    private static String USER_NAME = "gauravpingale4";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "Kingsman@101"; // GMail password
    private static String RECIPIENT = "gauravpingale4@gmail.com";
/*
    public static void main(String[] args) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";
        sendFromGMail(from, pass, to, subject, body);
    }
    */
    public int sendNotiMail(ArrayList<notiDao> arry)
    {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Notificaton from Notifire";
        String body = "";int index=0;
        for(notiDao n:arry)
        {   index++;
            int id =n.id;
            String msg=n.getMsg();
            body=body.concat("\n("+index+") "+msg+",Product ID:"+id);
        }
        return sendFromGMail(from, pass, to, subject, body);
    }

    private static int sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            try {
         URL url = new URL("http://www.google.com");
         URLConnection connection = url.openConnection();
         connection.connect();
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());

         System.out.println("Internet is connected.....Mail send \n Subjet:"+message);
      } catch (MalformedURLException e) {
         System.out.println("Internet is not connected");
         return 0;
      } catch (IOException e) {
         System.out.println("Internet is not connected");
          return 0;
      }
            //transport.connect(host, from, pass);
           // transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return 1;
        }
        catch (AddressException ae) {
            ae.printStackTrace();
                       return 0;

        }
        catch (MessagingException me) {
            me.printStackTrace();
                        return 0;

        } catch (Exception me) {
            me.printStackTrace();
                        return 0;

        }
    }
}