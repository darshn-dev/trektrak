package dev.darshn.trektrak.util

import android.content.Context
import android.os.Build
import pub.devrel.easypermissions.EasyPermissions
import java.sql.Time
import java.util.concurrent.TimeUnit
import java.util.jar.Manifest

object TrackUtil {


    fun hasLocationPermission(context: Context): Boolean {

        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            EasyPermissions.hasPermissions(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
        } else {
            EasyPermissions.hasPermissions(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_BACKGROUND_LOCATION,
            )
        }
    }

    fun getFormatedTime(time: Long, includeMil: Boolean = false): String {
        var miliSec = time
        val hours = TimeUnit.MICROSECONDS.toHours(miliSec)
        miliSec -= TimeUnit.HOURS.toMillis(hours)
        val min = TimeUnit.MILLISECONDS.toMinutes(miliSec)
        miliSec -= TimeUnit.MINUTES.toMillis(min)
        val sec = TimeUnit.MILLISECONDS.toSeconds(miliSec)

        if (!includeMil) {
            return "${if (hours < 10) "0" else ""}$hours:" +
                    "${if (min < 10) "0" else ""}$min:" +
                    "${if (sec < 10) "0" else ""}$sec"
        }

        miliSec -= TimeUnit.SECONDS.toMillis(sec)
        miliSec /= 10
        return "${if (hours < 10) "0" else ""}$hours:" +
                "${if (min < 10) "0" else ""}$min:" +
                "${if (sec < 10) "0" else ""}$sec:" +
                "${if (miliSec < 10) "0" else ""}$miliSec"
    }
}