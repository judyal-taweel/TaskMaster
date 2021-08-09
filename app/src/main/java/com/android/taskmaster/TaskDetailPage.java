package com.android.taskmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetailPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail_page);
        Intent comingIntent = getIntent();
        TextView title = findViewById(R.id.textView7);
        String titleName = comingIntent.getExtras().getString(MainActivity.TITLE);
        title.setText(titleName);
    }
}