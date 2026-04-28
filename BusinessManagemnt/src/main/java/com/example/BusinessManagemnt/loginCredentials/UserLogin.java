package com.example.BusinessManagemnt.loginCredentials;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLogin {

    @Email
    @NotBlank
    private String userEmail;

    @NotBlank
    private String userPassword;

    // Default constructor
    public UserLogin() {}

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserLogin [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
    }
}