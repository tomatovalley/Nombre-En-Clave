package com.example.jesus.codenames.fragments

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jesus.codenames.R
import com.example.jesus.codenames.Retrofit.IMyService
import io.reactivex.disposables.CompositeDisposable

class modal_crearsala : DialogFragment() {
    lateinit var iMyService : IMyService
    internal var compositeDisposable= CompositeDisposable()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.modal_crearsala, container, false)
        return v



    }

}