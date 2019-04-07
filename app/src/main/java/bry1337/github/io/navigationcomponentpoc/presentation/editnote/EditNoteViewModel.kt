package bry1337.github.io.navigationcomponentpoc.presentation.editnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bry1337.github.io.navigationcomponentpoc.domain.Note
import bry1337.github.io.navigationcomponentpoc.domain.NotesManager

/**
 * Created by edward.abergas on 07/04/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class EditNoteViewModel : ViewModel() {
    private val currentNote = MutableLiveData<Note>()

    private val editStatus = MutableLiveData<Boolean>()

    val observableCurrentNote: LiveData<Note>
        get() = currentNote

    val observableEditStatus: LiveData<Boolean>
        get() = editStatus

    fun editNote(id: Int, noteText: String) {
        editStatus.value = try {
            NotesManager.editNote(id, noteText)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    fun initNote(id: Int) {
        currentNote.value = NotesManager.getNote(id)
    }
}