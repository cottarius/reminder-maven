package ru.cotarius.reminder.converter;

import org.springframework.core.convert.converter.Converter;

public class LoginConverter implements Converter<String, String> {
    @Override
    public String convert(String source) {
        return source.toLowerCase();
    }
}
