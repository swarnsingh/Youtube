package com.swarn.youtube

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter

class DetailsDescriptionPresenter : AbstractDetailsDescriptionPresenter() {

    override fun onBindDescription(
        viewHolder: AbstractDetailsDescriptionPresenter.ViewHolder,
        item: Any
    ) {
        val movie = item as Video

        viewHolder.title.text = movie.title
        viewHolder.subtitle.text = movie.studio
        viewHolder.body.text = movie.description
    }
}