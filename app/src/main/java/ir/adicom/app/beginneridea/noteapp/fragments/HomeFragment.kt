package ir.adicom.app.beginneridea.noteapp.fragments

import android.opengl.Visibility
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.databinding.FragmentHomeBinding
import ir.adicom.app.beginneridea.noteapp.NoteAppMainActivity
import ir.adicom.app.beginneridea.noteapp.adapter.NoteAdapter
import ir.adicom.app.beginneridea.noteapp.model.Note
import ir.adicom.app.beginneridea.noteapp.viewmodel.NoteViewModel

class HomeFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener {

    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!
    lateinit var noteAdapter: NoteAdapter
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteViewModel = (activity as NoteAppMainActivity).noteViewModel

        setUpRecycleView()

        binding.fabNoteApp.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_newNoteFragment)
        }
    }

    fun setUpRecycleView() {
        noteAdapter = NoteAdapter()

        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = noteAdapter
        }

        activity?.let {
            noteViewModel.getAllNotes().observe(viewLifecycleOwner, Observer {
                noteAdapter.differ.submitList(it)

                updateUi(it)
            })
        }
    }

    private fun updateUi(notes: List<Note>) {
        if (notes.isNotEmpty()) {
            binding.recyclerView.visibility = View.VISIBLE
            binding.tvNoNotesAvailable.visibility = View.GONE
        } else {
            binding.recyclerView.visibility = View.GONE
            binding.tvNoNotesAvailable.visibility = View.VISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.home_menu, menu)

        val mMenuSearch = menu.findItem(R.id.app_bar_search).actionView as SearchView
        mMenuSearch.isSubmitButtonEnabled = true
        mMenuSearch.setOnQueryTextListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchNotes(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if (query != null) {
            searchNotes(query)
        }
        return true
    }

    private fun searchNotes(query: String?) {
        val searchQuery = "%$query%"
        noteViewModel.searchNote(searchQuery).observe(this, Observer {
            noteAdapter.differ.submitList(it)
        })
    }
}