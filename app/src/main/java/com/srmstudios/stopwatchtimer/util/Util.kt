package com.srmstudios.stopwatchtimer.util

import java.util.concurrent.TimeUnit

fun formatMillisToTimer(ms: Long,includeMillis: Boolean = false): String {
    var millis = ms

    var hours = TimeUnit.MILLISECONDS.toHours(millis)
    millis -= TimeUnit.HOURS.toMillis(hours)
    var minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
    millis -= TimeUnit.MINUTES.toMillis(minutes)
    var seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
    millis -= TimeUnit.SECONDS.toMillis(seconds)


    return if(includeMillis){
        String.format("%02d:%02d:%02d:%03d",hours, minutes,seconds,millis)
    }else{
        String.format("%02d:%02d:%02d",hours, minutes,seconds)
    }
}