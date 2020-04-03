package com.frogobox.newsapp.base

import com.google.gson.Gson

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * NewsApp
 * Copyright (C) 03/04/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.newsapp
 *
 */

open class BaseHelper {

    fun <T> baseToJson(model: T) : String? {
        return Gson().toJson(model)
    }

    inline fun <reified T> baseFromJson(word: String?) : T {
        return Gson().fromJson<T>(word, T::class.java)
    }

}