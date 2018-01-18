package mx.jairaviles.androidevernotejobexample.di.component

import com.evernote.android.job.JobManager
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import mx.jairaviles.androidevernotejobexample.application.App
import mx.jairaviles.androidevernotejobexample.di.builder.ActivityBuilder
import mx.jairaviles.androidevernotejobexample.di.module.AppModule
import mx.jairaviles.androidevernotejobexample.di.module.JobsModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (JobsModule::class), (ActivityBuilder::class)])
interface AppComponent {

    fun inject(app : App)

    fun inject(jobManager: JobManager)

}