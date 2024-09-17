package com.example.latihanintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnmove: Button = findViewById(R.id.btnPindah)
        btnmove.setOnClickListener(this)

        val btnmovewithdata: Button = findViewById(R.id.btn_Movedata)
        btnmovewithdata.setOnClickListener(this)

        val btnmoveobject: Button = findViewById(R.id.btn_moveObject)
        btnmoveobject.setOnClickListener(this)

        val btndial: Button = findViewById(R.id.btn_dial)
        btndial.setOnClickListener(this)

        val btnresult: Button = findViewById(R.id.btn_move_result)
        btnresult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnPindah -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)

                startActivity(moveIntent)
            }

            R.id.btn_Movedata -> {
                val moveIntentdata = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveIntentdata.putExtra(MoveWithDataActivity.EXTRA_NAME, "Bintang Arkaan")
                moveIntentdata.putExtra(MoveWithDataActivity.EXTRA_AGE, 22)

                startActivity(moveIntentdata)

            }

            R.id.btn_moveObject -> {
                val person = Person(
                    "Bintang",
                    22,
                    "bintang@gmail.com",
                    "Bekasi"
                )
                val moveIntentObject = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveIntentObject.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveIntentObject)
            }

            R.id.btn_dial -> {
                val phoneNumber = "08184139475"
                val dialPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber"))
                startActivity(dialPhone)
            }

            R.id.btn_move_result -> {
                val moveForResultIntent =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }

}