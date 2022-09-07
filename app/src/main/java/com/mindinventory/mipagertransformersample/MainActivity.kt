package com.mindinventory.mipagertransformersample

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mindinventory.mipagertransformer.data.MIPagerTransformerItem
import com.mindinventory.mipagertransformer.utils.Transformer
import com.mindinventory.mipagertransformersample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var position = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val image1 = ContextCompat.getDrawable(this, R.drawable.sampl1)
        val image2 = ContextCompat.getDrawable(this, R.drawable.sampl2)

        val transformerItems: ArrayList<MIPagerTransformerItem> = ArrayList()

        image1?.let { transformerItems.add(MIPagerTransformerItem(image1, "Image 1 description")) }
        image2?.let { transformerItems.add(MIPagerTransformerItem(image2, "Image 2 description")) }

        binding.miPagerTransformerView.setTransformerItems(this, transformerItems)
        binding.miPagerTransformerView.setShowDivider(true, Color.WHITE)
        binding.miPagerTransformerView.setInputEnabled(true)

        binding.tvStyleName.text = Transformer.values()[0].name

        binding.ivRightArrow.setOnClickListener(this)
        binding.ivLeftArrow.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {

            binding.ivLeftArrow.id -> {
                val listOfStyles = resources.getIntArray(R.array.transformStyles)
                if (position != 0) {
                    position -= 1
                    val styleNames = resources.getStringArray(R.array.transformStyles)
                    binding.tvStyleName.text = styleNames[position]
                    "$position / ${listOfStyles.size - 1}".also { binding.tvStyleNumber.text = it }
                    binding.miPagerTransformerView.setPageTransformer(Transformer.values()[position])
                }
            }
            binding.ivRightArrow.id -> {
                val listOfStyles = resources.getIntArray(R.array.transformStyles)

                if (position < listOfStyles.size - 1) {
                    position += 1
                    val styleNames = resources.getStringArray(R.array.transformStyles)
                    binding.tvStyleName.text = styleNames[position]
                    "$position / ${listOfStyles.size - 1}".also { binding.tvStyleNumber.text = it }
                    binding.miPagerTransformerView.setPageTransformer(Transformer.values()[position])
                }
            }
        }
    }
}






