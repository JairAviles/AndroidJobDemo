package mx.jairaviles.androidevernotejobexample.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import mx.jairaviles.androidevernotejobexample.R
import mx.jairaviles.androidevernotejobexample.di.injector.Injectable
import mx.jairaviles.androidevernotejobexample.notification.ShowNotificationJob

class MainActivity : AppCompatActivity(), Injectable, MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ShowNotificationJob.request()
    }

    override fun startClock() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
