package com.android.taskmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class AllTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_task);

        Button backBtn = AllTask.this.findViewById(R.id.bkBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AllTask.this,MainActivity.class);
            AllTask.this.startActivity(intent);

        });
    }
}