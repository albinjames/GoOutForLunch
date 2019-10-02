package com.diegomfv.gooutforlunch.utils

import android.annotation.SuppressLint
import android.os.Build
import org.apache.commons.lang3.time.DateUtils
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

object DateUtils {

    const val localDateTimePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS"
    const val datePattern = "dd/MM/yyyy"
    const val fixerDatePattern = "yyyy-MM-dd"
    const val dayPattern = "dd"

    @SuppressLint("SimpleDateFormat")
    fun String.formatStringToDate(pattern: String): Date {
        val df = SimpleDateFormat(pattern)
        return try {
            df.parse(this)
        } catch (e: Exception) {
            Date()
        }
    }

    /** For comparison
     * */
    fun transformDateAsDateObjectToMillis (date: Date) : Long {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            date.toInstant().toEpochMilli()
        } else {
            date.date.toLong()
        }
    }

    fun transformDateAsStringToMillis (dateAsString: String) : Long {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dateAsString.formatStringToDate(datePattern).toInstant().toEpochMilli()
        } else {
            dateAsString.formatStringToDate(datePattern).date.toLong()
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun dateToFixerServerPattern (dateAsString: String) : String {
        val sdf = SimpleDateFormat(datePattern)
        val d = sdf.parse(dateAsString)
        sdf.applyPattern(fixerDatePattern)
        return sdf.format(d)
    }

    @SuppressLint("SimpleDateFormat")
    fun localDateTimeAsFixerServerPattern () : String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val sdf = SimpleDateFormat(fixerDatePattern)
            val d = sdf.parse(LocalDateTime.now().toString())
            sdf.applyPattern(fixerDatePattern)
            return sdf.format(d)

        } else {
            SimpleDateFormat(fixerDatePattern).format(Date(Calendar.getInstance().timeInMillis))
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun isSameDayAsToday (dateAsString: String) = DateUtils.isSameDay(Date(), SimpleDateFormat("yyyy-MM-dd").parse(dateAsString))

//    fun dateIsToday (dateAsString : Date) {
//
//        DateUtils.isSameDay(LocalDateTime.now(), )
//
//    }



//    @Test
//    fun datesTest() {
//        val datePattern = "dd/MM/yyyy"
//        val df = SimpleDateFormat(datePattern)
//        val millis = Date().toInstant().toEpochMilli()
//        val date = Date(millis)
//        val today = df.format(Date().toInstant().toEpochMilli())
//        println(today)
//    }
//
//
//    @Test
//    fun dateToMillisTest() {
//
//        val datePattern1 = "dd/MM/yyyy"
//        val datePattern2 = "dd/M/yyyy"
//
//        val todayAsString = "15/07/2019"
//
////        fun isDatePattern(dateAsString: String, pattern: String): Boolean {
////            val df = SimpleDateFormat(pattern)
////            return try {
////                df.format(dateAsString)
////                true
////            } catch (e: IllegalArgumentException) {
////                false
////            }
////        }
//
//        fun String.formatStringToDate(pattern: String): Date {
//            val df = SimpleDateFormat(pattern)
//            return try {
//                df.parse(this)
//            } catch (e: Exception) {
//                Date()
//            }
//        }
//
//        val date = todayAsString.formatStringToDate(datePattern1)
//        val millis = date.toInstant().toEpochMilli()
//        //save
//        val newDate = Date(millis)
//        val newToday = SimpleDateFormat(datePattern1).format(newDate)
//        println(newToday)
//
//    }


}