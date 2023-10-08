package com.example.tugasfundandro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.tugasfundandro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv_judul: TextView
    private lateinit var tv_isi: TextView
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tv_judul = findViewById(R.id.intent_judul)
        tv_isi = findViewById(R.id.intent_isi)

        // Dapetin hasilnya dari create
        val jdl = intent.getParcelableExtra<Notes>("Notes")?.title ?: "Judul"
        val isik = intent.getParcelableExtra<Notes>("Notes")?.isi ?: "Isi"

        tv_judul.text = jdl
        tv_isi.text = isik

        // Share
        val btnShare: ImageButton = findViewById(R.id.btn_share)
        btnShare.setOnClickListener(this)

        //create new - ke Create Act
        val btnNew: ImageButton = findViewById(R.id.btn_new)
        btnNew.setOnClickListener(this)

        //Fragment
        //Tambah change ke changecolorfrag
        binding.btnChange.setOnClickListener{
            val change = ChangeColFragment()

            //Tambah change ke fragmentcontainer
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView2, change)
            fragmentTransaction.commit()
        }

    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_share -> {
                val judul = findViewById<TextView>(R.id.intent_judul)?.text.toString()
                val isi = findViewById<TextView>(R.id.intent_isi)?.text.toString()

                val message = "$judul\n $isi"

                val intentToImplicit = Intent()
                intentToImplicit.action = Intent.ACTION_SEND
                intentToImplicit.putExtra(Intent.EXTRA_TEXT, message)
                intentToImplicit.type = "text/plain"  // Harus pake type
                startActivity(intentToImplicit)
            }
            R.id.btn_new -> {
                val mainToCreate = Intent(this, Create::class.java)
                startActivity(mainToCreate)
            }

        }
    }


}