package com.arlitin.roomsqlviewmodel.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.arlitin.roomsqlviewmodel.APP
import com.arlitin.roomsqlviewmodel.R
import com.arlitin.roomsqlviewmodel.databinding.FragmentDetailBinding
import com.arlitin.roomsqlviewmodel.model.NoteModel


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var currentNode: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNode = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)
            .get(DetailViewModel::class.java)
        binding.tvTitleDetail.text = currentNode.title
        binding.tvDescDetail.text = currentNode.desc

        binding.btnDelete.setOnClickListener {
            viewModel.delete(currentNode){}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
    }
}