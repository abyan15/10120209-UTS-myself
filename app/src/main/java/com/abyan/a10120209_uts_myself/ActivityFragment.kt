package com.abyan.a10120209_uts_myself

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

// Tanggal Pengerjaan                  : 8 JUNI 2023
// NIM                                 : 10120209
// Nama                                : Abyan Altoriandi Yazid
// Kelas                               : IF-6

/**
 * A simple [Fragment] subclass.
 * Use the [ActivityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActivityFragment : Fragment() {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: KegiatanAdapter
    private lateinit var adapter2: TemanAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var kegiatanArrayList : ArrayList<Kegiatan>
    private lateinit var temanArrayList : ArrayList<Teman>


    lateinit var gambar:Array<Int>
    lateinit var nama:Array<String>
    lateinit var gambar2:Array<Int>
    lateinit var nama2:Array<String>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        val layoutManager = LinearLayoutManager(context)
        val layoutManager2 = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView=view.findViewById(R.id.recylerView1)
        recyclerView2=view.findViewById(R.id.recylerView2)
        recyclerView.layoutManager = layoutManager
        recyclerView2.layoutManager = layoutManager2
        recyclerView.setHasFixedSize(true)
        recyclerView2.setHasFixedSize(true)
        adapter = KegiatanAdapter(kegiatanArrayList)
        adapter2= TemanAdapter((temanArrayList))
        recyclerView.adapter=adapter
        recyclerView2.adapter=adapter2
    }

    private fun init(){
        kegiatanArrayList = arrayListOf<Kegiatan>()

        gambar= arrayOf(
            R.drawable.shower,
            R.drawable.eat,
            R.drawable.student,
            R.drawable.chat,
            R.drawable.study,
            R.drawable.gaming,
            R.drawable.sleeping,

        )
        nama= arrayOf(
            "Mandi",
            "Makan",
            "Kuliah",
            "Bertemu dengan teman-teman",
            "Belajar",
            "Bermain Game",
            "Tidur",
        )
        for (i in gambar.indices){

            val kegiatan = Kegiatan(gambar[i], nama[i])
            kegiatanArrayList.add(kegiatan)
        }
        temanArrayList = arrayListOf<Teman>()

        gambar2= arrayOf(
            R.drawable.diva,
            R.drawable.fahmi,
            R.drawable.tri,
            R.drawable.adit,
            R.drawable.ardian,
            R.drawable.alvin,
            R.drawable.faris,
            R.drawable.mamat,
            )
        nama2= arrayOf(
            "Diva",
            "Fahmi",
            "Tri",
            "Adit",
            "Ardian",
            "Alvin",
            "Faris",
            "Rachmat"
        )
        for (i in gambar2.indices){

            val teman = Teman(gambar2[i], nama2[i])
            temanArrayList.add(teman)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ActivityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ActivityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
