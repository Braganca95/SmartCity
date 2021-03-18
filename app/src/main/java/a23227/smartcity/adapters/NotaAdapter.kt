package a23227.smartcity.adapters

import a23227.smartcity.Data.Nota
import a23227.smartcity.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.noteline.view.*

class NotaAdapter(val list: ArrayList<Nota>):RecyclerView.Adapter<LineViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.noteline, parent, false)
        return LineViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
        val NotaAtual = list[position]

        holder.titulo.text = NotaAtual.titulo
        holder.rua.text = NotaAtual.rua
        holder.info.text =  NotaAtual.info
        holder.data.text =  NotaAtual.data.toString()
    }

}

class LineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val titulo = itemView.titulo
    val rua  =  itemView.rua
    val info =  itemView.info
    val data =  itemView.data
}