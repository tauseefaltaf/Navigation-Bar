package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())




         binding.bottomNavigationView2.setOnItemSelectedListener {
             when(it.itemId){
                 R.id.home -> replaceFragment(Home())
                 R.id.profile -> replaceFragment(Profile())
                 R.id.setting -> replaceFragment(setting())
                 else ->{

                 }
             }
             true
         }

    }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager= supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }
}