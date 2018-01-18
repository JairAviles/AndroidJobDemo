package mx.jairaviles.androidevernotejobexample.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mx.jairaviles.androidevernotejobexample.main.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributeMainActivityInjector() : MainActivity

}