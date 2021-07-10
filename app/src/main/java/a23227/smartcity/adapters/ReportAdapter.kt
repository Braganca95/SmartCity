package a23227.smartcity.adapters

import a23227.smartcity.R
import a23227.smartcity.api.Report
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val OCORR="TITULO"
const val DESC="DESCRICAO"
const val IDOCO= "ID"
const val IDDEL= "ID"

class ReportAdapter {


    /*class OcorrenciaAdapter(val ocorrencias: List<Report>): RecyclerView.Adapter<OcorenciasViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OcorenciasViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.ocorrenciarecyclerline, parent, false)
            return OcorenciasViewHolder(view)
        }

        override fun getItemCount(): Int {
            return ocorrencias.size
        }

        override fun onBindViewHolder(holder: OcorenciasViewHolder, position: Int) {
            return holder.bind(ocorrencias[position])
        }

    }*/

    /*class OcorenciasViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        private val titulo: TextView = itemView.findViewById(R.id.ocorrtit)
        private val descricao:TextView = itemView.findViewById(R.id.ocorrdesc)
        val editOco: ImageButton = itemView.findViewById(R.id.editOco)
        val elimOco: ImageButton = itemView.findViewById(R.id.deleteOco)


        fun bind(ocorrencia: Ocorrencia) {
            titulo.text = ocorrencia.titulo
            descricao.text = ocorrencia.descricao
            editOco.setOnClickListener {
                val context =  titulo.context
                val tit = titulo.text.toString()
                val desc = descricao.text.toString()
                val id = ocorrencia.id

                val intent = Intent(context, EditOcorrencia::class.java).apply {
                    putExtra(OCORR, tit)
                    putExtra(DESC, desc)
                    putExtra(IDOCO, id)
                }
                context.startActivity(intent)
            }
            elimOco.setOnClickListener {
                val context =  titulo.context
                val id = ocorrencia.id
                val intent = Intent(context, DeleteOcorrencia::class.java).apply {
                    putExtra(IDDEL, id)
                }
                context.startActivity(intent)
            }
            titulo.text = ocorrencia.titulo
            descricao.text = ocorrencia.descricao

        }

    }*/
}