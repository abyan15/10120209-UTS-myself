package com.abyan.a10120209_uts_myself

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
// Tanggal Pengerjaan                  : 8 JUNI 2023
// NIM                                 : 10120209
// Nama                                : Abyan Altoriandi Yazid
// Kelas                               : IF-6
class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME: Long = 3000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            startActivity(Intent(this, WalkthrougActivity::class.java))
            finish()
        }, SPLASH_TIME)
    }
}