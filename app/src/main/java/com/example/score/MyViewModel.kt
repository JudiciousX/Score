package com.example.score

import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(private val state: SavedStateHandle)  : ViewModel() {
    private var _aTeamScore = MutableLiveData<Int>()
    private var _bTeamScore = MutableLiveData<Int>()
    var aBack = 0
    var bBack = 0


    val aTeamScore : LiveData<Int> = _aTeamScore
    val bTeamScore : LiveData<Int> = _bTeamScore

    init {
        _aTeamScore.value = (state.get(MainActivity.KEY_NUMBER_A) ?: 0)
        _bTeamScore.value = (state.get(MainActivity.KEY_NUMBER_B) ?: 0)
    }

    fun add(score:Int, isA: Boolean) {

        aBack = _aTeamScore.value!!
        bBack = _bTeamScore.value!!
        when(isA) {
            true -> _aTeamScore.value = (_aTeamScore.value ?: 0) + score
            false -> _bTeamScore.value = (_bTeamScore.value ?: 0) + score
        }
        state.set(MainActivity.KEY_NUMBER_A, _aTeamScore.value)
        state.set(MainActivity.KEY_NUMBER_B, _bTeamScore.value)
    }

    fun reset() {
        aBack = _aTeamScore.value!!
        bBack = _bTeamScore.value!!
        _aTeamScore.value = 0
        _bTeamScore.value = 0
        state.set(MainActivity.KEY_NUMBER_A, _aTeamScore.value)
        state.set(MainActivity.KEY_NUMBER_B, _bTeamScore.value)
    }

    fun undo() {
        _aTeamScore.value = aBack
        _bTeamScore.value = bBack
    }
}