package com.arlitin.roomsqlviewmodel.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.arlitin.roomsqlviewmodel.APP
import com.arlitin.roomsqlviewmodel.R
import com.arlitin.roomsqlviewmodel.adapter.NoteAdapter
import com.arlitin.roomsqlviewmodel.databinding.FragmentStartBinding
import com.arlitin.roomsqlviewmodel.model.NoteModel

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)
            .get(StartViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvNotes
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->
            adapter.setList(listNotes.asReversed())
        }
        binding.btnNext.setOnClickListener{
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }

    companion object{
        fun clickNote(noteModel: NoteModel){
            val bundle = Bundle()
            bundle.putSerializable("note", noteModel)
            APP.navController.navigate(
                R.id.action_startFragment_to_detailFragment,
                bundle
            )
        }
    }

}