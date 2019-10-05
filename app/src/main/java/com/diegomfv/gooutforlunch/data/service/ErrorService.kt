package com.diegomfv.gooutforlunch.data.service

import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.applicationprovider.ApplicationResourceProvider
import com.diegomfv.gooutforlunch.utils.error.ErrorCode

class ErrorService {

    fun getErrorForUser (errorCode: ErrorCode) : String {
        return when (errorCode) {
            ErrorCode.ERROR_001_INTERNET_NOT_AVAILABLE -> ApplicationResourceProvider.getString(R.string.error_001_internet_not_available)
            else -> ApplicationResourceProvider.getString(R.string.error_000_unknown_error)
        }
    }





}