package com.abdulcodes.nisttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);


        /**
         GET List Users
         **/
        Call<UserList> call2 = apiInterface.doGetUserList();
        call2.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {

                UserList userList = response.body();
                Log.e("Response",">>>>>"+ userList.toString());
                String access_token = userList.access_token;
                String message = userList.message;
                String name = userList.name;
                String purpose = userList.purpose;
                List<UserList.Datum> datumList = userList.users;
                Toast.makeText(getApplicationContext(), access_token + " access_token\n" + message + " message\n" + name + " name\n"+ purpose + "purpose\n", Toast.LENGTH_SHORT).show();

                for (UserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "access_token : " + datum.access_token + " name: " + datum.name + " purpose: " + datum.purpose, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });

    }
}