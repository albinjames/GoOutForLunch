package com.diegomfv.gooutforlunch.data.model.domainmodel.restaurant

import com.diegomfv.gooutforlunch.data.model.domainmodel.ColleagueModel

class RestaurantModel {
    var name: String? = null
    var type: String? = null
    var address: String? = null
    var rating: Float? = null
    var attachmentPath: List<String>? = null
    var openTime: String? = null
    var closeTime: String? = null
    var colleaguesJoining : List<ColleagueModel>? = null

    companion object {
        fun empty() = RestaurantModel()
    }

}