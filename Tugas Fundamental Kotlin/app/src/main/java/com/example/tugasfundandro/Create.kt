package com.example.tugasfundandro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class Create : AppCompatActivity(), View.OnClickListener {

    private lateinit var etJudul: EditText
    private lateinit var etIsi: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        etJudul = findViewById(R.id.edit_judul)
        etIsi = findViewById(R.id.edit_isi)


        //Cara pindah ke home
        val btnCreate: Button = findViewById(R.id.btn_create)
        btnCreate.setOnClickListener(this)

        //button back - ke Main Act
        val btnBack: ImageButton = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_create -> {
                val createToHome = Intent(this@Create, MainActivity::class.java)
                createToHome.putExtra("Notes", Notes(etJudul.text.toString(), etIsi.text.toString()))
                startActivity(createToHome)
            }
            R.id.btn_back -> {
                val createToHome = Intent(this@Create, MainActivity::class.java)
                startActivity(createToHome)
            }
        }
    }
}