package bry1337.github.io.navigationcomponentpoc.presentation.addnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bry1337.github.io.navigationcomponentpoc.domain.NotesManager
import java.lang.IllegalArgumentException

/**
 * Created by edward.abergas on 07/04/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class AddNoteViewModel : ViewModel() {

    private val status = MutableLiveData<Boolean>()

    val observableStatus: LiveData<Boolean>
        get() = status

    fun addNote(noteText: String) {
        status.value = try {
            NotesManager.addNote(noteText)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }
}