package com.android.taskmaster;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        Button saveBtn = findViewById(R.id.save_username_btn);
        saveBtn.setOnClickListener(v -> {
            String username = ((EditText)findViewById(R.id.username_edit_txt)).getText().toString();

            prefEditor.putString("Username",username);
            prefEditor.apply();
            Toast.makeText(SettingPage.this,"username updated",Toast.LENGTH_LONG).show();
        });
    }
}