package bry1337.github.io.navigationcomponentpoc.presentation.deletenote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bry1337.github.io.navigationcomponentpoc.domain.Note
import bry1337.github.io.navigationcomponentpoc.domain.NotesManager
import java.lang.IllegalArgumentException

/**
 * Created by edward.abergas on 07/04/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class DeleteNoteViewModel : ViewModel() {

    private val currentNote = MutableLiveData<Note>()

    private val deleteStatus = MutableLiveData<Boolean>()

    val observableCurrentNote: LiveData<Note>
        get() = currentNote

    val observableDeleteStatus: LiveData<Boolean>
        get() = deleteStatus

    fun deleteNote(id: Int) {
        deleteStatus.value = try {
            NotesManager.deleteNote(id)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    fun initNote(id: Int) {
        currentNote.value = NotesManager.getNote(id)
    }
}