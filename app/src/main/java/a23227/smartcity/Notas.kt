package a23227.smartcity

import a23227.smartcity.Entities.Nota
import a23227.smartcity.ViewModel.NotasViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import a23227.smartcity.adapters.NotaAdapter
import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_notas.*
import androidx.lifecycle.Observer
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class Notas : AppCompatActivity() {

    private lateinit var notasViewModel: NotasViewModel
    private val newNoteRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

        supportActionBar?.hide()

        // recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerNotas)
        val adapter = NotaAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // view model
        notasViewModel = ViewModelProvider(this).get(NotasViewModel::class.java)
        notasViewModel.allNotas.observe(this, Observer { notas ->
            // Update the cached copy of the words in the adapter.
            notas?.let {
                adapter.setNotas(it)
            }
        })




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newNoteRequestCode && resultCode == Activity.RESULT_OK) {
            val ptitulo= data?.getStringExtra(CriarNota.EXTRA_REPLY_TITULO)
            val pinfo = data?.getStringExtra(CriarNota.EXTRA_REPLY_INFO)

            if (ptitulo!= null && pinfo != null) {
                val sdf = SimpleDateFormat("hh:mm dd/M/yyyy")
                val date = sdf.format(Date())
                val nota = Nota(titulo = ptitulo, info = pinfo,data = date )
                notasViewModel.insert(nota)
            }

        }
    }


    /*fun visualizarNota(view: View){

        val intent = Intent(this@Notas, VisualizarNota::class.java).apply{}

            android:onClick="visualizarNota"
        startActivity(intent)

    }*/



    fun CriarNota(view: View) {
        val intent = Intent(this@Notas, CriarNota::class.java)
        startActivityForResult(intent, newNoteRequestCode)

    }

    fun close(view: View) {
        finish()
    }


}