package com.folksdev.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class CustomerDto {
    private String id;
    private String name;
    private String surname;
    private Set<CustomerAccountDto> accounts;


    public <R> CustomerDto(String id, String name, String surname, R collect) {
    }
}

