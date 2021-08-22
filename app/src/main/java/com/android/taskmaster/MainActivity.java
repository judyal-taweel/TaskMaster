package com.android.taskmaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Team;
import com.amplifyframework.datastore.generated.model.Todo;


import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ViewAdapter viewAdapter;
    private List<TaskItem> taskList;
    private List<com.amplifyframework.datastore.generated.model.TaskItem> commingList= TaskManager.getInstance().getData();

    public static final String TITLE = "title";
    public static final String BODY = "body";
    public static final String STATE = "state";
    public static final String TEAM = "team";
    Handler handler;
    RecyclerView taskRecycleView;
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

        handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                Objects.requireNonNull(taskRecycleView.getAdapter()).notifyDataSetChanged();
                return false;
            }
        });


        try {
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.configure(getApplicationContext());
            Log.i("Tutorial", "Initialized Amplify");
        } catch (AmplifyException failure) {
            Log.e("Tutorial", "Could not initialize Amplify", failure);
        }


//        AppDB db = Room.databaseBuilder(getApplicationContext(),
//                AppDB.class, AddTask.TASK).allowMainThreadQueries().build();

//        TaskDao taskDao = db.taskDao();
//        taskList = taskDao.findAll();

        getTasksFromAPI();
//        commingList.add(new com.amplifyframework.datastore.generated.model.TaskItem("12","title A","body A","new",new Team("1","team A")));
//        commingList.add(new com.amplifyframework.datastore.generated.model.TaskItem("12","title A","body A","new",new Team("1","team A")));
//        commingList.add(new com.amplifyframework.datastore.generated.model.TaskItem("12","title A","body A","new",new Team("1","team A")));

         taskRecycleView = findViewById(R.id.list);
//        Matcher<View> strings = withId(R.id.list);
        String strings = taskRecycleView.toString();
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmm"+strings);
        Log.i("MM", "onCreate: "+strings);
        viewAdapter = new ViewAdapter(commingList, new ViewAdapter.OnTaskItemClickListener() {
            @Override
            public void onTaskClicked(int position) {
                Intent detailsPage = new Intent(getApplicationContext(), TaskDetailPage.class);
                detailsPage.putExtra(TITLE,commingList.get(position).getTitle());
                detailsPage.putExtra(BODY,commingList.get(position).getBody());
                detailsPage.putExtra(STATE,commingList.get(position).getState());
                detailsPage.putExtra(TEAM,commingList.get(position).getTeam().getName());
                startActivity(detailsPage);

            }
        });
        ImageButton menuBtn = findViewById(R.id.imageButton);
        menuBtn.setOnClickListener(v -> {
            Intent menuIntent = new Intent(MainActivity.this,SettingPage.class);
            startActivity(menuIntent);
        });
        Button allTaskBtn = MainActivity.this.findViewById(R.id.allTaskBtn);
        allTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllTask.class);
                MainActivity.this.startActivity(intent);
            }
        });
        Button addTaskBtn = MainActivity.this.findViewById(R.id.addBtn);
        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddTask.class);
                MainActivity.this.startActivity(intent);
            }
        });




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false);

        taskRecycleView.setLayoutManager(linearLayoutManager);
        taskRecycleView.setAdapter(viewAdapter);
    }

    private void dataSetChanged(){viewAdapter.notifyDataSetChanged();}

    private void getTasksFromAPI(){
        Amplify.API.query(ModelQuery.list(com.amplifyframework.datastore.generated.model.TaskItem.class),
                response ->{

                    for(com.amplifyframework.datastore.generated.model.TaskItem item : response.getData()){
                        commingList.add(item);
                        Log.i("coming","on create : ------------ =>"+item.getTitle());
                    }
                    handler.sendEmptyMessage(1);
                },
                error -> Log.e("error","onCreate faild"+error.toString())
        );
    }

}
