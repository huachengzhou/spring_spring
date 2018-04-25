package com.common;

public enum ControllerEnum {
    View("views/"),JSP("jsp/"),REST_NUM("REST/"),userAREST("userA-REST/"),FILE("file/");
    private String var;

    ControllerEnum(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
}
