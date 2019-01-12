package com.abdulcodes.nisttest;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    @SerializedName("access_token")
    public String access_token;
    @SerializedName("name")
    public String name;
    @SerializedName("purpose")
    public String purpose;
    @SerializedName("message")
    public String message;
    @SerializedName("users")
    public List<Datum> users = new ArrayList();

    public class Datum {

        @SerializedName("access_token")
        public String access_token;
        @SerializedName("name")
        public String name;
        @SerializedName("purpose")
        public String purpose;

    }
}
