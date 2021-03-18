package a23227.smartcity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import a23227.smartcity.Data.Nota
import a23227.smartcity.adapters.NotaAdapter
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_notas.*
import kotlinx.android.synthetic.main.noteline.view.*
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class Notas : AppCompatActivity() {

    private lateinit var notas: ArrayList<Nota>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

        notas = ArrayList<Nota>()


        recyclerNotas.adapter = NotaAdapter(notas)
        recyclerNotas.layoutManager = LinearLayoutManager(this)


    }

    fun insert(view: View){
        val indice = notas.size
        val date = Date()
        notas.add(indice , Nota(view.titulo.toString(), view.rua.toString(), view.info.toString(), date))
        recyclerNotas.adapter?.notifyDataSetChanged()
    }

}