package mx.jairaviles.androidevernotejobexample.application

import android.app.Activity
import android.app.Application
import com.evernote.android.job.JobManager
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import mx.jairaviles.androidevernotejobexample.core.job.AppJobCreator
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        JobManager.create(this).addJobCreator(AppJobCreator())
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}