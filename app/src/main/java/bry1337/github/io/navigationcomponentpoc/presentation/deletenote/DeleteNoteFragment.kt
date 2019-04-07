package bry1337.github.io.navigationcomponentpoc.presentation.deletenote

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
import bry1337.github.io.navigationcomponentpoc.presentation.deletenote.DeleteNoteFragmentArgs.fromBundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.delete_note_fragment.*

/**
 * Created by edward.abergas on 07/04/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class DeleteNoteFragment : Fragment() {

    private lateinit var viewModel: DeleteNoteViewModel

    private val noteId by lazy { fromBundle(arguments!!).noteId }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.delete_note_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DeleteNoteViewModel::class.java)
        viewModel.observableCurrentNote.observe(
            this,
            Observer { currentNote -> currentNote?.let { initCurrentNote(currentNote) } })
        viewModel.observableDeleteStatus.observe(
            this,
            Observer { deleteStatus -> deleteStatus?.let { render(deleteStatus) } })

        viewModel.initNote(noteId)

        cancelDeleteButton.setOnClickListener { findNavController(it).popBackStack() }

        confirmDeleteButton.setOnClickListener { viewModel.deleteNote(noteId) }
    }

    private fun initCurrentNote(note: Note) {
        noteIdView.text = String.format(getString(R.string.note_detail_id), note.id)
        noteText.text = String.format(getString(R.string.note_detail_text), note.text)
    }

    private fun render(deleteStatus: Boolean) {
        when (deleteStatus) {
            true -> {
                view?.let {
                    findNavController(it).popBackStack(R.id.notesFragment, false)
                }
            }
            false -> Snackbar.make(confirmDeleteButton, R.string.error_deleting_note, Snackbar.LENGTH_LONG).show()
        }
    }
}