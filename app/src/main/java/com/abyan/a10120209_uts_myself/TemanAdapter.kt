package com.abyan.a10120209_uts_myself
// Tanggal Pengerjaan                  : 8 JUNI 2023
// NIM                                 : 10120209
// Nama                                : Abyan Altoriandi Yazid
// Kelas                               : IF-6
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView


class TemanAdapter (private val temanList: ArrayList<Teman>): RecyclerView.Adapter<TemanAdapter.TemanViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TemanViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_teman, parent, false)
        return TemanViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TemanViewHolder, position: Int) {
        val currentItem = temanList[position]
        holder.imageTeman.setImageResource(currentItem.gambarTeman)
        holder.namaTeman.text = (currentItem.namaTeman)
    }

    override fun getItemCount(): Int {
        return temanList.size
    }

    class TemanViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val imageTeman : CircleImageView = itemView.findViewById(R.id.gambarTeman)
        val namaTeman : TextView = itemView.findViewById(R.id.namaTeman)
    }


}