package com.pissiphany.home.data.response

import com.pissiphany.home.domain.model.Matter
import com.pissiphany.home.data.ThemisApiV2RetrofitService
import org.joda.time.DateTime

/**
 * Created by kierse on 2016-08-30.
 */
class MatterListResponse : ThemisApiV2RetrofitService.ListResponse<Matter> {
    private val matters: List<Matter>

    constructor(records: Int, limit: Int, nextOffset: Long, orderDir: String, publishedAt: DateTime, matters: List<Matter>)
    : super(records, limit, nextOffset, orderDir, publishedAt) {
        this.matters = matters
    }

    override fun list(): List<Matter> = matters
}
