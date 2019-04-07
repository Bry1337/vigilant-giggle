package bry1337.github.io.navigationcomponentpoc.presentation.notelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bry1337.github.io.navigationcomponentpoc.domain.Note
import bry1337.github.io.navigationcomponentpoc.domain.NotesManager

/**
 * Created by edward.abergas on 06/04/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class NoteListViewModel : ViewModel() {
  private val noteList = MutableLiveData<List<Note>>()

  val observableNotelist: LiveData<List<Note>>
    get() = noteList

  init {
    load()
  }

  fun load(){
    noteList.value = NotesManager.getNoteList()
  }
}