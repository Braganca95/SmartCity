package a23227.smartcity

import a23227.smartcity.ViewModel.NotasViewModel
import a23227.smartcity.adapters.NotaAdapter.Companion.ID
import a23227.smartcity.adapters.NotaAdapter.Companion.INFO
import a23227.smartcity.adapters.NotaAdapter.Companion.TITULO
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class VisualizarNota : AppCompatActivity() {

    private lateinit var notasViewModel: NotasViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_nota)

        notasViewModel = ViewModelProvider(this).get(NotasViewModel::class.java)


        val titulo = intent.getStringExtra(TITULO)
        val info = intent.getStringExtra(INFO)
        val tituloTextView: TextView = findViewById(R.id.tituloVisual)
        tituloTextView.text = titulo
        val infoTextView: TextView = findViewById(R.id.infoVisual)
        infoTextView.text = info
    }

    fun deleteNote(view: View) {
        val id = intent.getIntExtra(ID,-1)

        val deleteDialog = AlertDialog.Builder(this)
        //set title for alert dialog
        deleteDialog.setTitle(R.string.deleteNoteTitle)
        //set message for alert dialog
        deleteDialog.setMessage(R.string.deleteNoteMessage)

        val alertDialog: AlertDialog = deleteDialog.create()
        // Set other dialog properties
        deleteDialog.setPositiveButton("Yes"){dialogInterface, which ->
            notasViewModel.deleteByID(id)
            Toast.makeText(applicationContext,"Apagada",Toast.LENGTH_LONG).show()
            finish()
        }
        //performing cancel action
        deleteDialog.setNegativeButton("Cancel"){dialogInterface , which ->
            Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
        }
        deleteDialog.setCancelable(false)
        deleteDialog.show()


    }




}