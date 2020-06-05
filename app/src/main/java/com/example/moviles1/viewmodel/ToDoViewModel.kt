package com.example.moviles1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.moviles1.repository.ToDoRepository
import com.example.moviles1.user.ToDo
import kotlinx.coroutines.Dispatchers
import java.util.List

class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ToDoRepository = ToDoRepository(application, viewModelScope)
    val allToDoTasks: LiveData<List<ToDo>>

    init {
        allToDoTasks=repository.allToDoTasks
    }

    fun insert(toDo: ToDo){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(toDo)
        }
    }
    fun deleteTask(toDo: ToDo){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteTask(toDo)
        }
    }




}