package com.asklepios.hospitalreservation_asklepios.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public interface IF_MailService {
    MimeMessage CreateMail(String mail) throws MessagingException;
    int sendMail(String mail) throws MessagingException;
}