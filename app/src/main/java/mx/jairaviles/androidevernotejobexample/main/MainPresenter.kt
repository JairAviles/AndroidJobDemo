package mx.jairaviles.androidevernotejobexample.main

import com.evernote.android.job.JobManager
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class MainPresenter
@Inject constructor(
        private val view: MainActivity,
        private val mJobManager: JobManager): MainContract.Presenter, AnkoLogger {

    init {
        init()
    }

    override fun init() {
        info("Do something when init on Presenter...")
    }

    override fun getClockTime(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}