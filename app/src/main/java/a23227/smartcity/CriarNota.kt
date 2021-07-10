package a23227.smartcity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_visualizar_nota.*

class CriarNota : AppCompatActivity() {

    private lateinit var tituloText: EditText
    private lateinit var infoText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_nota)

        supportActionBar?.hide()




        tituloText = findViewById(R.id.tituloText)
        infoText = findViewById(R.id.textInfo)



            val button = findViewById<Button>(R.id.btnCriar)
            button.setOnClickListener {
                val replyIntent = Intent()

                if (TextUtils.isEmpty(tituloText.text) || TextUtils.isEmpty(infoText.text)) {
                    setResult(Activity.RESULT_CANCELED, replyIntent)
                    Toast.makeText(applicationContext,R.string.createProblem, Toast.LENGTH_LONG).show()
                } else {
                    replyIntent.putExtra(EXTRA_REPLY_TITULO, tituloText.text.toString())
                    replyIntent.putExtra(EXTRA_REPLY_INFO, infoText.text.toString())
                    setResult(Activity.RESULT_OK, replyIntent)
                }
                finish()
            }






    }

    companion object {
        const val EXTRA_REPLY_TITULO = "Titulo"
        const val EXTRA_REPLY_INFO = "Info"
    }

    fun close(view: View) {
        finish()
    }


}