package com.vk.homework2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vk.homework2.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    private val pictureAdapter = PictureAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = pictureAdapter
        }

        val stub = view.findViewById<TextView>(R.id.stub)

        viewLifecycleOwner.lifecycleScope.launch {
            stub.isVisible = true
            stub.text = "Loading..."
            // stub.setOnClickListener(null)
            delay(1000)

            try {
                val list = withContext(Dispatchers.IO) { viewModel.getPictures() }
                pictureAdapter.submitList(list)
                stub.isVisible = false
            } catch (error: Throwable) {
                stub.isVisible = true
                stub.text = "Error: ${error.message}"
                error.printStackTrace()
                // stub.setOnClickListener {  }
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}