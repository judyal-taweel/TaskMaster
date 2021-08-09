package com.android.taskmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button addTaskBtn = AddTask.this.findViewById(R.id.addTaskBtn);
        addTaskBtn.setOnClickListener(v -> {
            EditText taskTitle = AddTask.this.findViewById(R.id.task_title_input);
            EditText taskDesc = AddTask.this.findViewById(R.id.task_desc);
            if (!taskTitle.getText().toString().equals("") && !taskDesc.getText().toString().equals("")) {
                Toast.makeText(AddTask.this, "Submitted!!", Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(AddTask.this, "Please fill the form", Toast.LENGTH_LONG).show();
            }
        });
    }
}