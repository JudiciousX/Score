package com.example.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.score.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var myViewModel: MyViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        binding.data = myViewModel
        binding.lifecycleOwner = this
    }
}