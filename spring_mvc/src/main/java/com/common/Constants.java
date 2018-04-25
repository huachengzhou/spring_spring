package com.common;

public enum Constants {
    WEBSOCKET_USERNAME("blake"),SESSION_USERNAME("blake");
    private String var;


    Constants(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
}
