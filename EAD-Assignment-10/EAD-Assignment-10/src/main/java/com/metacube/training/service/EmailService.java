package com.metacube.training.service;

public interface EmailService {

    public void sendRecoveryEmail(String to, String subject, String text);
}
