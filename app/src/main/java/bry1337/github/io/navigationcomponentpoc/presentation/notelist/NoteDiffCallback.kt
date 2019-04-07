package bry1337.github.io.navigationcomponentpoc.presentation.notelist

import androidx.recyclerview.widget.DiffUtil
import bry1337.github.io.navigationcomponentpoc.domain.Note

/**
 * Created by edward.abergas on 06/04/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class NoteDiffCallback(private val old: List<Note>,
    private val new: List<Note>) : DiffUtil.Callback() {
  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return old[oldItemPosition].text == new[newItemPosition].text
  }

  override fun getOldListSize(): Int = old.size

  override fun getNewListSize(): Int = new.size

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return old[oldItemPosition] == new[newItemPosition]
  }

}