package dev.darshn.trektrak.util

import android.content.Context
import android.os.Build
import pub.devrel.easypermissions.EasyPermissions
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
}