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
import travel.you.R
import travel.you.databinding.CardMenuBinding

import travel.you.databinding.FragmentMenuBinding

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

        var plases = listOf<String>("")

        for (i in 1..6) {
            var cardBinding = CardMenuBinding.inflate(LayoutInflater.from(context))
            cardBinding.txtName
        }

        Glide.with(this)
            .asBitmap()
            .load("https://www.11zon.com/images/home_icons/home_android_icon.png")
            .into(object : CustomTarget<Bitmap>(){
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    //binding..setImageBitmap(resource)
                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    // this is called when imageView is cleared on lifecycle call or for
                    // some other reason.
                    // if you are referencing the bitmap somewhere else too other than this imageView
                    // clear it here as you can no longer have the bitmap
                }
            })

        return binding.root
    }


}