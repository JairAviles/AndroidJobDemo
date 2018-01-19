package mx.jairaviles.androidevernotejobexample.main

import com.evernote.android.job.JobManager
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject
import mx.jairaviles.androidevernotejobexample.manager.DataManager
import java.util.*

class MainPresenter
@Inject constructor(
        private val view: MainActivity,
        private val mDataManager: DataManager,
        private val mJobManager: JobManager): MainContract.Presenter, AnkoLogger {

    init {
        init()
    }

    override fun init() {
        mDataManager.setValue("LAST_TIME_SAVED", getClockTime())
    }

    override fun getClockTime(): String {
        val cal = Calendar.getInstance()
        val formatHour = String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))
        val formatMinute = String.format("%02d", cal.get(Calendar.MINUTE))
        val formatSecond = String.format("%02d", cal.get(Calendar.SECOND))

        return "$formatHour:$formatMinute:$formatSecond"

    }

}