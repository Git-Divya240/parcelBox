package com.example.pracelbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chaos.view.PinView;

public class OTPverification extends AppCompatActivity {

    PinView pinView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_pverification);

        pinView = findViewById(R.id.pinView);
    }

    public PinView getPinView() {
        return pinView;
    }

    public void setPinView(PinView pinView) {
        this.pinView = pinView;
    }

    public void verify(View v){
        Intent intent = new Intent(OTPverification.this,MainActivity.class);
        startActivity(intent);
    }
}