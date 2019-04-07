package bry1337.github.io.navigationcomponentpoc.presentation.editnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import bry1337.github.io.navigationcomponentpoc.R
import bry1337.github.io.navigationcomponentpoc.closeSoftKeyboard
import bry1337.github.io.navigationcomponentpoc.domain.Note
import bry1337.github.io.navigationcomponentpoc.presentation.editnote.EditNoteFragmentArgs.fromBundle
import kotlinx.android.synthetic.main.edit_note_fragment.*

/**
 * Created by edward.abergas on 07/04/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class EditNoteFragment : Fragment() {

    private lateinit var viewModel: EditNoteViewModel

    private val noteId by lazy { fromBundle(arguments!!).noteId }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.edit_note_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EditNoteViewModel::class.java)
        viewModel.observableCurrentNote.observe(
            this,
            Observer { currentNote -> currentNote?.let { initCurrentNote(currentNote) } })
        viewModel.observableEditStatus.observe(this, Observer { editStatus -> editStatus?.let { render(editStatus) } })

        viewModel.initNote(noteId)
        setupEditNoteSubmitHandling()
    }

    private fun initCurrentNote(note: Note) {
        editNoteText.setText(note.text)
    }

    private fun render(editStatus: Boolean) {
        when (editStatus) {
            true -> {
                view?.let {
                    findNavController(it).popBackStack()
                }
            }
            false -> editNoteText.error = getString(R.string.error_validating_note)
        }
    }

    private fun setupEditNoteSubmitHandling() {
        editNoteText.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val args = fromBundle(arguments!!)
                viewModel.editNote(noteId, v.text.toString())
                v.closeSoftKeyboard()
                true
            } else {
                false
            }
        }
    }
}