package com.unitapplications.noteskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter() :RecyclerView.Adapter<viewHolder>(){
    private val noteList = ArrayList<NoteModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem= layoutInflater.inflate(R.layout.rv_item,parent,false)
        return viewHolder(listItem)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
    fun setList(notes:List<NoteModel>){
        noteList.clear()
        noteList.addAll(notes)
    }
}
class viewHolder(private val view: View):RecyclerView.ViewHolder(view){
    fun bind(noteModel: NoteModel){
        val title_tv = view.findViewById<TextView>(R.id.title_tv)
        val note_tv = view.findViewById<TextView>(R.id.note_tv)

        title_tv.text = noteModel.title
        note_tv.text = noteModel.note
    }

}