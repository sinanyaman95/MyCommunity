package com.humber.saynn.mycommunity;

import android.app.Application;

import com.humber.saynn.mycommunity.database.FirebaseDb;

public class GlobalApplication extends Application {
    public String userEmail = "";

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = FirebaseDb.getEmailAddress(userEmail);
    }
}
