package travel.you.menu

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import travel.you.App
import travel.you.databinding.CardMenuBinding

import travel.you.databinding.FragmentMenuBinding

import android.graphics.drawable.BitmapDrawable

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater)
        viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)

        viewModel.places.observe(this, {
            it.forEach {
                var cardBinding = CardMenuBinding.inflate(LayoutInflater.from(context))
                cardBinding.txtName.text = it.name
                cardBinding.rating.rating = ((it.rate) as Float)/10

                Glide.with(this)
                    .asBitmap()
                    .load(App.URL + "/files/" + it.pic)
                    .into(object : CustomTarget<Bitmap>(){
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            cardBinding.container.background = BitmapDrawable(resources, resource)
                        }
                        override fun onLoadCleared(placeholder: Drawable?) {
                        }
                    })
                binding.gridCards.addView(cardBinding.root)
            }
        })
        return binding.root
    }


}