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
class onboardingItemsAdapter (private val onBoardingItem: List<OnBoardingItem>) :
    RecyclerView.Adapter<onboardingItemsAdapter.OnboardingItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slider_layout,
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onBoardingItem[position])
    }

    override fun getItemCount(): Int {
        return onBoardingItem.size
    }

    inner class OnboardingItemViewHolder(view: View):RecyclerView.ViewHolder(view) {

        private  val titleImage = view.findViewById<ImageView>(R.id.titleImage)
        private  val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private  val textDesc = view.findViewById<TextView>(R.id.textDesc)

        fun bind(onBoardingItem: OnBoardingItem){
            titleImage.setImageResource(onBoardingItem.titleImage)
            textTitle.text = onBoardingItem.title
            textDesc.text = onBoardingItem.desc
        }
    }
}