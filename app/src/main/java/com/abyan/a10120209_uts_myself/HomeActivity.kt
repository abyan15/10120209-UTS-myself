package com.abyan.a10120209_uts_myself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
// Tanggal Pengerjaan                  : 8 JUNI 2023
// NIM                                 : 10120209
// Nama                                : Abyan Altoriandi Yazid
// Kelas                               : IF-6
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val homeFragment = HomeFragment()
        val activityFragment = ActivityFragment()
        val galeriFragment = GaleriFragment()
        val musikFragment = MusikFragment()
        val profilFragment = ProfilFragment()

        makeCurrentFragment(homeFragment)

        val bottom_navigation_view = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.itemHome ->makeCurrentFragment(homeFragment)
                R.id.itemActivity ->makeCurrentFragment(activityFragment )
                R.id.itemGaleri ->makeCurrentFragment(galeriFragment )
                R.id.itemMusik ->makeCurrentFragment(musikFragment )
                R.id.itemProfil ->makeCurrentFragment(profilFragment )
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.content,fragment)
            commit()
        }

    }

}