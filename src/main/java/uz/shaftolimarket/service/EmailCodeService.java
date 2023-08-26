package uz.shaftolimarket.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.shaftolimarket.model.EmailCodeEntity;
import uz.shaftolimarket.repository.EmailCodeRepository;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailCodeService {
    private EmailCodeRepository emailCodeRepository;
    public void save(String receiverEmail){
        // Ma'lumotlar
        String emailCode = String.valueOf((new Random()).nextInt(900000) + 100000);
        String email = "shaftolipayment@gmail.com";
        String password = "usotxkyhssdwsyel";

        // Email serveri ma'lumotlari
        String host = "smtp.gmail.com";
        String port = "587"; // Gmail uchun 587 porti ishlatiladi

        // Po'chtadan yuborilayotgan xabarni tuzish
        String subject = "Verification";
        String body = "Your verification code:\n" +
                emailCode;

        // Po'chta serveriga ulanish ma'lumotlari
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Ta'riflanayotgan po'chtadan yuborish tizimi orqali pochta ko'rsatgichini tuzamiz
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            // Xabarni tuzamiz
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
            message.setSubject(subject);
            message.setText(body);

            // Xabarni yuboramiz
            Transport.send(message);

            EmailCodeEntity emailCode1 = EmailCodeEntity.builder()
                    .id(UUID.randomUUID())
                    .email(receiverEmail)
                    .code(emailCode)
                    .build();

            emailCodeRepository.save(emailCode1);
            System.out.println("Xabar muvaffaqiyatli yuborildi!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
