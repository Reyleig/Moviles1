package com.example.moviles1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.moviles1.user.ToDo
import com.example.moviles1.viewmodel.ToDoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.moviles1.MyListAdapter as MyListAdapter

class ToDoFragment :Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter:RecyclerView.Adapter<*>

    private lateinit var todoViewModel: ToDoViewModel
    var  myDatasetTask = emptyList<ToDo>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =inflater.inflate(R.layout.fragment_pestanas,container, false)
        return root
    }

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fab =activity?.findViewById<FloatingActionButton>(R.id.R1)
        fab?.setOnClickListener { view->
            val intento= Intent(activity, TaskActivity::class.java)
            startActivityForResult(intento, Constants.createTask)
        }

        todoViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)
        viewAdapter = MyListAdapter(myDatasetTask,todoViewModel)

        recyclerView=requireView().findViewById(R.id.R2)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=viewAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))

        todoViewModel.allToDoTasks.observe(viewLifecycleOwner, Observer { todoTaskUpdate ->
            val adapter: MyListAdapter = this?.view?.findViewById<RecyclerView>(R.id.R3)?.adapter as MyListAdapter
            adapter.myDatasetTask=todoTaskUpdate
            adapter.notifyDataSetChange()
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==Constants.createTask){
            if(resultCode==Activity.RESULT_OK){
                val adapter:MyListAdapter
                adapter= this?.view?.findViewById<RecyclerView>(R.id.R3)?.adapter as MyListAdapter
                val task=ToDo(0,data!!.getStringExtra(Constants.taskTitle),data!!.getStringExtra(Constants.taskDate),data!!.getStringExtra(Constants.taskTime))
                todoViewModel.insert(task)

            }
        }
    }
}