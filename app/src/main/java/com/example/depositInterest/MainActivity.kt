package com.example.depositInterest
import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.depositInterest.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var tabtitile = arrayOf("EMI","SIMPLE","COMPOUND","DEPOSIT")
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val myadapter = Fragmentadaptar(supportFragmentManager,lifecycle)
binding.viewpage2.adapter = myadapter
binding.viewpage2.isUserInputEnabled = false
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    this,
                    R.color.bar_color
                )
            )
        )

  TabLayoutMediator(binding.tablayout,binding.viewpage2){
      tab,position ->
      tab.text = tabtitile[position]

  }.attach()


    }



}


