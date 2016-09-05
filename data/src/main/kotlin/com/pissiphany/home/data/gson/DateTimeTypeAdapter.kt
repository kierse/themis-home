package com.pissiphany.home.data.gson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.joda.time.DateTime
import java.lang.reflect.Type

/**
 * Created by kierse on 2016-09-04.
 */
class DateTimeTypeAdapter : JsonDeserializer<DateTime> {
    override fun deserialize(
            json: JsonElement?, type: Type?, context: JsonDeserializationContext?
    ): DateTime? {
        return DateTime.parse(json?.asString)
    }
}