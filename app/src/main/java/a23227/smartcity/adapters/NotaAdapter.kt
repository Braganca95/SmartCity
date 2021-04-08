package a23227.smartcity.adapters

import a23227.smartcity.Entities.Nota
import a23227.smartcity.R
import a23227.smartcity.VisualizarNota
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.noteline.view.*

class NotaAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<NotaAdapter.NotaViewHolder>()  {

    //private var listener:OnItemClickListener? = null
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notas = emptyList<Nota>() // Cached copy of cities

    class NotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tituloItemView: TextView = itemView.findViewById(R.id.titulo)
        val infoItemView: TextView = itemView.findViewById(R.id.info)
        val dataItemView: TextView = itemView.findViewById(R.id.data)



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val itemView = inflater.inflate(R.layout.noteline, parent, false)
        return NotaViewHolder(itemView)
    }




    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val current = notas[position]
        holder.tituloItemView.text = current.titulo
        holder.infoItemView.text = current.info
        holder.dataItemView.text = current.data
        val id = current.id

        holder.itemView.noteCard.setOnClickListener{

            val context =  holder.tituloItemView.context
            val titulo =  holder.tituloItemView.text.toString()
            val info = holder.infoItemView.text.toString()

            val intent = Intent(context, VisualizarNota::class.java).apply{
                putExtra(ID,id)
                putExtra(TITULO,titulo)
                putExtra(INFO,info)
            }

            context.startActivity(intent)

        }


    }

    override fun getItemCount() = notas.size

    internal fun setNotas(notas: List<Nota>) {
        this.notas = notas
        notifyDataSetChanged()
    }


    companion object {
        const val TITULO = "Titulo"
        const val INFO = "Info"
        const val ID = "Id"
    }




}

