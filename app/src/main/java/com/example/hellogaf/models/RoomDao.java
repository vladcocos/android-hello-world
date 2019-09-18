package com.example.hellogaf.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface RoomDao {
    @Query("SELECT * FROM project")
    List<ProjectModel> getAllProjects();

    @Query("SELECT * FROM task")
    List<TaskModel> getAllTasks();

    @Insert
    void insertProject(ProjectModel project);

    @Insert
    void insertTask(TaskModel task);

    @Update
    void updateProject(ProjectModel project);

    @Update
    void updateTask(TaskModel task);

    @Delete
    void deleteProject(ProjectModel project);

    @Delete
    void deleteTask(TaskModel project);

    @Transaction
    @Query("SELECT * FROM project WHERE id = :project_id")
    ProjectAndAllTasksModel loadProjectAndAllTasks(int project_id);
}
