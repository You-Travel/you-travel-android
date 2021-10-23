package travel.you.trip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import travel.you.databinding.FragmentBookmarksBinding

class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarksBinding.inflate(inflater)
        return binding.root
    }

}