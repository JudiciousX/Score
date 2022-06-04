package com.example.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.example.score.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var myViewModel: MyViewModel
    lateinit var binding: ActivityMainBinding

    //kotlin中取消了关键字static 如果需要定义静态变量 则需要使用伴生类
    companion object {
        @JvmStatic
        val KEY_NUMBER_A : String = "my_number_a"

        @JvmStatic
        val KEY_NUMBER_B : String = "my_number_b"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myViewModel = ViewModelProvider(this, SavedStateViewModelFactory(application, this)).get(MyViewModel::class.java)
//        savedInstanceState?.let {
//            myViewModel._aTeamScore.value = it.getInt(KEY_NUMBER_A)
//            myViewModel._bTeamScore.value = it.getInt(KEY_NUMBER_B)
//        }
        binding.data = myViewModel
        binding.lifecycleOwner = this
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        myViewModel.aTeamScore.value?.let { outState.putInt(KEY_NUMBER_A, it) }
//        myViewModel._bTeamScore.value?.let { outState.putInt(KEY_NUMBER_B, it) }
//    }
}