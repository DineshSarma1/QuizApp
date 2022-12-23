package com.dinesh.quizappassignment7.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun fromStringArrayList(value: MutableList<String>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toStringArrayList(value: String): MutableList<String> {
        return Gson().fromJson(value)
    }
}

private fun <T> Gson.fromJson(json: String): T = fromJson<T>(json, object : TypeToken<T>() {}.type)
