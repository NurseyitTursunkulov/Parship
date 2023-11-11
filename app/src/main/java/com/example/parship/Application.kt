package com.example.parship

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module


/**
 * Created by nurseiit.tursunkulov on 11.11.2023
 * Application
 */
class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(module {
                viewModel { ButtonViewModel() }
            })
        }
    }
}