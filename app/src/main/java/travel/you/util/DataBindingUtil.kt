package travel.you.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("profileImage")
fun loadImage(view: ImageView, profileImage: String) {
    Glide.with(view.context)
        .load(profileImage)
        .into(view)
}

