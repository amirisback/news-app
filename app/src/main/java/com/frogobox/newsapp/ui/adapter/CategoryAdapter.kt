package com.frogobox.newsapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import com.frogobox.recycler.adapter.FrogoRecyclerViewAdapter
import com.frogobox.recycler.adapter.FrogoRecyclerViewHolder
import kotlinx.android.synthetic.main.content_category.view.*

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * NewsApp
 * Copyright (C) 02/04/2020.
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
class CategoryAdapter : FrogoRecyclerViewAdapter<String>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrogoRecyclerViewHolder<String> {
        return CategoryViewHolder(viewLayout(parent))
    }

    inner class CategoryViewHolder(view: View) : FrogoRecyclerViewHolder<String>(view) {

        private val tvCategory = view.tv_category

        override fun initComponent(data: String) {
            super.initComponent(data)

            tvCategory.text = data

        }
    }

}