package com.abyan.a10120209_uts_myself

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
// Tanggal Pengerjaan                  : 8 JUNI 2023
// NIM                                 : 10120209
// Nama                                : Abyan Altoriandi Yazid
// Kelas                               : IF-6
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfilFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        val imageinstagram = view.findViewById<ImageView>(R.id.ig)
        val imagelokasi = view.findViewById<ImageView>(R.id.gmaps)
        val btn = view.findViewById<Button>(R.id.button)

        imageinstagram.setOnClickListener(View.OnClickListener{
            val uri = Uri.parse("https://www.instagram.com/abyansipecintaunikom/")
            val instagram = Intent(Intent.ACTION_VIEW, uri)
            instagram.setPackage("com.instagram.android")
            try {
                startActivity(instagram)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/abyansipecintaunikom/")))
            }
        })

        imagelokasi.setOnClickListener(View.OnClickListener{
            val uri = Uri.parse("https://goo.gl/maps/Fncf2SoJ6QntCcnf7")
            val maps = Intent(Intent.ACTION_VIEW, uri)
            maps.setPackage("com.google.android.apps.maps")
            try {
                startActivity(maps)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/Fncf2SoJ6QntCcnf7")))
            }
        })

        btn.setOnClickListener{
            val dialogBinding = layoutInflater.inflate(R.layout.custom_dialog, null)

            val myDialog = Dialog(requireContext())
            myDialog.setContentView(dialogBinding)

            myDialog.setCancelable(true)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()

            val closebtn = dialogBinding.findViewById<Button>(R.id.about_close)
            closebtn.setOnClickListener{
                myDialog.dismiss()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}