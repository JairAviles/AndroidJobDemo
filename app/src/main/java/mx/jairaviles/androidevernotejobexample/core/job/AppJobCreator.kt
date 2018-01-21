package mx.jairaviles.androidevernotejobexample.core.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class AppJobCreator
    @Inject constructor(
            private val jobs: @JvmSuppressWildcards Map<String, Provider<Job>>
    ): JobCreator {

    override fun create(tag: String): Job? {
        val jobProvider = jobs[tag]
        return jobProvider?.get()
    }

}