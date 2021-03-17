package ir.adicom.app.beginneridea.noteapp.adapter

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.databinding.NoteLayoutAdapterBinding
import ir.adicom.app.beginneridea.noteapp.fragments.HomeFragmentDirections
import ir.adicom.app.beginneridea.noteapp.model.Note

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var binding: NoteLayoutAdapterBinding? = null

    class NoteViewHolder(itemView: NoteLayoutAdapterBinding) : RecyclerView.ViewHolder(itemView.root) {}

    private val differCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        binding = NoteLayoutAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return NoteViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]

        holder.itemView.apply {
            binding?.tvNoteTitle?.text = currentNote.noteTitle
            binding?.tvNoteBody?.text = currentNote.noteBody

            binding?.tvNoteTitle?.setOnClickListener {
                val directions = HomeFragmentDirections.actionHomeFragmentToUpdateNoteFragment(currentNote)
                it.findNavController().navigate(directions)
            }
        }
    }

}