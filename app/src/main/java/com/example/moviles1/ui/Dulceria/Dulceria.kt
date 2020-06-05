package com.example.moviles1.ui.Dulceria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.example.moviles1.R

class Dulceria : Fragment() {

    companion object {
        fun newInstance() = Dulceria()
    }

    private lateinit var viewModel: DulceriaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dulceria_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DulceriaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
