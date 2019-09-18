package com.example.hellogaf.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hellogaf.R;
import com.example.hellogaf.helpers.DataStorageHelper;
import com.example.hellogaf.models.ProjectAndAllTasksModel;
import com.example.hellogaf.models.ProjectModel;
import com.example.hellogaf.models.RoomDB;
import com.example.hellogaf.models.TaskModel;

import java.io.DataInputStream;

public class DataStorageActivity extends AppCompatActivity {
    Button mSavePrefs;
    Button mReadPrefs;
    EditText mEmail;
    Button mReadFile;
    Button mWriteFile;
    Button mPopulateDb;
    Button mReadDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSavePrefs = findViewById(R.id.shared_prefs_save_btn);
        mReadPrefs = findViewById(R.id.shared_prefs_read_btn);
        mEmail = findViewById(R.id.data_storage_email);
        mReadFile = findViewById(R.id.read_file_btn);
        mWriteFile = findViewById(R.id.write_file_btn);
        mPopulateDb = findViewById(R.id.populate_db_btn);
        mReadDb = findViewById(R.id.read_from_db_btn);

        mSavePrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                DataStorageHelper.saveValueInSharedPrefs(DataStorageActivity.this, "email", email);
            }
        });

        mReadPrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = DataStorageHelper.readValueFromSharedPrefs(DataStorageActivity.this, "email");
                Toast.makeText(DataStorageActivity.this, email, Toast.LENGTH_SHORT).show();
            }
        });

        mWriteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                DataStorageHelper.writeToFile(DataStorageActivity.this, "files.txt", email);
            }
        });

        mReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = DataStorageHelper.readFromFile(DataStorageActivity.this, "files.txt");
                Toast.makeText(DataStorageActivity.this, email, Toast.LENGTH_SHORT).show();
            }
        });

        mPopulateDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProjectModel project = new ProjectModel("Project One", "About Project 1", 500);
                TaskModel task1 = new TaskModel("Create Project", "Boilerplate", 2, 0, 1);
                TaskModel task2 = new TaskModel("Build Project", "Gradle", 6, 0, 1);
                RoomDB dbInstance = RoomDB.getInstance(DataStorageActivity.this);
                dbInstance.insertProject(project);
                dbInstance.insertTask(task1);
                dbInstance.insertTask(task2);
            }
        });

        mReadDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomDB dbInstance = RoomDB.getInstance(DataStorageActivity.this);
                ProjectAndAllTasksModel project = dbInstance.loadProject(1);
                Log.d("ROOM", "Project name: " + project.project.name);
                Log.d("ROOM", "Project description: " + project.project.description);
                Log.d("ROOM", "Project estimated hours: " + project.project.estimatedHours);

                Log.d("ROOM", "Task 1 name: " + project.tasks.get(0).name);
                Log.d("ROOM", "Task 1 description: " + project.tasks.get(0).description);
                Log.d("ROOM", "Task 1 estimated hours: " + project.tasks.get(0).estimatedHours);

                Log.d("ROOM", "Task 2 name: " + project.tasks.get(1).name);
                Log.d("ROOM", "Task 2 description: " + project.tasks.get(1).description);
                Log.d("ROOM", "Task 2 estimated hours: " + project.tasks.get(1).estimatedHours);
            }
        });
    }
}
