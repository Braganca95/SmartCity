
package a23227.smartcity

import a23227.smartcity.api.EndPoints
import a23227.smartcity.api.ServiceBuilder
import a23227.smartcity.api.User
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_inicio.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val sharedPref: SharedPreferences = getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        val loginCheck = sharedPref.getBoolean(getString(R.string.RememberMe),false)
        val checkString = sharedPref.getString(R.string.username.toString(),"Sidonio")
        Log.d("IDIDID",checkString.toString())

        if (loginCheck) {
            val intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this@Inicio, getString(R.string.LoginSuccess), Toast.LENGTH_LONG).show()
            startActivity(intent)
            finish()

        }


    }



    fun btnLogin(view: View) {
        val sharedPref: SharedPreferences = getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val username = findViewById<EditText>(R.id.usernameEditLogin).text.toString()
        val password = findViewById<EditText>(R.id.passwordEditLogin).text.toString()
        val intent = Intent(this, MainActivity::class.java)

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {


            Toast.makeText(applicationContext,R.string.createProblem, Toast.LENGTH_LONG).show()
        } else {

            val request = ServiceBuilder.buildService(EndPoints::class.java)
            val call = request.login(username, password);
                call.enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        Toast.makeText(this@Inicio, getString(R.string.deleteNoteMessage), Toast.LENGTH_LONG).show()
                        if (response.isSuccessful){
                            if(response.body()!!.status){
                                with(sharedPref.edit()) {
                                    putString(R.string.username.toString(), username)
                                    val id = response.body()!!.id
                                    putInt(R.string.idUser.toString(),id)
                                    putBoolean(getString(R.string.RememberMe),checkBoxRememberMe.isChecked)
                                    commit()
                                }
                                Toast.makeText(this@Inicio, getString(R.string.LoginSuccess), Toast.LENGTH_LONG).show()
                                val user = sharedPref.getString(R.string.username.toString(), "Ola")
                                Log.d("IDIDID",username)
                                Log.d("IDIDID222",user.toString())

                                startActivity(intent)
                            }else{
                                Toast.makeText(this@Inicio, getString(R.string.LoginFailure), Toast.LENGTH_LONG).show()
                            }

                        }
                    }
                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Toast.makeText(this@Inicio, "${t.message}", Toast.LENGTH_LONG).show()
                    }
                })



        }




    }

    fun btnNotas(view: View) {
        val intent = Intent(this, Notas::class.java)
        startActivity(intent)
    }





}