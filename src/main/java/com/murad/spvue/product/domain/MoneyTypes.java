package com.murad.spvue.product.domain;

public enum MoneyTypes {

    USD("Dollar", "$"),
    EUR("Euro", "E"),
    AZN("Manat", "M");

    private String label; //dollar
    private String symbol; // $

    MoneyTypes(String label, String symbol){
        this.label = label;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
