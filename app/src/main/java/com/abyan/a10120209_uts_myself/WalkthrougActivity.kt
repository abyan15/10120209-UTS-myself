package com.abyan.a10120209_uts_myself

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
// Tanggal Pengerjaan                  : 8 JUNI 2023
// NIM                                 : 10120209
// Nama                                : Abyan Altoriandi Yazid
// Kelas                               : IF-6
class WalkthrougActivity : AppCompatActivity() {

    private lateinit var onboardingItemsAdapter: onboardingItemsAdapter
    private lateinit var indicatorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)

    }
    private fun setOnboardingItems () {
        onboardingItemsAdapter = onboardingItemsAdapter(
            listOf(
                OnBoardingItem(
                    titleImage = R.drawable.satu,
                    title = "Selamat Datang",
                    desc = "Ini adalah aplikasi tentang saya, semua seputar diri saya ada di aplkasi ini"
                ),
                OnBoardingItem(
                    titleImage = R.drawable.dua,
                    title = "Disini Tersedia Semua Tentang Saya",
                    desc = "Dari mulai profil, hobi, makanan dan minuman ,musik hingga video kesukaan, tentu saja daftar teman saya juga ada."
                ),
                OnBoardingItem(
                    titleImage = R.drawable.tiga,
                    title = "Sudah siap?",
                    desc = "Tertarik? Ayo kita lebih mengenal diri saya."
                )
            )
        )
        val slideViewPager = findViewById<ViewPager2>(R.id.slideViewPager)
        slideViewPager.adapter = onboardingItemsAdapter
        slideViewPager.registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (slideViewPager.getChildAt(0 )as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
        findViewById<Button>(R.id.nextbtn).setOnClickListener{
            if(slideViewPager.currentItem+1 < onboardingItemsAdapter.itemCount){
                slideViewPager.currentItem +=1
            }else {
                navigateToHomeActivity()
            }
        }
        findViewById<Button>(R.id.skipbtn).setOnClickListener{
            navigateToHomeActivity()
        }
        findViewById<Button>(R.id.backbtn).setOnClickListener {
            if (slideViewPager.currentItem > 0 ) {
                slideViewPager.currentItem -= 1
            }
        }
    }

    private fun navigateToHomeActivity(){
        startActivity(Intent(applicationContext, HomeActivity::class.java))
        finish()
    }
    private fun setupIndicators(){
        indicatorsContainer = findViewById(R.id.indicator_layout)
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams= layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }
    private  fun setCurrentIndicator(position: Int){
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if (i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                        )
            }
        }
    }
}