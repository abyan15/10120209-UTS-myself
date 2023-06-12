package com.abyan.a10120209_uts_myself

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
// Tanggal Pengerjaan                  : 8 JUNI 2023
// NIM                                 : 10120209
// Nama                                : Abyan Altoriandi Yazid
// Kelas                               : IF-6
class KegiatanAdapter (private val kegiatanList: ArrayList<Kegiatan>): RecyclerView.Adapter<KegiatanAdapter.KegiatanViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KegiatanViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_kegiatan, parent, false)
        return KegiatanViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: KegiatanViewHolder, position: Int) {
        val currentItem = kegiatanList[position]
        holder.imageView.setImageResource(currentItem.gambarKegiatan)
        holder.namaKegiatan.text = (currentItem.namaKegiatan)
    }

    override fun getItemCount(): Int {
        return kegiatanList.size
    }

    class KegiatanViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val imageView : ImageView = itemView.findViewById(R.id.gambarKegiatan)
        val namaKegiatan : TextView = itemView.findViewById(R.id.namaKegiatan)
    }


}