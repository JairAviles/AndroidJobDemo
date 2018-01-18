package mx.jairaviles.androidevernotejobexample.main

import mx.jairaviles.androidevernotejobexample.core.presenter.BasePresenter
import mx.jairaviles.androidevernotejobexample.core.view.BaseView

interface MainContract {

    interface View : BaseView {
        fun startClock()
    }

    interface Presenter : BasePresenter {

        fun getClockTime() : String

    }

}