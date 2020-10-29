package com.bappy.twiliosender.service;

import com.bappy.twiliosender.entity.TwilioConfiguration;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class TwilioSmsSender  {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    public void sendSms(String message,String phone) {
        if (isPhoneNumberValid(phone)) {
            Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());
            Message messageBody = Message.creator(
                    new com.twilio.type.PhoneNumber("+88"+phone),
                    new com.twilio.type.PhoneNumber(twilioConfiguration.getTrialNumber()),
                    message)
                    .create();
            LOGGER.info("Sending sms "+messageBody.getAccountSid());
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + phone + "] is not a valid number"
            );
        }

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: Implement phone number validator
        if(phoneNumber.length() > 11 || phoneNumber.length() < 11){
            return false;
        }
        Pattern digitPattern = Pattern.compile("\\d{11}");
        return digitPattern.matcher(phoneNumber).matches();
    }
}



