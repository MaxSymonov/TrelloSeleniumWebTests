package com.telran.tests.model;

public class Profile {
    private String newPassword;
    private String oldPassword;

    public Profile setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    public Profile setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "newPassword='" + newPassword + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                '}';
    }
}
