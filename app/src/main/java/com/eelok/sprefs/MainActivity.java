package com.eelok.sprefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.eelok.sprefs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding viewBinding;
private final String MESSAGE_ID = "Message_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        viewBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMessage = viewBinding.messageEditText.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userMessage", userMessage);
                editor.apply();
            }
        });

//retrieve data
        SharedPreferences getSharedPrefs = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
        String value = getSharedPrefs.getString("userMessage", "nothing yet");

        viewBinding.showMessageTextview.setText(value);

    }
}