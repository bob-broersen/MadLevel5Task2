package com.broersen.madlevel5task2.model

import androidx.room.TypeConverter
import java.time.LocalDate

class Converters {

    @TypeConverter
    fun dateToLong(date: LocalDate?): String? {
        return date.toString()
    }

    @TypeConverter
    fun stringToDate(date: String?): LocalDate? {
        val dateArray = date?.split('-')
        return LocalDate.of(dateArray?.get(0)!!.toInt(), dateArray[1].toInt(), dateArray[2].toInt())
    }

}