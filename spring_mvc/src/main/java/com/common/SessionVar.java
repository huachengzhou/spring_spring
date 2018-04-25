package com.common;

public enum SessionVar {
    USER_SESSION("user"),USER_LIST("usernameList");
    private String var;

    SessionVar(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
}
