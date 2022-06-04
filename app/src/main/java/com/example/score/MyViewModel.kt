package com.example.score

import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private var _aTeamScore = MutableLiveData<Int>()
    private var _bTeamScore = MutableLiveData<Int>()
    var aBack = 0
    var bBack = 0


    val aTeamScore : LiveData<Int> = _aTeamScore
    val bTeamScore : LiveData<Int> = _bTeamScore

    init {
        _aTeamScore.value = 0
        _bTeamScore.value = 0
    }

    fun add(score:Int, isA: Boolean) {
        aBack = _aTeamScore.value!!
        bBack = _bTeamScore.value!!
        when(isA) {
            true -> _aTeamScore.value = (_aTeamScore.value ?: 0) + score
            false -> _bTeamScore.value = (_bTeamScore.value ?: 0) + score
        }
    }

    fun reset() {
        aBack = _aTeamScore.value!!
        bBack = _bTeamScore.value!!
        _aTeamScore.value = 0
        _bTeamScore.value = 0
    }

    fun undo() {
        _aTeamScore.value = aBack
        _bTeamScore.value = bBack
    }
}