package com.lamark.data.triyakom.constants;

public enum PbpOptionsIntegration {
    SUSCRIPCION(1),
    FIRST_BILLING(2),
    SECOND_BILLING(3);

    private Integer optionValue;

    private PbpOptionsIntegration(int i) {
        this.optionValue = i;
    }

    public Integer getOptionValue() {
        return this.optionValue;
    }

    public void setOptionValue(Integer optionValue) {
        this.optionValue = optionValue;
    }
}