package mx.jairaviles.androidevernotejobexample.di.injector

import android.app.Activity
import android.app.Application
import android.os.Bundle
import dagger.android.AndroidInjection
import mx.jairaviles.androidevernotejobexample.application.App
import mx.jairaviles.androidevernotejobexample.di.component.AppComponent
import mx.jairaviles.androidevernotejobexample.di.component.DaggerAppComponent
import mx.jairaviles.androidevernotejobexample.di.module.AppModule

class AppInjector {
    companion object {
        lateinit var appComponent: AppComponent

        fun init (app: App): AppComponent {
            appComponent = DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()

            appComponent.inject(app)

            val value: Application.ActivityLifecycleCallbacks = object : Application.ActivityLifecycleCallbacks {
                override fun onActivityPaused(activity: Activity?) {}

                override fun onActivityResumed(activity: Activity?) {}

                override fun onActivityStarted(activity: Activity?) {}

                override fun onActivityDestroyed(activity: Activity?) {}

                override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {}

                override fun onActivityStopped(activity: Activity?) {}

                override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                    if (activity is Injectable) {
                        AndroidInjection.inject(activity)
                    }
                }
            }

            app.registerActivityLifecycleCallbacks(value)

            return appComponent

        }

    }

}