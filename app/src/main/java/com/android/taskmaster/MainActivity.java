package com.android.taskmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewAdapter viewAdapter;
    private List<TaskItem> taskList;

    public static final String TITLE = "title";
    public static final String BODY = "body";
    public static final String STATE = "state";
    @Override
    protected void onResume (){
        super.onResume();
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        String username = sharedPreferences.getString("Username","go set your info in setting !!");
//        TextView usernameView = findViewById(R.id.Username_main);
//        usernameView.setText(username);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView taskRecycleView= findViewById(R.id.list);


        taskList = new ArrayList<>();
        taskList.add(new TaskItem("Task A","Body A","New"));
        taskList.add(new TaskItem("Task B","Body B"," In Progres"));
        taskList.add(new TaskItem("Task C","Body C","Assign"));
        taskList.add(new TaskItem("Task D","Body D","Completed"));
        taskList.add(new TaskItem("Task E","Body E","New"));
        taskList.add(new TaskItem("Task F","Body F"," In Progres"));
        taskList.add(new TaskItem("Task I","Body I","New"));
        taskList.add(new TaskItem("Task J","Body J","Assign"));
        taskList.add(new TaskItem("Task K","Body K","Completed"));
        taskList.add(new TaskItem("Task L","Body L"," In Progres"));
        taskList.add(new TaskItem("Task M","Body M","New"));

       viewAdapter = new ViewAdapter(taskList, new ViewAdapter.OnTaskItemClickListener() {
           @Override
           public void onTaskClicked(int position) {
               Intent detailsPage= new Intent(getApplicationContext(),TaskDetailPage.class);
               detailsPage.putExtra(TITLE , taskList.get(position).getTitle());
               detailsPage.putExtra(BODY , taskList.get(position).getBody());
               detailsPage.putExtra(STATE , taskList.get(position).getState());
               startActivity(detailsPage);

           }
       });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false);

        taskRecycleView.setLayoutManager(linearLayoutManager);
        taskRecycleView.setAdapter(viewAdapter);
    }





//        Button addTaskBtn = MainActivity.this.findViewById(R.id.addBtn);
//        addTaskBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,AddTask.class);
//                MainActivity.this.startActivity(intent);
//            }
//        });
//        Button allTaskBtn = MainActivity.this.findViewById(R.id.allTaskBtn);
//        allTaskBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,AllTask.class);
//                MainActivity.this.startActivity(intent);
//            }
//        });
//        Button titleA = MainActivity.this.findViewById(R.id.title_a);
//        titleA.setOnClickListener(v -> {
//            String title_a = (String) ((Button) findViewById(R.id.title_a)).getText().toString();
//            Intent titleIntent = new Intent(MainActivity.this,TaskDetailPage.class);
//            titleIntent.putExtra(TITLE,title_a);
//            startActivity(titleIntent);
//        });
//        Button titleB = MainActivity.this.findViewById(R.id.title_b);
//        titleB.setOnClickListener(v -> {
//            String title_b = (String) ((Button) findViewById(R.id.title_b)).getText().toString();
//            Intent titleIntent = new Intent(MainActivity.this,TaskDetailPage.class);
//            titleIntent.putExtra(TITLE,title_b);
//            startActivity(titleIntent);
//        });
//        Button titleC = MainActivity.this.findViewById(R.id.title_c);
//        titleC.setOnClickListener(v -> {
//            String title_c = (String) ((Button) findViewById(R.id.title_c)).getText().toString();
//            Intent titleIntent = new Intent(MainActivity.this,TaskDetailPage.class);
//            titleIntent.putExtra(TITLE,title_c);
//            startActivity(titleIntent);
//        });
//        ImageButton menuBtn = findViewById(R.id.imageButton);
//        menuBtn.setOnClickListener(v -> {
//            Intent menuIntent = new Intent(MainActivity.this,SettingPage.class);
//            startActivity(menuIntent);
//        });


    }

