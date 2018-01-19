package mx.jairaviles.androidevernotejobexample.di.module

import android.app.Application
import com.evernote.android.job.Job
import com.evernote.android.job.JobManager
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import mx.jairaviles.androidevernotejobexample.core.job.AppJobCreator
import mx.jairaviles.androidevernotejobexample.manager.DataManager
import mx.jairaviles.androidevernotejobexample.notification.ShowNotificationJob
import javax.inject.Singleton

@Module
class JobsModule {

    @Provides
    @Singleton
    fun providesManager(mApplication: Application, appJobCreator: AppJobCreator) : JobManager {
        JobManager.create(mApplication).addJobCreator(appJobCreator)
        return JobManager.instance()
    }

    @Provides @IntoMap
    @StringKey(ShowNotificationJob.TAG)
    fun providesShowNotificationJob(mDataManager: DataManager) : Job = ShowNotificationJob(mDataManager)

}