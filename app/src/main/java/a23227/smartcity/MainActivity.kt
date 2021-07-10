package a23227.smartcity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.view.SupportActionModeWrapper
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "";

        supportActionBar?.hide()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId

        when(itemView){
            R.id.ic_logout -> {
                val sharedPref: SharedPreferences = getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE)

                sharedPref.edit(){
                    putString(R.string.username.toString(), "")
                    putInt(R.string.idUser.toString(),0)
                    putBoolean(getString(R.string.RememberMe),false)
                    commit()

                }

                finish()

            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun LaunchMap(view: View){
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }






}