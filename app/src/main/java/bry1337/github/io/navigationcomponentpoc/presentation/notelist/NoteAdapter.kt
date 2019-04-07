package bry1337.github.io.navigationcomponentpoc.presentation.notelist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView
import bry1337.github.io.navigationcomponentpoc.R
import bry1337.github.io.navigationcomponentpoc.domain.Note

/**
 * Created by edward.abergas on 25/03/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */

typealias ClickListener = (Note) -> Unit

class NoteAdapter(private val clickListener: ClickListener) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private var noteList = emptyList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemContainer = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false) as ViewGroup
        val viewHolder = ViewHolder(itemContainer)
        itemContainer.setOnClickListener {
            clickListener(noteList[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = noteList[position]
        holder.id.text = note.id.toString()
        holder.text.text = note.text
    }

    override fun getItemCount(): Int = noteList.size

    fun updateNotes(noteList: List<Note>){
        val diffResult = calculateDiff(NoteDiffCallback(this.noteList, noteList))
        this.noteList = noteList
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(itemViewGroup: ViewGroup) : RecyclerView.ViewHolder(itemViewGroup) {
        val id: TextView = itemViewGroup.findViewById(R.id.noteId)
        val text: TextView = itemViewGroup.findViewById(R.id.noteText)
    }
}