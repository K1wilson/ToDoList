package com.example.todolist


import android.annotation.SuppressLint
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodoBinding



class TodoAdapter (
    private val todos : MutableList<ToDo>



)

    :RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {
        /*  fun toggleStrikeThrough(tvTodoTitle: TextView, checked: Boolean) {

        }

        fun toggleStrikeThrough(tvTodoTitle: Int, checked: Boolean) {

        }*/


        /* val tvTodoTitle : TextView = itemView.findViewById(R.id.tvTodoTitle)
        val cbDone : CheckBox = itemView.findViewById(R.id.cbDone)*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val binding =
            ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder(binding)

    }

    fun addTodo(todo: ToDo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteDoneTodo() {
        todos.removeAll { toDo ->
            toDo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if (isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        with(holder) {
            with(todos[position]) {
                /*holder.tvTodoTitle.text= curTodo.title
                         holder.cbDone.isChecked=curTodo.isChecked*/
                /*
                          //toggleStrikeThrough(tvTodoTitle,curTodo.isChecked)
                           // holder.cbDone.setOnCheckedChangeListener { _, isChecked ->
                           //     toggleStrikeThrough(tvTodoTitle,isChecked)
                            //    curTodo.isChecked = !curTodo.isChecked
                            }    */

                binding.tvTodoTitle.text = this.title
               binding. cbDone.isChecked = this.isChecked
                toggleStrikeThrough(binding.tvTodoTitle,isChecked)
                binding.cbDone.setOnCheckedChangeListener { _, isChecked ->
                    toggleStrikeThrough(binding.tvTodoTitle, isChecked)
                    binding.cbDone.isChecked = !binding.cbDone.isChecked
                }
            }
        }
        }





        override fun getItemCount(): Int {
            return todos.size
        }
}



