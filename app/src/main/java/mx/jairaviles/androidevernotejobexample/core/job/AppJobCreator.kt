package mx.jairaviles.androidevernotejobexample.core.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator
import mx.jairaviles.androidevernotejobexample.notification.ShowNotificationJob
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppJobCreator
    @Inject constructor(): JobCreator {

    @Inject
    lateinit var showNotificationJob: ShowNotificationJob

    override fun create(tag: String): Job? {
        return when(tag) {
            ShowNotificationJob.TAG -> showNotificationJob
            else -> null
        }
    }

}