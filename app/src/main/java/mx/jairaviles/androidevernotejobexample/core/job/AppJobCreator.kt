package mx.jairaviles.androidevernotejobexample.core.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator
import mx.jairaviles.androidevernotejobexample.notification.ShowNotificationJob

class AppJobCreator : JobCreator {

    override fun create(tag: String): Job? {
        return when(tag) {
            ShowNotificationJob.TAG -> ShowNotificationJob()
            else -> null
        }
    }

}