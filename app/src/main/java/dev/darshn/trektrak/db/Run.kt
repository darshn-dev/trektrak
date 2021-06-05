package dev.darshn.trektrak.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Run")
data class Run(

    var img:Bitmap? = null,
    var timeStamp: Long = 0L,
    var avgSpeed: Float = 0f,
    var distance:Int = 0,
    var duration: Long = 0L,
    var calories: Int = 0
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}