package mx.jairaviles.androidevernotejobexample.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import mx.jairaviles.androidevernotejobexample.R
import mx.jairaviles.androidevernotejobexample.di.injector.Injectable
import mx.jairaviles.androidevernotejobexample.notification.ShowNotificationJob
import org.jetbrains.anko.coroutines.experimental.bg
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable, MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    private var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startClock()
        //ShowNotificationJob.schedulePeriodic() // Schedules job to execute each 15 minutes
        ShowNotificationJob.request() // Executes job immediately
    }

    override fun startClock() {
        timer = Timer()
        timer?.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                async(UI) {
                    val dataTextClock: Deferred<String> = bg {
                        presenter.getClockTime()
                    }
                    text_clock.text = dataTextClock.await()
                }
            }
        }, 0, 1000)

    }

}
