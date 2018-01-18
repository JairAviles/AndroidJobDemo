package mx.jairaviles.androidevernotejobexample.main

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainPresenter : MainContract.Presenter, AnkoLogger {

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