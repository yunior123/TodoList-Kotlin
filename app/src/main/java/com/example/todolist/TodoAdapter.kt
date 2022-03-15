package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter (
        private val todos: MutableList<TodoData>,):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()

{

   class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, attachToRoot=false)
        )
    }

    private func toggleStrikeTrough(){
        if (isChecked){
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_TROUGH_TEXT_FLAGS

        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
       val curTodo = todos[position]
        holder.itemView.apply {
            tvTodoTitle.text= curTodo.title
            cbDone.isChecked=curTodo.isChecked
            toggleStrikeTrough(tvTodoTitle,curTodo.isChecked)
            cbDone.setOnCheckedChangeListener {
                _, isChecked ->
                 
            }
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}