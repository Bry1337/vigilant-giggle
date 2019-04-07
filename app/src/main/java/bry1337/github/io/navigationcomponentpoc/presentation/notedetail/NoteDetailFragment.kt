package bry1337.github.io.navigationcomponentpoc.presentation.notedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import bry1337.github.io.navigationcomponentpoc.R
import bry1337.github.io.navigationcomponentpoc.domain.Note
import bry1337.github.io.navigationcomponentpoc.presentation.notedetail.NoteDetailFragmentArgs.fromBundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.note_detail_fragment.*

/**
 * Created by edward.abergas on 07/04/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class NoteDetailFragment : Fragment() {

    private lateinit var viewModel: NoteDetailViewModel

    private val noteId by lazy { fromBundle(arguments!!).noteId }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.note_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NoteDetailViewModel::class.java)
        viewModel.observableNote.observe(this, Observer { note -> note?.let { render(note) } ?: renderNoteNotFound() })

        editNoteButton.setOnClickListener {
            val navDirections = NoteDetailFragmentDirections.actionNoteDetailToEditNote(noteId)
            findNavController(it).navigate(navDirections)
        }

        deleteNoteButton.setOnClickListener {
            val navDirections = NoteDetailFragmentDirections.actionNoteDetailToDeleteNote(noteId)
            findNavController(it).navigate(navDirections)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNote(noteId)
    }

    private fun render(note: Note) {
        noteIdView.text = String.format(getString(R.string.note_detail_id), note.id)
        noteText.text = String.format(getString(R.string.note_detail_text), note.text)
    }

    private fun renderNoteNotFound() {
        noteIdView.visibility = View.GONE
        noteText.visibility = View.GONE
        view?.let { Snackbar.make(it, R.string.error_loading_note, Snackbar.LENGTH_LONG).show() }
    }
}