package a23227.smartcity

import a23227.smartcity.Entities.Nota
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
import kotlinx.android.synthetic.main.activity_visualizar_nota.*
import java.text.SimpleDateFormat
import java.util.*

class VisualizarNota : AppCompatActivity() {

    private lateinit var notasViewModel: NotasViewModel
    private var titulo: String? = null
    private var info: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_nota)

        supportActionBar?.hide()

        notasViewModel = ViewModelProvider(this).get(NotasViewModel::class.java)

        titulo = intent.getStringExtra(TITULO)
        info = intent.getStringExtra(INFO)

        val tituloTextView: TextView = findViewById(R.id.tituloVisual)
        tituloTextView.text = titulo

        val infoTextView: TextView = findViewById(R.id.infoVisual)
        infoTextView.text = info
    }

    fun deleteNote(view: View) {
        val id = intent.getIntExtra(ID,-1)

        val dialog = AlertDialog.Builder(this)
        //set title for alert dialog
        dialog.setTitle(R.string.deleteNoteTitle)
        //set message for alert dialog
        dialog.setMessage(R.string.deleteNoteMessage)


        // Set other dialog properties
        dialog.setPositiveButton(R.string.confirmDialog){dialogInterface, which ->
            notasViewModel.deleteByID(id)
            Toast.makeText(applicationContext,R.string.NoteDelete,Toast.LENGTH_LONG).show()
            finish()
        }
        //performing cancel action
        dialog.setNegativeButton(R.string.cancelDialog){dialogInterface , which ->
        }
        val deleteDialog: AlertDialog = dialog.create()
        deleteDialog.setCancelable(false)
        deleteDialog.show()


    }

    fun close(view: View) {
        finish()
    }

    fun editarNota(view: View) {
        val id = intent.getIntExtra(ID,-1)

        val dialog = AlertDialog.Builder(this)

        dialog.setTitle(R.string.updateNoteTitle)

        dialog.setMessage(R.string.updateNoteMessage)

        dialog.setPositiveButton(R.string.confirmDialog){dialogInterface, which ->

            if (tituloVisual.text.toString().isNullOrEmpty()|| infoVisual.text.toString().isNullOrEmpty() ) {

                Toast.makeText(applicationContext,R.string.editProblem,Toast.LENGTH_LONG).show()

            }else if( tituloVisual.text.toString() == titulo && infoVisual.text.toString() == info) {
                Toast.makeText(applicationContext,R.string.editEqual,Toast.LENGTH_LONG).show()
                finish()
            } else{
                val tituloVisual = tituloVisual.text.toString()
                val infoVisual = infoVisual.text.toString()
                val sdf = SimpleDateFormat("hh:mm dd/M/yyyy")
                val date = sdf.format(Date())
                val nota = Nota(id =id, titulo = tituloVisual, info = infoVisual, data = date)
                notasViewModel.updateNota(nota)
                finish()


            }

        }

        //performing cancel action
        dialog.setNegativeButton(R.string.cancelDialog){dialogInterface , which ->
        }
        val deleteDialog: AlertDialog = dialog.create()
        deleteDialog.setCancelable(false)
        deleteDialog.show()





    }




}