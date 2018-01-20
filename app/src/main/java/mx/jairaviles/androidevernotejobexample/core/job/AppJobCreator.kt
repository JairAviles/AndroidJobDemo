package mx.jairaviles.androidevernotejobexample.core.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class AppJobCreator
    @Inject constructor(): JobCreator {

    @Inject
    lateinit var jobs: Map<String, Provider<Job>>

    override fun create(tag: String): Job? {
        val jobProvider = jobs[tag]
        return jobProvider?.get()
    }

}