package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter

    private  var _binding : ActivityMainBinding ? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root )
        todoAdapter= TodoAdapter(mutableListOf())
        val layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvTodoItems.layoutManager = layoutManager
       /* rvTodoItems= findViewById(R.id.rvTodoItems)*/

        binding.rvTodoItems.adapter = todoAdapter

        binding.btnAddTodo.setOnClickListener{
            val todoTitle = binding.etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = ToDo(todoTitle)
                todoAdapter.addTodo(todo)
              binding.etTodoTitle.text.clear()
            }
        }
       binding. btndeleteTodo.setOnClickListener {
            todoAdapter.deleteDoneTodo()

        }
    }
}