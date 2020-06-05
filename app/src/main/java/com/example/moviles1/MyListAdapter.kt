package com.example.moviles1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.moviles1.user.ToDo
import com.example.moviles1.viewmodel.ToDoViewModel

class MyListAdapter(
    var myDatasetTask: kotlin.collections.List<ToDo>,
    var todoViewModel: ToDoViewModel
):RecyclerView.Adapter<MyListAdapter.MyViewHolder>()

{
   class MyViewHolder(val layout: View):RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout=LayoutInflater.from(parent.context).inflate(R.layout.fragment_pestanas,parent,false )
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var txtVwItemTask =holder.layout.findViewById<TextView>(R.id.txtVwListItemTask)
        txtVwItemTask.text=myDatasetTask.get(position).title

        var txtVwItemTime =holder.layout.findViewById<TextView>(R.id.txtVwListItemTime)
        txtVwItemTime.text=myDatasetTask.get(position).time.toString()

        var txtVwItemMonth =holder.layout.findViewById<TextView>(R.id.txtVwListItemMonth)
        txtVwItemMonth.text=myDatasetTask.get(position).date.toString().substringBefore('/')

        var txtVwItemDay =holder.layout.findViewById<TextView>(R.id.txtVwListItemDay)
        txtVwItemDay.text=myDatasetTask.get(position).date.toString().substringAfter('/').substringBefore('/')

        var txtVwItemYear =holder.layout.findViewById<TextView>(R.id.txtVwListItemYear)
        txtVwItemYear.text=myDatasetTask.get(position).date.toString().substringAfter('/').substringAfter('/')

        holder.layout.setOnClickListener{
            Toast.makeText(holder.itemView.context, txtVwItemTask.text, Toast.LENGTH_SHORT).show()
        }

        holder.layout.setOnClickListener {
            todoViewModel.deleteTask(myDatasetTask.get(position))
            true
        }

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}