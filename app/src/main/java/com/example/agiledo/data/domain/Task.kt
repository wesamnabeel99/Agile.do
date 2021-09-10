package com.example.agiledo.data.domain

data class Task(
    val taskName:String,
    val taskDescription: String,
    val taskStartDate: String,
    val taskDueDate: String,
    val taskAssignedTo: String,
    val state: String
)
