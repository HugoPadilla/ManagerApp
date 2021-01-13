package com.manager.managerapp.common.pojo;

public class Email {

    private String
            email,
            emailVinculado;

    private boolean viculado;

    public Email() {
    }

    public Email(String email, String emailVinculado, boolean viculado) {
        this.email = email;
        this.emailVinculado = emailVinculado;
        this.viculado = viculado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailVinculado() {
        return emailVinculado;
    }

    public void setEmailVinculado(String emailVinculado) {
        this.emailVinculado = emailVinculado;
    }

    public boolean isViculado() {
        return viculado;
    }

    public void setViculado(boolean viculado) {
        this.viculado = viculado;
    }
}
