package a23227.smartcity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class CriarNota : AppCompatActivity() {

    private lateinit var tituloText: EditText
    private lateinit var infoText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_nota)




        tituloText = findViewById(R.id.tituloText)
        infoText = findViewById(R.id.textInfo)

        val button = findViewById<Button>(R.id.btnCriar)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(tituloText.text) || TextUtils.isEmpty(infoText.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                replyIntent.putExtra(EXTRA_REPLY_TITULO, tituloText.text.toString())
                replyIntent.putExtra(EXTRA_REPLY_INFO, infoText.text.toString())
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY_TITULO = "com.example.android.city"
        const val EXTRA_REPLY_INFO = "com.example.android.country"
    }
}