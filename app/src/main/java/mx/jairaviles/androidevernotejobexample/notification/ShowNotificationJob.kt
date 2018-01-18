package mx.jairaviles.androidevernotejobexample.notification

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import mx.jairaviles.androidevernotejobexample.R
import mx.jairaviles.androidevernotejobexample.main.MainActivity

import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject

open class ShowNotificationJob
    @Inject constructor(): Job() {

    companion object {
        const val TAG = "show_notification_job_tag"

        @JvmStatic fun schedulePeriodic() {
            JobRequest.Builder(ShowNotificationJob.TAG)
                    .setPeriodic(TimeUnit.MINUTES.toMillis(15), TimeUnit.MINUTES.toMillis(5))
                    .setUpdateCurrent(true)
                    .build()
                    .schedule()
        }

        @JvmStatic fun request() {
            JobRequest.Builder(ShowNotificationJob.TAG)
                    .startNow()
                    .setUpdateCurrent(true)
                    .build()
                    .schedule()
        }

    }

    override fun onRunJob(params: Params): Result {
        val pi = PendingIntent.getActivity(context, 0,
                Intent(context, MainActivity::class.java), 0)

        val notification = NotificationCompat.Builder(context)
                .setContentTitle("Android Job Demo")
                .setContentText("Notification from Android Job Demo App.")
                .setAutoCancel(true)
                .setContentIntent(pi)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setShowWhen(true)
                .setColor(Color.RED)
                .setLocalOnly(true)
                .build()

        NotificationManagerCompat.from(context)
                .notify(Random().nextInt(), notification)

        return Job.Result.SUCCESS
    }
}