package com.clevertap.pooja.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.bumptech.glide.Glide;
import com.clevertap.android.sdk.CleverTapAPI;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private AppCompatImageView img;
    private Button btn;
    CleverTapAPI clevertapDefaultInstance ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        img=(AppCompatImageView)findViewById(R.id.img) ;
        btn=(Button)findViewById(R.id.btn);
        Glide.with(this).load("https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg").into(img);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clevertapDefaultInstance= CleverTapAPI.getDefaultInstance(getApplicationContext());
                // event with properties
                HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
                prodViewedAction.put("Product ID", 1);
                prodViewedAction.put("Product Name", "CleverTap");
                prodViewedAction.put("Product Image", "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg");
                prodViewedAction.put("Date", new java.util.Date());
                clevertapDefaultInstance.pushEvent("Product viewed",prodViewedAction);
                //Email Update Code
                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
//Update pre-defined profile properties
                profileUpdate.put("Name", "Pooja Singh");
                profileUpdate.put("Email", "spoo2628@gmail.com");
                profileUpdate.put("MSG-email", true);                      // Disable email notifications

                profileUpdate.put("MSG-push", true);          // Enable push notifications

//Update custom profile properties

                clevertapDefaultInstance.pushProfile(profileUpdate);


            }
        });

    }
}