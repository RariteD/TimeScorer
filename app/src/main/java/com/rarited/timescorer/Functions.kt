package com.rarited.timescorer

import com.rarited.timescorer.data.TSDataEntity

class Functions {
    fun GetDataFromDatabase(): TSDataEntity {
        val data = TSDataEntity("haha", null, null)
        return data
    }
}