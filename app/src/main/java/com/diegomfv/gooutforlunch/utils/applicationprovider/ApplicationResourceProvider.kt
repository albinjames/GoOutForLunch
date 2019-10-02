package com.diegomfv.gooutforlunch.utils.applicationprovider

object ApplicationResourceProvider {

    fun getString(resource: Int, arg1: String = "", arg2: String = "", arg3: String = "") : String {
        return when {
            arg1.isEmpty() -> ApplicationProvider.application.getString(resource)
            arg2.isEmpty() -> ApplicationProvider.application.getString(resource, arg1)
            arg3.isEmpty() -> ApplicationProvider.application.getString(resource, arg1, arg2)
            else           -> ApplicationProvider.application.getString(resource, arg1, arg2, arg3)
        }
    }

    fun getDimension(resource: Int) : Float {
        return ApplicationProvider.application.resources.getDimension(resource)
    }

    fun getColor(resource: Int) : Int {
        return ApplicationProvider.application.resources.getColor(resource, null)
    }

    fun getRawResourceAsString (resource: Int) : String {
        return ApplicationProvider.application.resources.openRawResource(resource).bufferedReader().use { it.readText() }
    }
}