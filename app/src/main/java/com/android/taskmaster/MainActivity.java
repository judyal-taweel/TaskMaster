package com.android.taskmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TITLE = "title";
    @Override
    protected void onResume (){
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPreferences.getString("Username","go set your info in setting !!");
        TextView usernameView = findViewById(R.id.Username_main);
        usernameView.setText(username);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addTaskBtn = MainActivity.this.findViewById(R.id.addBtn);
        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddTask.class);
                MainActivity.this.startActivity(intent);
            }
        });
        Button allTaskBtn = MainActivity.this.findViewById(R.id.allTaskBtn);
        allTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllTask.class);
                MainActivity.this.startActivity(intent);
            }
        });
        Button titleA = MainActivity.this.findViewById(R.id.title_a);
        titleA.setOnClickListener(v -> {
            String title_a = (String) ((Button) findViewById(R.id.title_a)).getText().toString();
            Intent titleIntent = new Intent(MainActivity.this,TaskDetailPage.class);
            titleIntent.putExtra(TITLE,title_a);
            startActivity(titleIntent);
        });
        Button titleB = MainActivity.this.findViewById(R.id.title_b);
        titleB.setOnClickListener(v -> {
            String title_b = (String) ((Button) findViewById(R.id.title_b)).getText().toString();
            Intent titleIntent = new Intent(MainActivity.this,TaskDetailPage.class);
            titleIntent.putExtra(TITLE,title_b);
            startActivity(titleIntent);
        });
        Button titleC = MainActivity.this.findViewById(R.id.title_c);
        titleC.setOnClickListener(v -> {
            String title_c = (String) ((Button) findViewById(R.id.title_c)).getText().toString();
            Intent titleIntent = new Intent(MainActivity.this,TaskDetailPage.class);
            titleIntent.putExtra(TITLE,title_c);
            startActivity(titleIntent);
        });
        ImageButton menuBtn = findViewById(R.id.imageButton);
        menuBtn.setOnClickListener(v -> {
            Intent menuIntent = new Intent(MainActivity.this,SettingPage.class);
            startActivity(menuIntent);
        });


    }

}