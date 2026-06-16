package com.techstore.app.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/api/farewell?lang=en
@RestController
@RequestMapping("/api")
public class LanguageController {
    private final MessageSource messageSource;

    public LanguageController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/greeting")
    public String greeting(Locale locale) {
        return messageSource.getMessage("greeting", null, locale);
    }

    @GetMapping("/farewell")
    public String farewell(Locale locale) {
        return messageSource.getMessage("farewell", null, locale);
    }

    @GetMapping("/cpu/manufacturer")
    public String cpuManufacturer(Locale locale) {
        return messageSource.getMessage("cpu.manufacturer", null, locale);
    }

    @GetMapping("/cpu/not-found")
    public String cpuNotFound(Locale locale) {
        return messageSource.getMessage("cpu.not.found", new Object[] { 1 }, locale);
    }

}
