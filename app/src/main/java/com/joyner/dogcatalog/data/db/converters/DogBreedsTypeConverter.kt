package com.joyner.dogcatalog.data.db.converters

import androidx.room.TypeConverter
import com.joyner.dogcatalog.data.server.RetrofitHelper.jsonAdapter

object DogBreedsTypeConverter {

    @TypeConverter
    @JvmStatic
    fun stringJsonToDogSubBreeds(value: String): List<String>? {
        return jsonAdapter.fromJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun dogSubBreedsToStringJson(value: List<String>): String {
        return jsonAdapter.toJson(value)
    }
}