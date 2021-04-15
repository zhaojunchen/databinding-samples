package com.example.android.databinding.basicsample.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.databinding.basicsample.data.User
import java.util.*

object Repository {
    fun getUser(name: String): LiveData<User> {
        Thread.sleep(1000)
        val livaData = MutableLiveData<User>()
        val lastName = UUID.randomUUID().toString()
        livaData.value = User(name, lastName)
        return livaData

    }
}