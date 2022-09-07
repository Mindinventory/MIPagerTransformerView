package com.mindinventory.mipagertransformer.utils

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mindinventory.mipagertransformer.R


class CustomDivider(
    /**
     *  Overkill
     */
    /*val dividerHeight: Int,*/
    private val orientation: TransformOrientation,
    private val dividerColor: Int
) :
    RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        rect: Rect,
        view: View,
        parent: RecyclerView,
        s: RecyclerView.State
    ) {
        parent.getChildAdapterPosition(view)
            .let { if (it == RecyclerView.NO_POSITION) return else it }
        if (orientation == TransformOrientation.VERTICAL) {
            rect.top = 20
        } else {
            rect.right = 20
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        val ivPlaceholder = parent.findViewById<ImageView>(R.id.ivItemImage)

        val rect = Rect(100, 100, canvas.width - 100, ivPlaceholder.height)
        canvas.clipRect(rect)
        canvas.drawColor(dividerColor)
    }
}