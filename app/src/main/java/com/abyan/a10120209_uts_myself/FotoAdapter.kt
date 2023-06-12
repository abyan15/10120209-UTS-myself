package com.abyan.a10120209_uts_myself

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

// Tanggal Pengerjaan                  : 8 JUNI 2023
// NIM                                 : 10120209
// Nama                                : Abyan Altoriandi Yazid
// Kelas                               : IF-6
class FotoAdapter (private val fotoList: ArrayList<Foto>): RecyclerView.Adapter<FotoAdapter.FotoViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FotoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_foto, parent, false)
        return FotoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FotoViewHolder, position: Int) {
        val currentItem = fotoList[position]
        holder.imageFoto.setImageResource(currentItem.gambarFoto)
    }

    override fun getItemCount(): Int {
        return fotoList.size
    }

    class FotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val imageFoto : ImageView = itemView.findViewById(R.id.gambarFoto)
    }


}