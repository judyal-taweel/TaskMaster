package com.android.taskmaster;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetailPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail_page);
        Intent comingIntent = getIntent();
        TextView title = findViewById(R.id.textView7);
        TextView body = findViewById(R.id.lorem_ipsum);
        TextView state = findViewById(R.id.state);
        String titleName = comingIntent.getExtras().getString(MainActivity.TITLE);
        String bodytask = comingIntent.getExtras().getString(MainActivity.BODY);
        String statetask = comingIntent.getExtras().getString(MainActivity.STATE);
        title.setText(titleName);
        body.setText(bodytask);
        state.setText(statetask);
    }
}