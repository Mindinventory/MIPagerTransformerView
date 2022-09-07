package com.mindinventory.mipagertransformer

import com.mindinventory.mipagertransformer.adapter.PagerAdapter
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.viewpager2.widget.ViewPager2
import com.mindinventory.mipagertransformer.databinding.ViewLayoutBinding
import com.mindinventory.mipagertransformer.data.MIPagerTransformerItem
import com.mindinventory.mipagertransformer.utils.CustomDivider
import com.mindinventory.mipagertransformer.utils.Transformer

class MIPagerTransformerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private lateinit var binding: ViewLayoutBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var customDivider: CustomDivider
    private lateinit var transformer: Transformer
    private var orientation = ViewPager2.ORIENTATION_VERTICAL
    private lateinit var handleImage: ImageView
    private lateinit var textMeasureView: TextView
    private lateinit var tvImageInfo: TextView
    private lateinit var adapter: PagerAdapter


    fun setTransformerItems(context: Context, transformerItems: List<MIPagerTransformerItem>) {

        binding = ViewLayoutBinding.inflate(LayoutInflater.from(context), this, true)
        viewPager = binding.rootViewPager
        handleImage = binding.ivStar
        textMeasureView = binding.textView2
        tvImageInfo = binding.tvImageInfo
        initAdapter(transformerItems)
    }

    private fun initAdapter(list: List<MIPagerTransformerItem>) {
        if (!this::adapter.isInitialized) {

            adapter =
                PagerAdapter(
                    list
                )
            viewPager.adapter = adapter
            viewPager.orientation = orientation
            viewPager.setPageTransformer(adapter.getPageTransformer())

        } else {
            adapter.setDrawables(list)
        }
    }


    fun setPageTransformer(transformer: Transformer) {
        this.transformer = transformer
        adapter.setTransformer(transformer)
    }


    fun setShowDivider(show: Boolean, dividerColor: Int) {

        if (show) {
            val divider = ContextCompat.getDrawable(context, R.drawable.ic_divider_new)

            val mode = BlendModeCompat.SRC_ATOP
            divider?.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                dividerColor,
                mode
            )
            customDivider = divider?.let {
                CustomDivider(
                    adapter.transformOrientation,
                    dividerColor
                )
            }!!
            if (viewPager.itemDecorationCount == 0) {
                viewPager.addItemDecoration(customDivider)
            }

        } else {
            removeDecor()
        }
    }


    private fun removeDecor() {
        if (viewPager.itemDecorationCount != 0) {
            viewPager.removeItemDecoration(customDivider)
        }
    }


    fun setInputEnabled(value: Boolean) {
        viewPager.isUserInputEnabled = value
    }
}