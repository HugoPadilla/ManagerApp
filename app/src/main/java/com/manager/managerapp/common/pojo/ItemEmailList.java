package com.manager.managerapp.common.pojo;

public class ItemEmailList {

    private String
            time,
            email,
            emailVinculado;

    public ItemEmailList() {
    }

    public ItemEmailList(String time, String email, String emailVinculado) {
        this.time = time;
        this.email = email;
        this.emailVinculado = emailVinculado;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
}
