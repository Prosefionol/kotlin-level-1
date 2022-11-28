package com.vk.homework2.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
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
    private lateinit var loadingStub: ProgressBar
    private lateinit var errorStub: TextView

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

        errorStub = view.findViewById<TextView>(R.id.errorStub)
        loadingStub = view.findViewById(R.id.loadingStub)
        errorStub.setOnClickListener { loadPicture() }
        loadPicture()

    }

    @SuppressLint("SetTextI18n")
    private fun loadPicture() {
        viewLifecycleOwner.lifecycleScope.launch {
            loadingStub.isVisible = true
            errorStub.isVisible = false
            try {
                val list = withContext(Dispatchers.IO) { viewModel.getPictures() }
                pictureAdapter.submitList(list)
            } catch (error: Throwable) {
                errorStub.isVisible = true
                errorStub.text = "Error: ${error.message}"
                error.printStackTrace()
            } finally {
                loadingStub.isVisible = false
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}