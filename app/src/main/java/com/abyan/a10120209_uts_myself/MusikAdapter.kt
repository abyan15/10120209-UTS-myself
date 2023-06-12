package com.abyan.a10120209_uts_myself

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
// Tanggal Pengerjaan                  : 8 JUNI 2023
// NIM                                 : 10120209
// Nama                                : Abyan Altoriandi Yazid
// Kelas                               : IF-6
class MusikAdapter(private val context: Context, private val musiklist: List<Musik>, val listener: (Musik) -> Unit)
    : RecyclerView.Adapter<MusikAdapter.MusikViewHolder>(){

    class MusikViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val videoView = itemView.findViewById<VideoView>(R.id.videoMusik)
        private val mediaController = MediaController(itemView.context)
        private val judul = itemView.findViewById<TextView>(R.id.judul)
        init {
            mediaController.setAnchorView(videoView)
            videoView.setMediaController(mediaController)
        }

        fun bindView(musik: Musik, listener: (Musik) -> Unit) {
            videoView.setVideoURI(Uri.parse(musik.judul))
            judul.text=musik.lagu
            videoView.setOnPreparedListener { mp ->
                mp.setOnVideoSizeChangedListener { _, _, _ ->
                    videoView.start()
                }
            }
            itemView.setOnClickListener {
                listener(musik)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusikViewHolder {
        return MusikViewHolder(LayoutInflater.from(context).inflate(R.layout.item_musik, parent, false))
    }

    override fun getItemCount(): Int = musiklist.size

    override fun onBindViewHolder(holder: MusikViewHolder, position: Int) {
        holder.bindView(musiklist[position], listener)
    }

}