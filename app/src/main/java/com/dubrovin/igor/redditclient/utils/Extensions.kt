@file: JvmName ("ExtensionsUtils")

package com.dubrovin.igor.redditclient.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImage(imageUrl: String){
    Picasso.with(context)
            .load(imageUrl)
            .into(this)
}