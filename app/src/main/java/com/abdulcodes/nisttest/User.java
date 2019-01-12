package com.abdulcodes.nisttest;

import com.google.gson.annotations.SerializedName;

public class User {

        @SerializedName("name")
        public String name;

        @SerializedName("access_token")
        public String access_token;

        @SerializedName("purpose")
        public String purpose;

        public User(String name, String access_token) {
            this.name = name;
            this.access_token = access_token;
        }
}
