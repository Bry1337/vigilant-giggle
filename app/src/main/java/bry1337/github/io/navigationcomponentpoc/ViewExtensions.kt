package bry1337.github.io.navigationcomponentpoc

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Created by edward.abergas on 06/04/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
fun View.closeSoftKeyboard() {
  val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
  imm.hideSoftInputFromWindow(this.windowToken, 0)
}