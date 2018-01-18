package mx.jairaviles.androidevernotejobexample.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import mx.jairaviles.androidevernotejobexample.R
import mx.jairaviles.androidevernotejobexample.di.injector.Injectable
import mx.jairaviles.androidevernotejobexample.notification.ShowNotificationJob
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable, MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ShowNotificationJob.request()
    }

    override fun startClock() {
        presenter.getClockTime()
    }

}
