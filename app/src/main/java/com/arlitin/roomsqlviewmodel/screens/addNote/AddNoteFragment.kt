package com.arlitin.roomsqlviewmodel.screens.addNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.arlitin.roomsqlviewmodel.APP
import com.arlitin.roomsqlviewmodel.R
import com.arlitin.roomsqlviewmodel.databinding.FragmentAddNoteBinding
import com.arlitin.roomsqlviewmodel.model.NoteModel

class AddNoteFragment : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)
            .get(AddNoteViewModel::class.java)
        binding.btnAddNote.setOnClickListener{
            val title = binding.edAddTitle.text.toString()
            val desc = binding.edAddDesc.text.toString()
            viewModel.insert(NoteModel(title = title, desc = desc)){}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }

}