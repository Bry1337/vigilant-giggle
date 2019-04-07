package bry1337.github.io.navigationcomponentpoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by edward.abergas on 25/03/2019.
 *
 * @author edwardbryan.abergas@gmail.com
 */
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)
    setupNavigation()
  }

  override fun onSupportNavigateUp(): Boolean {
    return navigateUp(findNavController(R.id.nav_host_fragment), drawerLayout)
  }

  override fun onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }

  private fun setupNavigation() {
    val navController = findNavController(R.id.nav_host_fragment)

    // Update action bar to reflect navigation
    setupActionBarWithNavController(this, navController, drawerLayout)

    // Handle nav drawer item clicks
    navigationView.setNavigationItemSelectedListener { menuItem ->
      menuItem.isChecked = true
      drawerLayout.closeDrawers()
      true
    }

    // Tie nav graph to items in nav drawer
    setupWithNavController(navigationView, navController)
  }
}