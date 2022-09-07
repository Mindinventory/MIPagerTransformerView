package com.mindinventory.mipagertransformer.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.mindinventory.mipagertransformer.R
import com.mindinventory.mipagertransformer.databinding.ItemLayoutBinding
import com.mindinventory.mipagertransformer.data.MIPagerTransformerItem
import com.mindinventory.mipagertransformer.utils.TransformOrientation
import com.mindinventory.mipagertransformer.utils.Transformer


class PagerAdapter(
    private val transformerItems: List<MIPagerTransformerItem>
) :
    RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {

    private lateinit var binding: ItemLayoutBinding
    private var listOfDrawables: List<MIPagerTransformerItem> = ArrayList()
    private var type: Transformer = Transformer.SHUTTER
    var transformOrientation: TransformOrientation = TransformOrientation.VERTICAL
    private var thisPosition: Int = 0


    override fun getItemCount() = transformerItems.size


    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {

        this.thisPosition = holder.adapterPosition
        binding.ivItemImage.setImageDrawable(transformerItems[position].drawable)
    }


    class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding.root)
    }

    fun setDrawables(list: List<MIPagerTransformerItem>) {
        val oldList = listOfDrawables.size
        val newList = list.size
        listOfDrawables = list
        notifyItemRangeRemoved(0, oldList)
        notifyItemRangeInserted(0, newList)
    }


    fun setTransformer(transformer: Transformer) {
        type = transformer
    }

    fun getPageTransformer(): ViewPager2.PageTransformer {
        return MiPageTransformer()
    }


    inner class MiPageTransformer :
        ViewPager2.PageTransformer {
        @SuppressLint("ClickableViewAccessibility")
        override fun transformPage(page: View, position: Float) {

            val image = page.findViewById<ImageView>(R.id.ivItemImage)
            val pageTop = page.top

            page.apply {


                if (position <= 1 && position >= -1) {

                    /**
                     *   Resetting the image rotation and/or translation
                     */

                    image.restoreToOriginalState()

                    when (type) {


                        Transformer.SHUTTER -> {

                            if (transformOrientation == TransformOrientation.VERTICAL) {


                                image.translationY = -height * position


                            } else {
                                image.translationX = position * (-width)
                            }

                        }
                        Transformer.PARALLAX -> {
                            if (transformOrientation == TransformOrientation.VERTICAL) {
                                image.translationY = position * (-height) / 2

                            } else {
                                image.translationX = position * (-width)
                            }

                        }
                        Transformer.FOLD_N_OPEN -> {
                            if (transformOrientation == TransformOrientation.VERTICAL) {

                                image.translationY = (position * 2) * (-height)
                            } else {
                                image.translationX = position * (-width) / 2
                            }

                        }
                        Transformer.STRINGS_LEFT -> {
                            if (transformOrientation == TransformOrientation.VERTICAL) {
                                image.translationY = position * -height
                                image.translationX = position * (-width * position)
                            } else {
                                image.translationX = position * (-width * 2)
                            }

                        }
                        Transformer.CARD_DRAW -> {

                            if (transformOrientation == TransformOrientation.VERTICAL) {

                                image.translationY = (position * (-height + pageTop))
                            } else {
                                image.translationX = position * (-width)
                            }


                        }
                        Transformer.CLOCK_SPIN -> {

                            if (transformOrientation == TransformOrientation.VERTICAL) {

                                image.translationY = -height * position
                                image.rotation = (position * -height) / 8

                            } else {
                                image.translationX = position * (-width)
                            }


                        }
                        Transformer.FRAME_BY_FRAME -> {

                            if (transformOrientation == TransformOrientation.VERTICAL) {

                                image.translationX = position * (-width)
                                image.rotation = (position * -height) / 8
                            } else {
                                image.translationX = position * (-width)
                            }

                        }
                        Transformer.COUNTER_CLOCK_SPIN -> {

                            if (transformOrientation == TransformOrientation.VERTICAL) {


                                image.translationY = -height * position
                                image.rotation = (position * height) / 8
                            } else {
                                image.translationX = position * (-width)
                            }

                        }
                        Transformer.OVER_SPIN -> {

                            if (transformOrientation == TransformOrientation.VERTICAL) {


                                image.translationY =
                                    ((-height)) * position

                                image.rotation = (position * position * position * -height) / 8


                            } else {
                                image.translationX = position * (-width)
                            }

                        }
                        Transformer.STRINGS_RIGHT -> {

                            if (transformOrientation == TransformOrientation.VERTICAL) {

                                image.translationX =
                                    position * position * position * position * width
                                image.translationY = (position * -height)
                            } else {
                                image.translationX = position * (-width)
                            }

                        }
                        Transformer.DUAL_SHUTTER -> {

                            if (transformOrientation == TransformOrientation.VERTICAL) {

                                image.translationX = (position * position * position * width)
                                image.translationY = (position * position * position) * -height
                                image.rotation = ((position * position * position) * -height) / 8
                            } else {
                                image.translationX = position * (-width)
                            }

                        }
                    }
                }
            }
        }

        private fun ImageView.restoreToOriginalState() {
            this.rotation = 0F
            this.translationX = 0F
            this.translationY = 0F
        }
    }

}

