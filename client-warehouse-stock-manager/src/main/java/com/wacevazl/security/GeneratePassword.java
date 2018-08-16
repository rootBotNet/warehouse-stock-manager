package com.wacevazl.security;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GeneratePassword {

    public String generateRandomPassword(int length) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        return passwordGenerator.generatePassword(length, passwordRule());
    }

    private List passwordRule() {
        List rules = Arrays.asList(
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1));
//                new CharacterRule(EnglishCharacterData.Special, 1));

        return rules;
    }
}
