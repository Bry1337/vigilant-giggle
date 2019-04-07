package bry1337.github.io.navigationcomponentpoc.domain

import java.lang.IllegalStateException

/**
 * Created by edward.abergas on 06/04/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
object NotesManager {
  private val notes = mutableMapOf<Int, String>()

  fun getNoteList(): List<Note> = notes.map { Note(it.key, it.value) }

  fun getNote(id: Int): Note? = notes
      .filter { it.key == id }
      .map { Note(it.key, it.value) }
      .firstOrNull()

  fun addNote(noteText: String) {
    validateText(noteText)
    val nextId = getNextId()
    notes[nextId] = noteText
  }

  fun editNote(id: Int, noteText: String) {
    validateText(noteText)
    notes[id] = noteText
  }

  fun deleteNote(id: Int) = notes.remove(id) ?: throw IllegalStateException("Note was not removed.")

  private fun getNextId(): Int = notes.count() + 1

  private fun validateText(noteText: String) {
    require(noteText.isNotBlank()) {
      "Note text cannot be blank "
    }
  }
}