package com.diegomfv.gooutforlunch.utils

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

object FirebaseUtils {

    val datePatternFirebase = "yyyy-MM-dd'T'HH:mm:ss.SSS"

    val INVALID_FIREBASE_CHARACTERS = ".#$[]"

    fun getUsername(email: String): String {
        val emailParts = email.takeWhile { it != '@' }.split('.')
        return emailParts[0].first().toString().capitalize().plus(emailParts[1].toString().capitalize())
    }

//    fun getUsername(emailLiveData: String): String {
//        return replaceCharsForFirebase(emailLiveData.takeWhile { it != '@' })
//    }

//    fun getFirebaseDatabaseUserName(emailLiveData: String): String {
//        return replaceCharsForFirebase(getUsername(emailLiveData))
//    }

    fun getUsernameInitials(email: String): String {
        val stringSegments = email.split('.')
        return stringSegments[0].substring(0, 1)
            .plus(stringSegments[1].substring(0, 1))
    }

    fun generateUserDateTimeUid(email: String): String {
        return getUsername(email)
            .plus('_')
            .plus(localDateTimeNowForFirebase())
    }

    fun generateTripUserDateTimeUid(email: String, tripTitle: String) : String {
        return getUsername(email)
            .plus('_')
//            .plus(replaceCharsForFirebase(tripTitle).toLowerCase()) //Title might change when editing but we cannot change it in firebase
//            .plus("_")
            .plus(localDateTimeNowForFirebase())
    }

//    fun generateUserDateTimeUid(username: String): String {
//        return getUsernameInitials(username)
//            .plus('_')
//            .plus(localDateTimeNowForFirebase())
//    }

    fun localDateTimeNowForFirebase(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            replaceCharsForFirebase(LocalDateTime.now().toString())
        } else {
            replaceCharsForFirebase(SimpleDateFormat(datePatternFirebase).format(Date(Calendar.getInstance().timeInMillis)))
        }
    }

    fun replaceCharsForFirebase(string: String): String {
        return string.replace(Regex("""[.#$\[\]]"""), "_")
    }

    fun allCharInStringAreValidForFirebase(string: String): Boolean {
        fun isValid(int: Int) = int == -1
        INVALID_FIREBASE_CHARACTERS.forEach {
            if (!isValid(string.indexOf(it))) return false
        }
        return true
    }
}