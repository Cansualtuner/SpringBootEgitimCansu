package com.folksdev.account.dto;

import java.math.BigDecimal;

public class CreateAccountRequest {
    private String customerId;
    private BigDecimal initialCredit;

    public CreateAccountRequest(String id, BigDecimal bigDecimal) {

    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(BigDecimal initialCredit) {
        this.initialCredit = initialCredit;
    }
}
