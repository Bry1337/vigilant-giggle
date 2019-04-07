package bry1337.github.io.navigationcomponentpoc.presentation.notedetail

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
class NoteDetailViewModel : ViewModel() {
    private val note = MutableLiveData<Note>()

    val observableNote: LiveData<Note>
        get() = note

    fun getNote(id: Int) {
        note.value = NotesManager.getNote(id)
    }
}