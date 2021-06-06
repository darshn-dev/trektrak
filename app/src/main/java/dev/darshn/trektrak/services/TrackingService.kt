package dev.darshn.trektrak.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleService
import dev.darshn.trektrak.R
import dev.darshn.trektrak.ui.MainActivity
import dev.darshn.trektrak.util.Constants
import timber.log.Timber

class TrackingService : LifecycleService() {

    var isFirstRun = true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.let {
            when(it.action){
                    Constants.ACTION_START_OR_RESUME ->{
                        if(isFirstRun){
                            startForegroundService()
                            isFirstRun = false
                        }else{
                            Timber.d("Service stopped")
                        }


                    }
                Constants.ACTION_STOP ->{
                    Timber.d("Service ACTION_STOP")
                }
                Constants.ACTION_PAUSE ->{
                    Timber.d("Service ACTION_PAUSE")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }


    private fun startForegroundService(){
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotificationChannel(notificationManager)
        }

        val notificationBuilder = NotificationCompat.Builder(this, Constants.NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_baseline_directions_run_24)
            .setContentTitle("Running App")
            .setContentText("00:00:00")
            .setContentIntent(getMainActivityPendingIntent())

        startForeground(
            Constants.NOTIFICATION_ID,
            notificationBuilder.build()
        )
    }

    private fun getMainActivityPendingIntent() = PendingIntent.getActivity(
        this,
        0,
        Intent(this,MainActivity::class.java).also {
            it.action = Constants.ACTION_SHOW_TRACKING_FRAGMENT
        },
        FLAG_UPDATE_CURRENT
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager){
        val channel = NotificationChannel(
            Constants.NOTIFICATION_CHANNEL_ID,
            Constants.NOTIFICATION_CHANNEL_NAME,
            IMPORTANCE_LOW
            )

        notificationManager.createNotificationChannel(channel)
    }

}