package com.example.hellogaf.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "task")
public class TaskModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "estimated_hours")
    public int estimatedHours;

    @ColumnInfo(name = "worked_hours")
    public int workedHours;

    @ColumnInfo(name = "project_id")
    public int projectId;

    public TaskModel() { }

    public TaskModel(String name, String description, int estimatedHours, int workedHours, int projectId) {
        this.name = name;
        this.description = description;
        this.estimatedHours = estimatedHours;
        this.workedHours = workedHours;
        this.projectId = projectId;
    }
}
