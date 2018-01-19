# Android Job Example

This is a sample project based on the [@adavis](https://github.com/adavis) tutorial  Background Work with Android Job and Dagger [tutorial here](http://adavis.info/2016/11/background-work-with-android-job-and-dagger.html)

## Acknowledges
* This sample project aims to show a clock with the time of the device's local time zone
* It schedules a job each 15 minutes which will show an App Notification with the last time it was saved
* It was developed using Kotlin language, coroutines for async task running, Evernote Android Job and Dagger as stated on the tutorial
* The project structure is divided into packages. It uses a MVP architecture with one entity (Main)
* Dagger2 Dependency Injection classes are in di package.
* JobCreator file is in core.job package
* Job definition is in notification package.
* AppModule provides the application object, the application context object and the SharedPreferences instance.
* JobModule provides the JobManager instance and the Job instance of ShowNotificationJob class.
* On the JobCreator onRun method, it was injected a lateinit var of the job instead of a Map<String, Provider<Job>>, due to the fact that it was throwing an Exception when Building the project regarding to the Map. Cannot be provided without an @Provides- or @Produces-annotated method.

License
----

MIT

Please contact me by [mail](mailto:hi@jairaviles.mx) for either comments, doubts or any suggestions you might have.